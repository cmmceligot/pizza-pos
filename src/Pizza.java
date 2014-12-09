import java.util.EnumSet;

public class Pizza extends SalesItem {
	Size size;
	public EnumSet<Topping> toppings;
	double toppingsPrice;
	
	public Pizza() {
		size = Size.Small;
		toppings = EnumSet.of(Topping.Ham);
		toppings.clear();
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
		
		if (this.toppings.contains(Topping.Bacon)) {
			strTops += "       + Bacon\n";
		}
		if (this.toppings.contains(Topping.BlackOlives)) {
			strTops += "       + Black Olives\n";
		}
		if (this.toppings.contains(Topping.Chicken)) {
			strTops += "       + Chicken\n";
		}
		if (this.toppings.contains(Topping.ExtraCheese)) {
			strTops += "       + Extra Cheese\n";
		}
		if (this.toppings.contains(Topping.GreenPeppers)) {
			strTops += "       + Green Peppers\n";
		}
		if (this.toppings.contains(Topping.Ham)) {
			strTops += "       + Ham\n";
		}
		if (this.toppings.contains(Topping.Mushrooms)) {
			strTops += "       + Mushrooms\n";
		}
		if (this.toppings.contains(Topping.Onions)) {
			strTops += "       + Onions\n";
		}
		if (this.toppings.contains(Topping.Pepperoni)) {
			strTops += "       + Pepperoni\n";
		}
		if (this.toppings.contains(Topping.Pineapple)) {
			strTops += "       + Pineapple\n";
		}
		
		if (this.toppings.contains(Topping.Sausage)) {
			strTops += "       + Sausage\n";
		}
		
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