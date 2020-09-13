
public class Object {
	String item;
	double costPrice;
	double sellingPrice;
	int quantity;

	public Object(String Item, double CostPrice, double SellingPrice, int quantity) {
		this.item = Item;
		this.costPrice = CostPrice;
		this.sellingPrice = SellingPrice;

		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
