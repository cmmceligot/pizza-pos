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
    ArrayList<SalesItem> itemsOrdered = new ArrayList<SalesItem>();
	private int orderNumber = 0;
	private String employee = "";
	private double subtotal = 0;
	private double taxRate = 0;
	private double taxAmount = 0;
	private double grandTotal = 0;
	
	public Order() {
	}
	
	public String makeReceipt() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
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
	
	public void storeOrderNumber() {
		
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
			this.itemsOrdered.set(idx, tmpItem);
		} else {
			this.itemsOrdered.add(item);
		}
	}
	
	public void cancelOrder(){
		itemsOrdered.clear();
		subtotal = 0;
		taxAmount = 0;
		grandTotal = 0;
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
								&& ((Pizza) item).toppings.containsAll(((Pizza) x).toppings)
								&& ((Pizza) x).toppings.containsAll(((Pizza) item).toppings))
						|| item instanceof Soda) {
					return itemsOrdered.indexOf(x);
				}
			}
		}
		
		return -1;
	}
	
	///////////////////////////////
	///////////////////////////////
	
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
//				DEBUG
				System.out.println("First time setup " + orderNumber);
//				DEBUG
			}else{
				orderNumber = (Integer.parseInt(readOrderNumber()))+1;
				FileWriter write = new FileWriter(f);
				output = new BufferedWriter(write);
//				DEBUG
				System.out.println("Afterwards " + orderNumber);
//				DEBUG
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
			
			input.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
	    }catch(Exception fnf){
	    	fnf.printStackTrace();
	    }finally{
	    	return newOrderNumber;
	    }
	}
}