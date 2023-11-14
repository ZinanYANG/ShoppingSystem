package depaul.edu.cart;

import java.util.ArrayList;
import java.util.List;

import depaul.edu.models.Product;

public class Cart {
	
	
	private static Cart instance;
    private List<Product> items;
    private double total; 
    private Cart() {
        items = new ArrayList<>(); 
        total = 0.0;
    }
    
    public static Cart getInstance() {
    	if(instance == null) {
    		instance = new Cart();
    	}
    	return instance;
    }


    public void addItem(Product product) {
        items.add(product);
        total += product.getPrice(); 
    }

    public boolean removeItem(Product product) {
        if(items.contains(product)){ 
            items.remove(product);  
            total -= product.getPrice();
            return true;
        }
        return false;
    }
    public List<Product> getItems() { 
        return items;
    }

    public double getTotal() {
        return total;
    }
    
    public int getQuantity() {
        return items.size();
    }
    public void clearCart() {
        items.clear();
        total = 0.0;
    }
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append("Cart Summary:\n\n");
    	for(Product product : items) {
            builder.append(product.toString()).append("\n");
    	}
        builder.append("Total: $").append(String.format("%.2f", total));
		return builder.toString();
    }
}

