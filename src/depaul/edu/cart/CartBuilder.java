/**
 * 
 */
package depaul.edu.cart;

import depaul.edu.catalog.ProductCatalog;
import depaul.edu.models.Product;
import depaul.edu.models.User;

/**
 * @author AlanYoung
 *
 */
public class CartBuilder {
	
	private final Cart cart;
    private User user; 
    private ProductCatalog productCatalog;

    
    public CartBuilder(ProductCatalog catalog) {
        this.cart = Cart.getInstance();
        this.productCatalog = catalog;
    }
    
    public CartBuilder addProduct(String productId) {
        Product product = productCatalog.getProduct(productId);
        if (product != null) {
            cart.addItem(product);
            System.out.println("successfully added the product into the cart!");
        } else {
            System.out.println("Product with ID " + productId + " not found in catalog.");
            throw new IllegalArgumentException();
        }
        return this;
    }
	
    public CartBuilder removeProduct(String productId) {
    	Product product = productCatalog.getProduct(productId);
        if (product != null && cart.getItems().contains(product)) {
            cart.removeItem(product);
            System.out.println("successfully removed the product from the cart!");

            } else {
            System.out.println("Product with ID " + productId + " not found in cart.");
            throw new IllegalArgumentException();
          }
        return this;
    }
    
    public CartBuilder setUser(User user) {
    	this.user = user; 
        return this;
    }
    
    public Cart finalizeCart() {
        return this.cart;
    }    
}
