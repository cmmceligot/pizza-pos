import java.util.EnumSet;

public class Pizza extends SalesItem {
	Size size;
	public EnumSet<Topping> toppings;
	double toppingsPrice;
	
	public Pizza() {	
	}
	
	public Pizza(Size size, EnumSet<Topping> toppings){
		this.size = size;
		this.toppings = toppings;
	}
	
	public double getToppingsPrice() {
		return toppingsPrice;
	}

	public void setToppingsPrice(double toppingsPrice) {
		this.toppingsPrice = toppingsPrice;
	}

	@Override
	public String toString() {
		String out;
		String strSize = "";
		String desc;
		String strTops = "";
		String qty = ((Integer) this.getQuantity()).toString();
		String total = "$" + String.format("%.2f", this.getTotal());
		
		if (size == Size.Small) {
			strSize = "Small";
		} else if (size == Size.Medium) {
			strSize = "Medium";
		} else {
			strSize = "Large";
		}
		
		desc = strSize + " Pizza";
		
		strTops += "\n";
		
		out = String.format("%3s  %-18s %7s %n",
				qty, desc, total) + strTops;
		
		return out;
	}
	
	@Override
	public void calcTotal() {
		super.total = ((double) getQuantity()) * getPrice()
				+ ((double) this.toppings.size()) * getToppingsPrice();
	}
}