public class Soda extends SalesItem {

	@Override
	public String toString() {
		String out;
		String qty = ((Integer) this.getQuantity()).toString();
		String total = "$" + String.format("%.2f", this.getTotal());
		
		out = String.format("%3s  %-18s%7s %n %n",
				qty, "  ", "2-Liter Soda", total);
		
		return out;
	}
}