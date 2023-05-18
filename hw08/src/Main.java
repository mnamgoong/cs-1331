import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, InvalidFormatException {

        // Add your own file paths to the three .csv files below
        File shop = new File("/Users/aviathota/Desktop/School Stuff/Fall 2021/CS 1331/HW8/src/store_inventory.csv");
        File halloween = new File("/Users/aviathota/Desktop/School Stuff/Fall 2021/CS 1331/HW8/src/halloween.csv");
        File thanksgiving = new File("/Users/aviathota/Desktop/School Stuff/Fall 2021/CS 1331/HW8/src/thanksgiving.csv");

        // part 1: checking if the store gets loaded correctly into the inventory
        // MAKE SURE YOU HAVE A GETTER METHOD FOR INVENTORY !
        Store newStore = new Store(shop);
        for (int i = 0; i < newStore.getInventory().length; i++) {
            System.out.println(Arrays.toString(newStore.getInventory()[i]));
        }

        // part 2: testing if goShopping works
        newStore.goShopping(halloween, "receipt");
        System.out.println();
        for (int i = 0; i < newStore.getInventory().length; i++) {
            System.out.println(Arrays.toString(newStore.getInventory()[i]));
        }

        newStore.goShopping(thanksgiving, "receipt2");
        System.out.println();
        for (int i = 0; i < newStore.getInventory().length; i++) {
            System.out.println(Arrays.toString(newStore.getInventory()[i]));
        }

        /*
        Output?

        [Water bottle, 0, 5]
        [Apple cider, 5, 5]
        [Turkey, 1, 13]
        [Mac and cheese, 7, 6]
        [Candy, 0, 5]
        [Jack O Lantern, 10, 0]
        [Mashed potatoes, 3, 3]
        [Cranberry sauce, 10, 10]
        [Pumpkin, 11, 11]
        [Succulent, 10, 5]

        [Water bottle, 0, 5]
        [Apple cider, 5, 5]
        [Turkey, 1, 13]
        [Mac and cheese, 7, 6]
        [Candy, 0, 5]
        [Jack O Lantern, 9, 0]
        [Mashed potatoes, 3, 3]
        [Cranberry sauce, 10, 10]
        [Pumpkin, 10, 11]
        [Succulent, 10, 5]
        InvalidDataException: Item has no name
        InvalidDataException: Max price cannot be negative
        InvalidDataException: five dollars cannnot be parsed as an integer price

        [Water bottle, 0, 5]
        [Apple cider, 5, 5]
        [Turkey, 0, 13]
        [Mac and cheese, 6, 6]
        [Candy, 0, 5]
        [Jack O Lantern, 9, 0]
        [Mashed potatoes, 3, 3]
        [Cranberry sauce, 10, 10]
        [Pumpkin, 10, 11]
        [Succulent, 10, 5]
         */
    }
}
