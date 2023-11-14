package depaul.edu.catalog;

import depaul.edu.models.Book;
import depaul.edu.models.Product;
import depaul.edu.models.Speaker;

public class ProductFactory {

	public static Product getProduct(String type, String id, String name, double price, String description) throws IllegalArgumentException {
	    if (type == null || id == null || name == null || description == null) {
	        throw new IllegalArgumentException("Product attributes cannot be null.");
	    }
	    if (type.isEmpty() || id.isEmpty() || name.isEmpty() || description.isEmpty()) {
	        throw new IllegalArgumentException("Product attributes cannot be empty.");
	    }
	    if (price < 0) {
	        throw new IllegalArgumentException("Price cannot be negative.");
	    }
	    
	    if (type.equalsIgnoreCase("book")) {
	        return new Book(id, name, price, description);
	    } else if (type.equalsIgnoreCase("speaker")) {
	        return new Speaker(id, name, price, description);
	    } else {
	        throw new IllegalArgumentException("Unknown product type: " + type);
	    }
	}


}
