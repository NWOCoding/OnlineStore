import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineStoreApp {
    // Global variables for use in multiple functions
    public Scanner scanner = new Scanner(System.in);
    public HashMap<Integer,Product> inventoryMap = new HashMap<>();
    public static ArrayList<Product> cart = new ArrayList<>();

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
            System.exit(1);
        }
    }

    private void homeScreen()