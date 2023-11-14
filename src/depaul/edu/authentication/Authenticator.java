package depaul.edu.authentication;

import depaul.edu.models.User;

public class Authenticator  {

	private User user;
    private boolean isLoggedIn = false;
	/**
	 * @param user
	 */
	public Authenticator () {
		this.user = user; 
	}
	
	public void setUser(User user) {
        this.user = user;
    }
	
	
	public boolean login(String username, String password) {
        if (user.getUsername().equals(username) && user.checkPassword(password)) {
            isLoggedIn = true;
            return true;
        }
        return false;
    }
	
	public void logout() {
		isLoggedIn = false;
	}
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	
	
}
