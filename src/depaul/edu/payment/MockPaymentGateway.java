/**
 * 
 */
package depaul.edu.payment;

/**
 * @author AlanYoung
 *
 */
public class MockPaymentGateway implements PaymentProcessor{

	@Override
	public boolean processPayment(double amount) {
        System.out.println("Processing payment for amount: $" + amount);
        boolean isTransactionSuccessful = Math.random() < 0.8; 
        if (isTransactionSuccessful) {
            System.out.println("Payment processed successfully.");
        } else {
            System.out.println("Payment failed to process.");
        }
        return isTransactionSuccessful;
	}
}
