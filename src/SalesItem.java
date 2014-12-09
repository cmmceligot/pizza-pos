public abstract class SalesItem {
	private int quantity;
	private double price;
	double total;
	
	public void setQuantity(int qty){
	    this.quantity = qty;
	    calcTotal();
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public double getPrice(){
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal(){
		return total;
	}

	public void calcTotal(){
		total = ((double) getQuantity()) * getPrice();
	}
	
	public abstract String toString();		
}