package depaul.edu.catalog;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import depaul.edu.models.Product;


public class ProductCatalog {
	private Map<String, Product> productMap;

	public ProductCatalog() {
		this.productMap = new HashMap<>();
	}

	public void addProduct(Product product) {
		productMap.put(product.getId(), product);
	}

	public void removeProduct(String productId) {
		if(productMap.containsKey(productId)) {
			productMap.remove(productId);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Product getProduct(String productId) {

			return productMap.get(productId);

	}

	public Collection<Product> getAllProducts() {
		return productMap.values();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Product Catalog:\n");
		for (Product product : getAllProducts()) {
			builder.append(product.toString()).append("\n");
		}
		return builder.toString();
	}

}
