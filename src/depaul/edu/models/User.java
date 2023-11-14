package depaul.edu.models;

import depaul.edu.cart.Cart;

//User Class with username and account

public class User {
	private String username;
	private String password;
    private Cart cart;

	public User(String username, String password) {
		 this.username = username;
	     this.password = password; 
	     this.cart = Cart.getInstance(); 

	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	public Cart getCart() {
        return cart;
    }
	
	@Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", cart=" + cart.toString() + 
               '}';
    }
	
	
	
	


}
