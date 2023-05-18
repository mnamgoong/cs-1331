//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * Represents a store with items that can be purchased and added to a receipt
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Store {

    private String[][] inventory;

    /**
     * Constructs a Store with a given store inventory file
     * @param f a File object of the store inventory file
     */
    public Store(File f) {
        Scanner fileScan = null;
        String parsed = "";
        int numItems = 0;
        try {
            fileScan = new Scanner(f);
            while (fileScan.hasNextLine()) {
                String line = fileScan.nextLine();
                parsed += line + "\n";
                numItems++;
            }
            this.inventory = new String[numItems][3];
            String[] items = parsed.split("\n");
            for (int i = 0; i < items.length; i++) {
                String[] tokens = items[i].split(",");
                for (int j = 0; j < 3; j++) {
                    inventory[i][j] = tokens[j];
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }
        }
    }

    /**
     * Constructs a Store with a given store inventory file name
     * @param fileName a String of the store inventory file name
     */
    public Store(String fileName) {
        this(new File(fileName));
    }

    /**
     * Buys items from a given shopping list, if possible, and writes a receipt to a given file name
     * @param shoppingList a shopping list
     * @param receiptDestination a file name for the receipt
     * @throws InvalidFormatException an Exception that's thrown when the first line of a ShoppingList csv
     * doesn't have the magic number
     */
    public void goShopping(File shoppingList, String receiptDestination) throws InvalidFormatException {
        File fileOut = new File(receiptDestination);
        Scanner fileScan = null;
        PrintWriter receipt = null;
        int total = 0;
        try {
            fileScan = new Scanner(shoppingList);
            receipt = new PrintWriter(fileOut);
            if (fileScan.nextLine().equals("$hopping")) {
                while (fileScan.hasNextLine()) {
                    String line = fileScan.nextLine();
                    int price = buyItem(line, receipt);
                    if (price != -1) {
                        total += price;
                    }
                }
            } else {
                throw new InvalidFormatException();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (OutOfStockException o) {
            System.out.println(o.toString());
        } catch (InvalidFormatException i) {
            System.out.println(i.toString());
        } finally {
            if (fileScan != null) {
                fileScan.close();
            }
            if (receipt != null) {
                receipt.println("TOTAL," + total);
                receipt.close();
            }
        }
    }

    /**
     * Purchases an item, if possible
     * @param shoppingListItem the desired item
     * @param receiptWriter a PrintWriter that writes into the receipt
     * @return the store price of the item
     * @throws OutOfStockException an Exception that's thrown when the stock of an item is 0
     */
    private int buyItem(String shoppingListItem, PrintWriter receiptWriter) throws OutOfStockException {
        try {
            String[] itemBought = parseLine(shoppingListItem);
            for (int i = 0; i < inventory.length; i++) {
                if (itemBought[0].equals(inventory[i][0])) {
                    if (Integer.parseInt(inventory[i][1]) == 0) {
                        throw new OutOfStockException(itemBought[0] + " is not in stock!");
                    }
                    if (Integer.parseInt(inventory[i][2]) > Integer.parseInt(itemBought[1])) {
                        return -1;
                    }
                    inventory[i][1] = String.valueOf(Integer.parseInt(inventory[i][1]) - 1);
                    receiptWriter.println(itemBought[0] + "," + inventory[i][2]);
                    return Integer.parseInt(inventory[i][2]);
                }
            }
            return -1;
        } catch (InvalidDataException e) {
            System.out.println(e.toString());
            return -1;
        } catch (OutOfStockException o) {
            System.out.println(o.toString());
            return -1;
        }
    }

    /**
     * Reformats a shopping list item
     * @param line a shopping list item in the format "[item name],[max price]"
     * @return a shopping list item in the format {itemName, maxPrice}
     * @throws InvalidDataException an Exception that's thrown when there's a negative max price or an empty field
     */
    private String[] parseLine(String line) throws InvalidDataException {
        String[] tokens = line.split(",");
        if (tokens[0].equals("")) {
            throw new InvalidDataException("Item has no name");
        }
        try {
            int maxPrice = Integer.parseInt(tokens[1]);
            if (maxPrice < 0) {
                throw new InvalidDataException("Max price cannot be negative");
            }
        } catch (NumberFormatException e) {
            throw new InvalidDataException(tokens[1] + " cannot be parsed as an integer price");
        } catch (InvalidDataException i) {
            System.out.println(i.toString());
        }
        String[] item = new String[2];
        item[0] = tokens[0];
        item[1] = tokens[1];
        return item;
    }

    /**

     * @return the store inventory
     */
    public String[][] getInventory() {
        return inventory;
    }

}