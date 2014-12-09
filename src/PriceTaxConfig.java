import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;


public class PriceTaxConfig {
	static HashMap<String, String> map = new HashMap<String, String>();
	static NumberFormat formatter = new DecimalFormat("#0.00"); 
	
	public HashMap<String, String> editTaxRate(HashMap<String, String> someMap, String oldPrice, double newPrice){
		someMap.remove(oldPrice);
		String newTax = String.valueOf(newPrice);
		someMap.put("Tax Rate", newTax);
		return someMap;
	}
	
	public HashMap<String, String> editToppings(HashMap<String, String> someMap, String oldPrice, double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Toppings", formatter.format(newPrice));
		return someMap;
	}

	public HashMap<String, String> editSoda(HashMap<String, String> someMap, String oldPrice, double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Soda", formatter.format(newPrice));
		return someMap;
	}
	
	public HashMap<String, String> editSmallRegular(HashMap<String, String> someMap, String oldPrice, double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Small Regular", formatter.format(newPrice));
		return someMap;
	}
	
    public HashMap<String, String> editMediumRegular(HashMap<String, String> someMap, String oldPrice, double newPrice){
    	someMap.remove(oldPrice);
		someMap.put("Medium Regular", formatter.format(newPrice));
		return someMap;
	}
    
	public HashMap<String, String> editLargeRegular(HashMap<String, String> someMap, String oldPrice, double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Large Regular", formatter.format(newPrice));
		return someMap;
	}
	
	public HashMap<String, String> editSmallSpecialty(HashMap<String, String> someMap, String oldPrice, double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Small Specialty", String.valueOf(formatter.format(newPrice)));
		return someMap;
	}
	
    public HashMap<String, String> editMediumSpecialty(HashMap<String, String> someMap, String oldPrice, double newPrice){
    	someMap.remove(oldPrice);
		someMap.put("Medium Specialty", formatter.format(newPrice));
		return someMap;
	}
    
	public HashMap<String, String> editLargeSpecialty(HashMap<String, String> someMap, String oldPrice, double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Large Specialty", formatter.format(newPrice));
		return someMap;
	}

	public void outputMap(HashMap<String, String> someMap){
		Iterator<String> keySetIterator = someMap.keySet().iterator();
		try{
			FileWriter file = new FileWriter("storedPriceTax.txt");
			BufferedWriter output = new BufferedWriter(file);
	        while(keySetIterator.hasNext()){
	          String key = keySetIterator.next();
	          output.write(key + "=" + someMap.get(key) + " \n");
	        }
	        output.close();
		}catch(IOException e){
			e.printStackTrace();
	    }
	}
	
	@SuppressWarnings("finally")
	public HashMap<String, String> inputMap(){
		try{
			File f = new File("storedPriceTax.txt");

			if(f.exists()){
				FileReader file = new FileReader(f);
				BufferedReader input = new BufferedReader(file);
				
				String line = "";
		        while ((line = input.readLine()) != null) {
		            String[] parts = line.split("=");
		            map.put(parts[0], parts[1]);
		        }	
		        input.close();
			}else{
				f.createNewFile();
				FileReader file = new FileReader(f);
				BufferedReader input = new BufferedReader(file);
				
				String line = "";
		        while ((line = input.readLine()) != null) {
		            String[] parts = line.split("=");
		            map.put(parts[0], parts[1]);
		        }	
		        input.close();
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
	    }catch(Exception fnf){
	    	fnf.printStackTrace();
	    }finally{
	    	return map;
	    }
	}

}
