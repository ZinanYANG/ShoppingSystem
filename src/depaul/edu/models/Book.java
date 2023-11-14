/**
 * 
 */
package depaul.edu.models;

/**
 * @author AlanYoung
 *
 */
public class Book implements Product{



	private String id;
	private String name;
	private double price;
	private String description;

	/**
	 * @param id
	 * @param name
	 * @param price
	 * @param description
	 */
	public Book(String id, String name, double price, String description) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
	    return "Product ID: " + id + "\n" +
	           "Name: " + name + "\n" +
	           "Price: $" + String.format("%.2f", price) + "\n" +
	           "Description: " + description+"\n";
	}
}
