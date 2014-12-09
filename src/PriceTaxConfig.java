import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;


public class PriceTaxConfig {
	static HashMap<String, Double> map = new HashMap<String, Double>();
	
	public HashMap<String, Double> setPriceTax(HashMap<String, Double> someMap){
		someMap.put("Soda", 0.00);
		someMap.put("Small Regular", 0.00);
		someMap.put("Medium Regular", 0.00);
		someMap.put("Large Regular", 0.00);
		someMap.put("Small Specialty", 0.00);
		someMap.put("Medium Specialty", 0.00);
		someMap.put("Large Specialty", 0.00);
		someMap.put("Toppings", 0.00);
		someMap.put("Tax Rate", 0.00);
		
		return someMap;
	}
	
	public HashMap<String, Double> editTaxRate(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Tax Rate", newPrice);
		return someMap;
	}
	
	public HashMap<String, Double> editToppings(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Toppings", newPrice);
		return someMap;
	}

	public HashMap<String, Double> editSoda(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Soda", newPrice);
		return someMap;
	}
	
	public HashMap<String, Double> editSmallRegular(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Small Regular", newPrice);
		return someMap;
	}
	
    public HashMap<String, Double> editMediumRegular(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
    	someMap.remove(oldPrice);
		someMap.put("Medium Regular", newPrice);
		return someMap;
	}
    
	public HashMap<String, Double> editLargeRegular(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Large Regular", newPrice);
		return someMap;
	}
	
	public HashMap<String, Double> editSmallSpecialty(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Small Specialty", newPrice);
		return someMap;
	}
	
    public HashMap<String, Double> editMediumSpecialty(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
    	someMap.remove(oldPrice);
		someMap.put("Medium Specialty", newPrice);
		return someMap;
	}
    
	public HashMap<String, Double> editLargeSpecialty(HashMap<String, Double> someMap, Double oldPrice, Double newPrice){
		someMap.remove(oldPrice);
		someMap.put("Large Specialty", newPrice);
		return someMap;
	}

	public void outputMap(HashMap<String, Double> someMap){
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
	public HashMap<String, Double> inputMap(){
		try{
			FileReader file = new FileReader("storedPriceTax.txt");
			BufferedReader input = new BufferedReader(file);
			
			String line = "";
	        while ((line = input.readLine()) != null) {
	            String[] parts = line.split("=");
	            map.put(parts[0], Double.valueOf(parts[1]));
	        }	
	        
	        input.close();
		}catch(IOException ioe){
			ioe.printStackTrace();
	    }catch(Exception fnf){
	    	fnf.printStackTrace();
	    }finally{
	    	return map;
	    }
	}
}
