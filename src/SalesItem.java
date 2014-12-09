public abstract class SalesItem {
	int quantity;
	
	public void setQuantity(int x){
	    quantity = x;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public abstract String toString();		
}

