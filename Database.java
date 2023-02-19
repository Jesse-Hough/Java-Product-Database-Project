import java.util.ArrayList;

public class Database {
	
	ArrayList<Product> list;
	Product prdct;
	int index;
	boolean found;
	
	Database() {
        list = new ArrayList<Product>();
    }
	
	void add(Product b)
    {
        list.add(b);
    }
	
	void search(String key)
    {
        found = false;
        int i = 0;
        
        while(!found && i < list.size())
        {
            Product product = list.get(i);
            
            if(product.getProductName().equalsIgnoreCase(key)){
                prdct = product;
                found = true;
                index=i;
            }
            else
                i++;
                   
        }
    }
	
	boolean inList()
    {
        return found;
    }
	
	Product getProduct()
    {
        return prdct;
    }
	
	public int getIndex()
    {
    	return index;
    }
	
	Product delete(int i)
    {
        return list.remove(i);
    }
	
	ArrayList<Product> getList()
    {
    	return list;
    }
	
    int getSize()
    {
        return list.size();
    }
	
}
