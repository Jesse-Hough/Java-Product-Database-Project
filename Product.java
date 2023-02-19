public class Product {
	
	String productName;
	String purchaseDate;
	int quantity;
	double productPrice;
	Manufacturer manFac;
	
	Product(String prodName, String date, int prodQuantity, double price, Manufacturer man) {
		
		productName = prodName;
		purchaseDate = date;
		quantity = prodQuantity;
		productPrice = price;
		manFac = man;
	}
	
	String getProductName() {
		return productName;
	}
	
	String getPurchaseDate() {
		return purchaseDate;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	Manufacturer getManufacturer() {
		return manFac;
	}
}
