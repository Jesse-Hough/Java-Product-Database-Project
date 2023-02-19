import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestInventory {

	public static void main(String[] args) {
		
		//Creates a new database for products
		Database prodDb = new Database();
		//Creates a new database for deleted products
		Database deleteProd = new Database();
		DateFormat Df = DateFormat.getDateInstance(DateFormat.LONG);
        Date now = new Date();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        boolean done = false;

        while(!done) {
        	 int menu = GetData.getInt("\tABC Enterprise Inventory\n" + "\t" + Df.format(now) + "\n"
                     + "\nPlease Choose From the Following:" + "\n1. Add New Product\n2. Delete A Product "
                     + "\n3. Look Up Active Or Deleted Products");
        	 
        	 switch(menu) {
        	 	
        	 case 1://Creating a Product and storing it in Database
        		 	// Creating Product object
                String prodName = GetData.getString("Enter the name of the Product");
                String date = GetData.getString("Enter the products date");
                int quantity = GetData.getInt("Enter the quantity of the product");
                double productPrice = GetData.getDouble("Enter the price of the product");
                
                	// Creating Address 
                String strt = GetData.getString("Enter Street Name");
                String city = GetData.getString("Enter City");
                String st = GetData.getString("Enter State");
                String zip = GetData.getString("Enter Zip");
                
                	// Creating Manufacturer object
                String manufacturerName = GetData.getString("Enter the name of the manufacturer");
                Address addr = new Address(strt,city,st,zip);
                Manufacturer manFac = new Manufacturer(manufacturerName ,addr);
                Product name = new Product(prodName, date, quantity, productPrice, manFac);
                
                	// Add Product object to the database
                prodDb.add(name);
            break;
        	 case 2://Delete a product
                 prodName = GetData.getString("Which product would you like to delete? (Please enter product name)");
                 prodDb.search(prodName);
                 if (!prodDb.inList())
                     JOptionPane.showMessageDialog(null, "Product not found.");
                 else
                 {
                     Product product = prodDb.getProduct();
                     int index = prodDb.getIndex();
                     deleteProd.add( prodDb.delete(index) );
                     JOptionPane.showMessageDialog(null, "The product " + prodName + " has been deleted.");
                 }
             break;
        	 case 3: //View Products
                 int view = GetData.getInt("What information would you like to view?\n1. Single product\n2. Full Inventory Report\n3. All Deleted Products\n");
                 
                 switch(view)
                 {
                     case 1:  // View a single account
                     	prodName = GetData.getString("Which product would you like to view? (Please enter a product name)");
                     	prodDb.search(prodName);                   
		                    if(!prodDb.inList())
		                        JOptionPane.showMessageDialog(null, "Product not found.");
		                    else
		                    {
		                    	Product singleProduct = prodDb.getProduct();
		                    	String s = "Manufacturer:\t" + singleProduct.getManufacturer().getCompanyName() + "\t Quantity:" + singleProduct.getQuantity() ;
		                        JOptionPane.showMessageDialog(null, s, "Product " + singleProduct.getProductName() , JOptionPane.INFORMATION_MESSAGE); 
		                    }
		                 break;
		                 case 2: // View Inventory Report
		                 	ArrayList<Product> list = prodDb.getList();
		                 	if(list.isEmpty())
		                 		JOptionPane.showMessageDialog(null, "List is empty");
	                 		else
	                 		{
	                 			int i = 0, length = prodDb.getSize();
	                 			String s = "Product    Purchase Date    Quantity    Price    Manufacturer    State";
	                 			while(i < length)
	                 			{
	                 				Product prod = (Product)list.get(i);
	                 				s = s + "\n" + prod.getProductName() + "  " + prod.getPurchaseDate() + "  " + prod.getQuantity() + "  " +  prod.getProductPrice() + "  " 
	                 				+ prod.getManufacturer().getCompanyName() + "  " + prod.getManufacturer().getAddress().getState();
	                 				i++;
	                 			}
	                 			display(s, "Active Products", JOptionPane.INFORMATION_MESSAGE);
	                 		}
		                 break;
		                 case 3: // View all deleted products
		                  	ArrayList closed = deleteProd.getList();
		                 	
		                 	if(closed.isEmpty())
		                 		JOptionPane.showMessageDialog(null, "List is empty", "There are no deleted products", JOptionPane.ERROR_MESSAGE);
	                 		else
	                 		{
	                 			int i = 0, length = deleteProd.getSize();
	                 			String s = "Product    Date    Manufacturer";
	                 			while(i < length)
	                 			{
	                 				Product deletedProduct = (Product)closed.get(i);
	                 				s = s + "\n" + deletedProduct.getProductName() + "  " + deletedProduct.getPurchaseDate() + "  " + deletedProduct.getManufacturer().getCompanyName() + "\n";
	                 				i++;
	                 			}
	                 			display(s, "Closed Accounts", JOptionPane.INFORMATION_MESSAGE);
	                 		}
		                 break;
		                 default:
		                 		JOptionPane.showMessageDialog(null, "Invalid option.");
					 	 break;
                  }// End view
        	 }
        }
	}
	static void display(String s, String heading, int MESSAGE_TYPE)
    {
        JTextArea text = new JTextArea(s, 20, 30);
        JScrollPane pane = new  JScrollPane(text);
        JOptionPane.showMessageDialog(null, pane, heading, MESSAGE_TYPE);
    }

}
