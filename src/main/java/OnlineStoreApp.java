import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineStoreApp {
    public static ArrayList<Product> cart = new ArrayList<>();
    // Global variables for use in multiple functions
    public Scanner scanner = new Scanner(System.in);
    public HashMap<Integer, Product> inventoryMap = new HashMap<>();

    public void run() {
        // Load items from the csv file into the inventory Map
        loadInventory();

        // Start the loop and display the home screen
        while (true) {
            homeScreen();
        }
    }

    private void loadInventory() {
        File inventoryFile = new File("Inventory.csv");

        try {
            Scanner fileScanner = new Scanner(inventoryFile);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product = new Product(id, name, price);
                inventoryMap.put(id, product);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Inventory file not found!");
            throw new RuntimeException(e);
        }
    }

    private void homeScreen() {
        System.out.println("[Welcome to the Online Store]");
        System.out.println("[Select an option from those below]");
        System.out.println("1.) Show products");
        System.out.println("2.) Show cart");
        System.out.println("3.) Exit");
        System.out.print("Enter: ");

        try {
            int reply = scanner.nextInt();
            switch (reply) {
                case 1:
                    // Show products
                    displayProducts();

                    break;
                case 2:
                    // Show cart
                    displayCart();

                    break;
                case 3:
                    // Exit
                    System.out.println("Goodbye!");
                    System.exit(0);

                    break;
                default:
                    // Catch incorrect input
                    System.out.println("Unknown input, please try again\n");

                    homeScreen();
            }
        } catch (InputMismatchException e) {
            // Incorrect input catcher
            System.out.println("Please use an integer to reply\n");

            scanner.nextLine();
            homeScreen();
        }
    }

    private void displayCart() {
    }

    private void displayProducts() {
        System.out.println("[The following products are available]");

        for (int id : inventoryMap.keySet()) {
            Product product = inventoryMap.get(id);
            System.out.println(product.getId() + ".) " + product.getName() + " - $" + product.getPrice());
        }

        System.out.print("Enter product id to add to cart (or X to go back to home screen): ");
        String reply = scanner.next();

        if (reply.equalsIgnoreCase("X")) {
            // Return to home screen
            System.out.println("Returning to home screen...\n");
            homeScreen();

            return;
        }

        
    }
}


