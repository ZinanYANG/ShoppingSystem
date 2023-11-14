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

  <p>Notes:</p>

  <ul>
    <li>All interactions are currently console-based.</li>
    <li>Payment processing is simulated and no real transactions will occur.</li>
    <li>The product catalog is in-memory and will reset upon each application start.</li>
  </ul>

  
</ol>

<p>Developed unit tests for critical components, such as the shopping cart, product catalog, and order processing.</p>



<p> <strong>ExampleUsage</strong> ia attached in the source file</p>

 <h3>AuthenticatorTest</h3>
    <p>Tests the <code>Authenticator</code> class to ensure that the user login process works as expected. It covers successful login, failed login due to incorrect password, and the logout process.</p>

    <h3>BookTest</h3>
    <p>Validates the <code>Book</code> class functionality, including the constructor, getters, setters, and <code>toString</code> method. Ensures that the Book properties are correctly managed and represented.</p>

    <h3>CartBuilderTest</h3>
    <p>Ensures that the <code>CartBuilder</code> class functions correctly by testing product addition and removal from the cart. Also includes tests for handling exceptions when trying to add or remove non-existent products.</p>

    <h3>CartTest</h3>
    <p>Focuses on the <code>Cart</code> class, testing the addition and removal of items, retrieving the total price and quantity of items in the cart, clearing the cart, and getting the list of items.</p>

    <h3>ProductCatalogTest</h3>
    <p>Verifies the <code>ProductCatalog</code> class, ensuring that products can be added and removed. It also tests retrieval of a single product, handling of attempts to remove non-existent products, and the retrieval of all products in the catalog.</p>

    <h3>ProductFactoryTest</h3>
    <p>Tests the <code>ProductFactory</code> class to ensure that it correctly creates <code>Book</code> and <code>Speaker</code> objects. It includes negative tests for invalid inputs, such as null values, empty strings, and negative prices.</p>

    <h3>SpeakerTest</h3>
    <p>Similar to <code>BookTest</code>, this suite tests the <code>Speaker</code> class for proper functionality of its constructor, getters, setters, and <code>toString</code> method.</p>

    <h3>UserTest</h3>
    <p>Tests the <code>User</code> class to ensure that the user's username and password are handled correctly. It also tests password verification and the retrieval of the user's shopping cart.</p>

