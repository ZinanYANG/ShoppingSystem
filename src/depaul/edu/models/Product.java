package depaul.edu.models;

/**
 * @author AlanYoung
 *
 */
public interface Product {
	public String getId() ;
	public void setId(String id);
	public String getName() ;
	public void setName(String name);
	public double getPrice() ;
	public void setPrice(double price) ;
	public String getDescription() ;
	public void setDescription(String description);
}
