# ShoppingSystem
<p>This Java project simulates an online shopping system. The core components of the system include:</p>
<ul>
  <li>  <strong>Product Management: </strong> Products can be created using the ProductFactory class, which returns instances of Book or Speaker objects, depending on the type requested.</li>
  <li>  <strong>Shopping Cart: </strong>A singleton Cart class holds the selected products. Users can add or remove products from their shopping cart using the CartBuilder class. </li>
  <li>  <strong> User Authentication: </strong> The Authenticator class handles user login functionality, allowing users to log in with a username and password.</li>
  <li>  <strong> Payment Processing: </strong> The MockPaymentGateway class simulates payment transactions, with a success rate determined randomly. </li>
  <li>  <strong>Order Confirmation:</strong>The OrderConfirmation class finalizes the shopping cart and processes payment, providing feedback on the transaction outcome.</li>
  
</ul>

<p>Setup and Compilation:</p>
<ol>
  <li>Make sure you have Java installed on your system.</li>
  <li>Clone the repository or download the source code.</li>
  <li>Compile the classes using javac or by using an IDE like Eclipse or IntelliJ IDEA.</li>
</ol>

<p>Running the Application:</p>
<ol>
  <li>Start the application by running the MainClass.java class.</li>
  <li>Follow the on-screen prompts to interact with the system.</li>
</ol>

<p>Using the Shopping System:</p>

<ol>
  <li>
    Create a User Account:
  <ul>
    <li>When prompted, create a username and password.</li>
  </ul>
  </li>
  
  <li>
    Login:

  <ul>
    <li>Enter your username and password to log in.</li>
  </ul>
  </li>

  <li>
    Interacting with the Catalog:

  <ul>
    <li>You can view the catalog and select products to add to your cart.</li>
  </ul>
  </li>

  <li>
Managing the Cart:
  <ul>
    <li>Choose to add or remove products from your cart.</li>
    <li>You can view the contents of your cart at any time.</li>
  </ul>
  </li>

  <li>
Finalizing Your Order:

  <ul>
    <li>Once you have finished shopping, choose to finalize your cart.</li>
    <li>Confirm your order and proceed to the mock payment process.</li>
  </ul>
  </li>

  <li>
    Payment:
  <ul>
    <li>The system will simulate a payment process.</li>
    <li>If the mock payment is successful, your order will be confirmed and the cart will be cleared.</li>
    <li>If the payment fails, you will be prompted to try again.</li>
  </ul>
  </li>

  <li>
Exiting the Application:

  <ul>
    <li>At any time, you can choose to exit the application.
</li>
  </ul>
  </li>

  
</ol>



