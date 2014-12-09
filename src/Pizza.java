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
		
		switch (size) {
		case Small: strSize = "Small";
		case Medium: strSize = "Medium";
		case Large: strSize = "Large";
		}
		
		desc = strSize + " Pizza";
		
//		for (Topping topping : toppings) {
//			String tmp = "";
//			
//			switch (topping) {
//				case Bacon: tmp = "       + Bacon\n";
//				case BlackOlives: tmp = "       + Black Olives\n";
//				case Chicken: tmp = "       + Chicken\n";
//				case ExtraCheese: tmp = "       + Extra Cheese\n";
//				case GreenPeppers: tmp = "       + Green Peppers\n";
//				case Ham: tmp = "       + Ham\n";
//				case Mushrooms: tmp = "       + Mushrooms\n";
//				case Onions: tmp = "       + Onions\n";
//				case Pepperoni: tmp = "       + Pepperoni\n";
//				case Pineapple: tmp = "       + Pineapple\n";
//				case Sausage: tmp = "       + Sausage\n";
//			}
//		
//		
//			
//			strTops += tmp;
//		}
		
		strTops += "\n";
		
		out = String.format("%3s %2s %-18s %7s %n",
				qty, "  ", desc, total) + strTops;
		
		return out;
	}
	
	@Override
	public void calcTotal() {
		super.total = ((double) getQuantity()) * getPrice()
				+ ((double) this.toppings.size()) * getToppingsPrice();
	}
}