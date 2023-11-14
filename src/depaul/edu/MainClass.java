package depaul.edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import depaul.edu.authentication.Authenticator;
import depaul.edu.cart.Cart;
import depaul.edu.cart.CartBuilder;
import depaul.edu.catalog.ProductCatalog;
import depaul.edu.catalog.ProductFactory;
import depaul.edu.models.User;
import depaul.edu.payment.MockPaymentGateway;
import depaul.edu.payment.OrderConfirmation;
import depaul.edu.payment.PaymentProcessor;
import depaul.edu.utilities.StdOut;

public class MainClass {

	public static void main(String[] args) {
		ProductCatalog catalog = new ProductCatalog();
		catalogInitializaiton(catalog);
		CartBuilder cartBuilder = new CartBuilder(catalog);	
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Please create a username: ");
	    String username = scanner.nextLine();
	    System.out.print("Please create a password: ");
	    String password = scanner.nextLine();	    
		Authenticator authenticator = new Authenticator();
		User user = new User(username, password); 
		authenticator.setUser(user);
	    boolean success = false;
	    while (!success) {
	        System.out.print("Enter username: ");
	        String usernameEntered = scanner.nextLine();
	        System.out.print("Enter password: ");
	        String passwordEntered = scanner.nextLine();

	        success = authenticator.login(usernameEntered, passwordEntered);
	        if (success) {
	            System.out.println("Login successful!\n");
				 interactWithUser(cartBuilder, catalog, scanner);

	        } else {
	            System.out.println("Login failed. Please try again.");
	        }
	    }
	    
	    scanner.close();
	}
	
	public static void catalogInitializaiton(ProductCatalog catalog) {		
		 String filePath = "data/product.txt";

	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	String[] values = line.split("\t");
	            	String type = values[0];
	            	String id= values[1];
	            	String name = values[2];
	            	double price = Double.parseDouble(values[3]);
	            	String description = values[4];	          
	            	catalog.addProduct(ProductFactory.getProduct(type, id, name, price, description));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }        
	}
	
	public static void interactWithUser(CartBuilder cartBuilder, ProductCatalog catalog, Scanner scanner) {
		
		
        boolean done = false;
        while (!done) {
        	 System.out.println("Your Cart: \n" + cartBuilder.finalizeCart());
             System.out.println("Choose an option:");
        	 System.out.println("0. displaying catalog: ");
             System.out.println("1. Add a product");
             System.out.println("2. Remove a product");
             System.out.println("3. Finalize cart and proceed to payment");
             System.out.println("4. Exit.");
             System.out.print("Enter option: ");

        String option = scanner.nextLine();
        switch (option) {
        case "0":
        	StdOut.println(catalog.toString()+"there are total "+catalog.getAllProducts().size()+" products at the catalog.");
            break;
        case "1":
            System.out.print("Enter the product ID to add: ");
            String addId = scanner.nextLine();
            if(catalog.getProduct(addId)==null) {
            	StdOut.println("product with id "+addId+" doesn't exist, returning main menu...");
            	break;
            }
            cartBuilder.addProduct(addId);
			StdOut.println("cart size : "+cartBuilder.finalizeCart().getQuantity());
            break;
        case "2":
            System.out.print("Enter the product ID to remove: ");
            String removeId = scanner.nextLine();
            Cart cart = Cart.getInstance();
            
            if(!cart.getItems().contains(catalog.getProduct(removeId))) {
            	StdOut.println("product with id "+removeId+" doesn't exist in your cart , returning main menu...");
            	break;
            };
            cartBuilder.removeProduct(removeId);       
			StdOut.println("cart size : "+cartBuilder.finalizeCart().getQuantity());

			
            break;
        case "3":
			System.out.print("Do you want to place the order ? (yes/no): ");
            String orderResponse = scanner.nextLine();
            if ("yes".equalsIgnoreCase(orderResponse)) {
            	
    			System.out.println(cartBuilder.finalizeCart().toString());
    			
    			StdOut.println("catalog size : "+catalog.getAllProducts().size());
    			StdOut.println("cart size : "+cartBuilder.finalizeCart().getQuantity());

            	PaymentProcessor paymentProcessor = new MockPaymentGateway();
		        OrderConfirmation orderConfirmation = new OrderConfirmation(cartBuilder, paymentProcessor);
		        orderConfirmation.confirmOrder();
		        System.out.print("cart empty.");
		        done = true;
            } else {
            	System.out.print("Order not placed. Returning to cart.");
            } 
            break;         
        case "4":
            System.out.println("Exiting menu...");
            done = true;
            break;
        default:
            System.out.println("Invalid option, please try again.");
            break;
        }
        
       }
        
	}

}
