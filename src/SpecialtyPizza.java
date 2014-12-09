public class SpecialtyPizza extends Pizza{
	
	public SpecialtyPizza(Size size, String specialtyType){
		this.size = size;
		
		if(specialtyType.equals("Hawaiian")){
			this.toppings.add(Topping.Ham);
			this.toppings.add(Topping.Pineapple);
		} else if(specialtyType.equals("Meat Lovers'")){
			this.toppings.add(Topping.Pepperoni);
			this.toppings.add(Topping.Sausage);
			this.toppings.add(Topping.Ham);
			this.toppings.add(Topping.Bacon);
			this.toppings.add(Topping.Chicken);
		}
	}
	
	@Override
	public String toString() {
		//TODO string builder
		return ((Integer) getQuantity()).toString();
	}
}
