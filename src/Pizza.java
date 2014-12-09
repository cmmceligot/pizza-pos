import java.util.EnumSet;

public class Pizza extends SalesItem {
	Size size;
	EnumSet<Topping> toppings;
	
	public Pizza() {	
	}
	
	public Pizza(Size size, EnumSet<Topping> toppings){
		this.size = size;
		this.toppings = toppings;
	}
	
	@Override
	public String toString() {
		//TODO string builder
		return ((Integer) getQuantity()).toString();
	}
}