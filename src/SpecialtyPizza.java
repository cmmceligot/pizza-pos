public class SpecialtyPizza extends Pizza{
	
	public SpecialtyPizza(Size size, String specialtyType){
		this.size = size;
		
		if(specialtyType.equals("Hawaiian")){
			this.toppings.add(Topping.Ham);
			this.toppings.add(Topping.Pineapple);
		}else if(specialtyType.equals("Meat Lovers'")){
			this.toppings.add(Topping.Pepperoni);
			this.toppings.add(Topping.Sausage);
			this.toppings.add(Topping.Ham);
			this.toppings.add(Topping.Bacon);
			this.toppings.add(Topping.Chicken);
		}
	}
	
	@Override
	public String toString() {
		String out;
		String strSize = "";
		String desc = "";
		String strTops = "";
		String qty = ((Integer) this.getQuantity()).toString();
		String total = "$" + String.format("%.2f", this.getTotal());
		
		if (size.equals(Size.Small)) {
			strSize = "Small";
		} else if (size.equals(Size.Medium)) {
			strSize = "Medium";
		} else {
			strSize = "Large";
		}
		
		if (this.toppings.size() == 2) {
			desc = strSize + " Hawaiian";
			
			strTops = "       + Ham\n"
					+ "       + Pineapple\n\n";
		} else {
			desc = strSize + " Meat Lovers'";
			
			strTops = "       + Pepperoni\n"
					+ "       + Sausage\n"
					+ "       + Ham\n"
					+ "       + Bacon\n"
					+ "       + Chicken\n";
		}
		
		out = String.format("%3s  %-18s %7s %n",
				qty, desc, total) + strTops;
		
		return out;
	}
	
	@Override
	public void calcTotal(){
		super.total = ((double) getQuantity()) * getPrice();
	}
}