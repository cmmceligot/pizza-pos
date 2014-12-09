import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;



public class EmployeeList {
	static HashMap<String, String> map = new HashMap<String, String>();
	
	public HashMap<String, String> addEmployee(HashMap<String, String> someMap, String pin, String name){
		someMap.put(pin, name);
		return someMap;
	}
	
	public HashMap<String, String> deleteEmployee(HashMap<String, String> someMap, String pin){
		someMap.remove(pin);
		return someMap;
	}
	
	public HashMap<String, String> editEmployee(HashMap<String, String> someMap, String oldPin, String newPin, String newName){
		someMap.remove(oldPin);
		someMap.put(newPin, newName);
		return someMap;
	}
	
	public void outputMap(HashMap<String, String> someMap){
		Iterator<String> keySetIterator = someMap.keySet().iterator();
		try{
			FileWriter file = new FileWriter("storedPins.txt");
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
			File f = new File("storedPins.txt");
			
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
