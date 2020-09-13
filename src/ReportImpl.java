import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

public class ReportImpl implements Report{
	HashMap<String, Object> map;
	Vector<Object> deletedobjects;
	Vector<Object> soldobjects;
	
    public void report() {
	map = Main.returnMain().returnMap();
	TreeMap<String, Object> sorted = new TreeMap<>(map);
	   
	double value1 = 0;
	System.out.println(String.format("%25s", "INVENTORY REPORT"));
	System.out.println(String.format("%-12s %-12s %-10s %-21s %-15s", "item Name", "Bought At", "Sold At", "Available Quantity", "value"));
	System.out.println(String.format("%-12s %-12s %-10s %-21s %-22s", "---------", "---------", "-------", "------------------", "-----"));

	for (String key : sorted.keySet()) {
		double value = sorted.get(key).costPrice * sorted.get(key).quantity;
        System.out.println(String.format("%-12s %-12s %-12s %-20s %-12s", sorted.get(key).item, sorted.get(key).costPrice, sorted.get(key).sellingPrice, sorted.get(key).quantity, value));
		value1 = value1 + value; 
	}
	System.out.println("----------------------------------------------------------------");
	
	System.out.println(String.format("%-59s %s", "Total Value",(float) value1));
	
	
	float profit =(float) calculateProfit();
	System.out.println(String.format("%-59s %s", "Profit since previous report", profit));
	Main.returnMain().returnVector().removeAllElements();
    }
	
    public double calculateProfit() {
	soldobjects = Main.returnMain().returnVector();
	deletedobjects = Main.returnMain().returnVectordeleted();
	double profit = 0;
	
	for(int i = 0; i < soldobjects.size();i++) {
		
		double amount = (soldobjects.get(i).getSellingPrice() - soldobjects.get(i).getCostPrice());
		amount = amount * soldobjects.get(i).getQuantity();
		
		profit = profit + amount;
		
	}
       for(int i = 0; i < deletedobjects.size();i++) {
		double amount = deletedobjects.get(i).getCostPrice() * deletedobjects.get(i).getQuantity();
		profit = profit - amount;
	}
	return profit;
}
}
