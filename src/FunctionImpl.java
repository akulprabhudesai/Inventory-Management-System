
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Vector;

public class FunctionImpl implements Function {
	Vector<Object> deletedobjects;
	Vector<Object> soldobjects;
	HashMap<String, Object> map;
	HashMap<String, Object> map1 = new HashMap<String, Object>();

	public static synchronized FunctionImpl returnFunctionImpl() {

		FunctionImpl instance = new FunctionImpl();

		return instance;
	}

	@Override
	public void create(String Item, double CostPrice, double SellingPrice) {
		Object objectisthere = Main.returnMain().returnMap().get(Item);
		if (objectisthere != null) {
			if (objectisthere.getCostPrice() == CostPrice && objectisthere.getSellingPrice() == SellingPrice) {
				throw new IllegalStateException("Error: Object with name " + Item + " is already present");
			}
		}
		Object object = new Object(Item, CostPrice, SellingPrice, 0);
		Main.returnMain().returnMap().put(Item, object);

	}

	@Override
	public void delete(String item) {
		Object object = Main.returnMain().returnMap().get(item);
		if (object == null) {
			throw new NoSuchElementException("Error: Object is not present");
		}
		Main.returnMain().returnVectordeleted().add(object);
		Main.returnMain().returnMap().remove(item);

	}

	@Override
	public void updateBuy(String Item, int quantity) {
		Object object = Main.returnMain().returnMap().get(Item);

		if (object == null) {
			throw new NoSuchElementException("Error: Object is not present");
		}
		int quantitypresent = object.getQuantity();
		if (quantitypresent > (quantitypresent + quantity)) {
			throw new IllegalStateException("Error:Insufficient quantity exists to sell");
		}
		System.out.println("previous quantity for " + Item + " was " + quantitypresent);
		object.setQuantity(quantitypresent + quantity);

	}

	@Override
	public void updateSell(String Item, int quantitycoming) {

		Object object = Main.returnMain().returnMap().get(Item);
		if (object == null) {
			throw new NoSuchElementException("Error: Object is not present");
		}

		double costPrice = object.getCostPrice();

		double sellPrice = object.getSellingPrice();

		int quantitypresent = object.getQuantity();
		int newquantity = quantitycoming;

		if (quantitypresent < quantitycoming) {

			throw new IllegalStateException("Error: Insufficient quantity exists to sell");

		}
		System.out.println("previous quantity for " + Item + " was " + quantitypresent);
		object.setQuantity(quantitypresent - quantitycoming);
		Object soldobject = new Object(Item, costPrice, sellPrice, newquantity);
		Main.returnMain().returnVector().add(soldobject);
	}

	@Override
	public void updateSellPrice(String Item, double SellingPrice) {
		Object object = Main.returnMain().returnMap().get(Item);
		if (object == null) {
			throw new NoSuchElementException("Error: Object is not present");
		}
		double sellprice = object.getSellingPrice();
		System.out.println("Previous selling price for " + Item + " is " + sellprice);
		object.setSellingPrice(SellingPrice);
		System.out.println("new selling price for " + Item + " is " + object.getSellingPrice());
	}
}
