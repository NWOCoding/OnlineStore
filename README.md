# Command Line Online Store Application

This is a simple command line application for an online store. The application has a CLI user interface that serves as the storefront for users to shop at your store.

## Product Class

A `Product` class is created with appropriate getters, setters, constructors, and methods. The class has the following properties:

- `Id`
- `Name`
- `Price`

## Store's Inventory

The application loads the store's inventory from the provided `inventory.csv` file.

## Cart

The store has a cart to track the items a customer wants to purchase. The basic requirement is to allow customers to add items to the cart. If a customer wants to purchase the same item twice, the item is added and displayed twice on the cart page.

## Screens

### Home Screen

The home screen displays a list of options that a user can choose from:

- Show Products
- Show Cart
- Exit (closes out of the application)

### Show Products Screen

The show products screen displays a list of products that your store sells. The user can enter the product ID to add it to the cart, or type "X" to go back to the home screen. If a product ID was selected, the product is added to the cart and the home screen is displayed again.

### Show Cart Screen

The show cart screen displays a list of line items that the customer has added to their cart. It also displays the total amount of the cart. A customer can choose from the following options:

- C (to Check Out)
- X (to go back to the home screen)

### Check Out Screen

The check out screen displays the total amount owed for this order and prompts the user for payment. Assume that the user will pay in cash. When the customer enters their payment amount, verify that they have paid enough to cover the cost of the items. If the customer did not add enough money, the full amount is returned back to the customer. If the customer added enough money for the sale, the change that is owed to the customer is calculated and displayed, the list of items that was sold to the customer is printed, the shopping cart is cleared, and the user is taken back to the home screen.
