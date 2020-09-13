
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class Main extends FunctionImpl {
	private static HashMap<String, Object> map = new HashMap<String, Object>();
	Vector<Object> soldobjects = new Vector<Object>();
	Vector<Object> deletedobjects = new Vector<Object>();
	private static Main instance = null;
	private static String value;
	public Main() {
		
	}
	 public static synchronized Main returnMain() {
	        if (instance == null) {
	            instance = new Main();
	        }
	        return instance;
	    }
	
	 public HashMap<String, Object> returnMap() {
	        return map;
	    }
	
	 public Vector<Object> returnVector() {
	        return soldobjects;
	    }
	 public Vector<Object> returnVectordeleted() {
	        return deletedobjects;
	    }
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Inventory Management System");
		System.out.println("Please choose from following:");
        System.out.println(" ");
		System.out.println("1.  create itemName costPrice sellingPrice --> For creating new object");
		System.out.println(" ");
		System.out.println("2.  delete itemName                        --> For removing object");
		System.out.println(" ");
		System.out.println("3.  updateBuy itemName quantity            --> For increasing quantity of object after purchased additional quantity");
		System.out.println(" ");
		System.out.println("4.  updateSell itemName quantity           --> For reducing quantity of object after sold");
		System.out.println(" ");
        System.out.println("5.  updateSellPrice itemName newSellPrice  --> For changing selling price of particular object");
        System.out.println(" ");
        System.out.println("6.  report --> To generate the report");
        System.out.println(" ");
		
        Main function = new Main();
		while(true) {
		Scanner input = new Scanner(System.in);
		String command = input.nextLine();
		String[] commandToArray = command.split(" ");
		
		if(commandToArray[0].equals("create") && commandToArray.length == 4) {
			try {
				value = commandToArray[1];
				function.create(value, Double.parseDouble(commandToArray[2]), Double.parseDouble(commandToArray[3]));
			System.out.println("Object created successfully");
			
			continue;
			} catch(IllegalStateException e) {
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("Invalid command, Please try again");
			}
			
		}
		
		else if(commandToArray[0].equals("delete") && commandToArray.length == 2) {
			try {
			
		    value = commandToArray[1];
		    function.delete(value);
		    System.out.println("Object removed successfully");
			continue;
			}
			catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				continue;
			} catch(Exception e) {
				System.out.println("Invalid command, Please try again.");
			}
		}	
			
		
        
		else if(commandToArray[0].equals("updateBuy") && commandToArray.length == 3) {
			    try {
			    value = commandToArray[1];
			    function.updateBuy(value, Integer.parseInt(commandToArray[2]));
			    System.out.println("current quantity is " + map.get(value).quantity);
				continue;
			    } catch(NoSuchElementException e) {
        	    	System.out.println(e.getMessage());
			    	continue;
        	    } catch(IllegalStateException e) {
        	    	System.out.println(e.getMessage());
			    	continue;
        	    } catch (Exception e) {
        	    	System.out.println("Invaid command, Please try again.");
        	    }
        }
        
        
        else if(commandToArray[0].equals("updateSell") && commandToArray.length == 3) {
        	    try {
			    value = commandToArray[1];
			    function.updateSell(value, Integer.parseInt(commandToArray[2]));
			    
			    System.out.println("current quantity is " + map.get(value).quantity);
				continue;
        	    } catch(NoSuchElementException e) {
        	    	System.out.println(e.getMessage());
			    	continue;
        	    } catch(IllegalStateException e) {
        	    	System.out.println(e.getMessage());
			    	continue;
        	    } catch (Exception e) {
        	    	System.out.println("Invaid command, Please try again.");
        	    }
        }
        
        else if(commandToArray[0].equals("report") && commandToArray.length == 1) {
        	
            ReportImpl report = new ReportImpl();
            report.report();
         
        }
		
        else if(commandToArray[0].equals("updateSellPrice") && commandToArray.length == 3) {
        	try {
        		value = commandToArray[1];
        		function.updateSellPrice(value, Double.parseDouble(commandToArray[2]));
        		
        	} catch(Exception e) {
        		System.out.println(e.getMessage());
        	}
        }
        else {
        	System.out.println("Invalid command, Please try Again");
        	continue;
        }
	
	   }
	}

}
