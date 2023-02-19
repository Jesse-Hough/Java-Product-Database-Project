public class Manufacturer {
	
	String companyName;
	Address address;
	
	Manufacturer(String manufacturerName, Address addr) {
		
		companyName = manufacturerName;
		address = addr;
	}
	
	String getCompanyName() {
		return companyName;
	}
	
	Address getAddress()
    {
        return address;
    }
}
