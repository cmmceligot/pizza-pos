import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.ArrayList;


public class Order{	
    static ArrayList<SalesItem> itemsOrdered = new ArrayList<SalesItem>();
	private int orderNumber = 1;
	private String employee = "";
	private double subtotal = 0;
	private double taxRate = 0;
	private double taxAmount = 0;
	private double grandTotal = 0;

	public Order() {
	}
	
	public void addItem(SalesItem item) {
		subtotal += item.total;
		taxAmount = subtotal * (taxRate / 100);
		grandTotal = subtotal + taxAmount;
		
		int idx = findItem(item);
		
		if (idx != -1) {
			SalesItem tmpItem = itemsOrdered.get(idx);
			tmpItem.setQuantity(tmpItem.getQuantity() + item.getQuantity());
			tmpItem.calcTotal();
			itemsOrdered.set(idx, tmpItem);
		} else {
			itemsOrdered.add(item);
		}
	}
	
	@SuppressWarnings("resource")
	public String makeReceipt() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		Writer output = null;
		
		try {
			File f = new File("orderNumber.txt");
		
			if(!f.exists()){
				f.createNewFile();
				FileWriter write = new FileWriter(f);
				output = new BufferedWriter(write);
				output.write("1");
				orderNumber = 1;
			} else {
				orderNumber = Integer.valueOf(readOrderNumber());
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		String out;
		String strOrderNum = " ORDER #" + String.format("%d", orderNumber);
		String strItems = "";
		String strTaxRate = "Tax (" + String.format("%.2f", taxRate) + "%)";
		String strSub = "Subtotal " + formatter.format(subtotal);
		String strTaxAmt = " " + formatter.format(taxAmount);
		String strTaxLine = strTaxRate + strTaxAmt;
		String strGrand = "Grand Total " + formatter.format(grandTotal);
		
		for (SalesItem item : itemsOrdered) {
			strItems += item.toString();
			
		}
		
		out = String.format("%s%n %-30s%n%n%s%n",
				strOrderNum, employee, " QTY  ITEM                PRICE")
			+ strItems
			+ String.format("%n%31s%n%31s%n%31s",
				strSub, strTaxLine, strGrand);
	
		return out;
	}
	
	public void cancelOrder(){
		itemsOrdered.clear();
		this.subtotal = 0;
		this.taxAmount = 0;
		this.grandTotal = 0;
	}
	
	public void setTaxRate(double tax) {
		this.taxRate = tax;
	}
	
	private int findItem(SalesItem item) {
		for (SalesItem x : itemsOrdered) {
			if (item.getClass().equals(x.getClass())) {
				if ((item instanceof SpecialtyPizza
						&& item.toString().regionMatches(6, x.toString(), 6, 8))
						|| (item instanceof Pizza
								&& ((Pizza) item).size.equals(((Pizza) x).size)
								&& ((Pizza) item).toppings.containsAll(((Pizza) x).toppings)
								&& ((Pizza) x).toppings.containsAll(((Pizza) item).toppings))
						|| item instanceof Soda) {
					return itemsOrdered.indexOf(x);
				}
			}
		}
		
		return -1;
	}
	
	@SuppressWarnings("finally")
	public int inputOrderNumber(){
		Writer output = null;
		try{
			File f = new File("orderNumber.txt");
			
			if(!f.exists()){
				f.createNewFile();
				FileWriter write = new FileWriter(f);
				output = new BufferedWriter(write);
				output.write("1");
				orderNumber = 1;
			}else{
				orderNumber = (Integer.parseInt(readOrderNumber()))+1;
				FileWriter write = new FileWriter(f);
				output = new BufferedWriter(write);
				output.write(String.valueOf(orderNumber));
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
	    }catch(Exception fnf){
	    	fnf.printStackTrace();
	    }finally{
	    	if(output != null){
	    		try{
	    			output.flush();
	    			output.close();
	    		}catch(IOException ignore){
	    			
	    		}
	    	}
	    	return orderNumber;
	    }
	}
	
	@SuppressWarnings("finally")
	public String readOrderNumber(){
		String newOrderNumber = "";
		try{
			File f = new File("orderNumber.txt");
			FileReader read = new FileReader(f);
			BufferedReader input = new BufferedReader(read);
			
			newOrderNumber = input.readLine();
			if(newOrderNumber.equals("1000")){
				FileWriter write = new FileWriter(f);
				BufferedWriter output = new BufferedWriter(write);
				output.write("1");
				output.close();
			}
			
			input.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
	    }finally{
	    	return newOrderNumber;
	    }
	}
}