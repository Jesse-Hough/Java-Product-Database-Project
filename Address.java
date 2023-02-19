public class Address {
	
	String street;
	String city;
	String state;
	String zip;
	
	Address(String strt, String city, String st, String zip) {
		
		street = strt;
		this.city = city;
		state = st;
		this.zip = zip;
		
	}
	
	String getStreet() {
		return street;
	}
	
	String getCity() {
		return city;
	}
	
	String getState() {
		return state;
	}
	
	String getZip() {
		return zip;
	}
}
