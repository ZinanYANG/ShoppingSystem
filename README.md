# ShoppingSystem
<p>This Java project simulates an online shopping system. The core components of the system include:</p>
<ul>
  <li>  <strong>Product Management: </strong> Products can be created using the ProductFactory class, which returns instances of Book or Speaker objects, depending on the type requested.</li>
  <li>  <strong>Shopping Cart: </strong>A singleton Cart class holds the selected products. Users can add or remove products from their shopping cart using the CartBuilder class. </li>
  <li>  <strong> User Authentication: </strong> The Authenticator class handles user login functionality, allowing users to log in with a username and password.</li>
  <li>  <strong> Payment Processing: </strong> The MockPaymentGateway class simulates payment transactions, with a success rate determined randomly. </li>
  <li>  <strong>Order Confirmation:</strong>The OrderConfirmation class finalizes the shopping cart and processes payment, providing feedback on the transaction outcome.</li>
  
</ul>
