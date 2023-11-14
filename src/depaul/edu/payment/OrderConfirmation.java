/**
 * 
 */
package depaul.edu.payment;

import depaul.edu.cart.Cart;
import depaul.edu.cart.CartBuilder;

/**
 * @author AlanYoung
 *
 */
public class OrderConfirmation {
    private CartBuilder cartBuilder;
    private PaymentProcessor paymentProcessor;
    public OrderConfirmation(CartBuilder cartBuilder, PaymentProcessor paymentProcessor) {
        this.cartBuilder = cartBuilder;
        this.paymentProcessor = paymentProcessor;
    }
    public void confirmOrder() {
    	 Cart cart = cartBuilder.finalizeCart();
         double totalAmount = cart.getTotal();
         System.out.println("Order Confirmation:");
         System.out.println(cart); 
    
         boolean paymentSuccessful = false;
         int attempts = 0;
         final int maxAttempts = 3; 
         
         while (!paymentSuccessful && attempts < maxAttempts) {
             attempts++;
             paymentSuccessful = paymentProcessor.processPayment(totalAmount);

             if (!paymentSuccessful) {
            	 
                 System.out.println(Integer.toString(attempts)+"th Payment failed. Please try again.");
                 System.out.println("trying a different payment method!");
             }
         }
         
         if (paymentSuccessful) {
             System.out.println(Integer.toString(attempts)+"th Payment successful! Your order has been placed.");
             cart.clearCart();
         } else {
             System.out.println("Payment unsuccessful after " + maxAttempts + " attempts. Please contact support.");
         }  
    }
}
