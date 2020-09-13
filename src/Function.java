public interface Function {
	 public void create (String Item, double CostPrice, double SellingPrice);
	 
	 public void delete(String item);
	 
	 public void updateBuy(String Item, int quantity);
	 
	 public void updateSell(String Item, int quantity);
	 
	 public void updateSellPrice(String Item, double SellingPrice);
     
}
