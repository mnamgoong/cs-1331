import java.util.Arrays;

/**
 * Represents a library
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Library {

    private LibraryItem[] bookshelf;

    /**
     * Constructs a library with an empty bookshelf
     */
    public Library() {
        bookshelf = new LibraryItem[0];
    }

    /**
     * Constructs a library with an array of library items that will be on the bookshelf
     * @param bookshelf items on the bookshelf
     */
    public Library(LibraryItem[] bookshelf) {
        this.bookshelf = bookshelf;
        Arrays.sort(bookshelf);
    }

    /**
     * Prints out the summaries of all library items in the bookshelf for the library
     */
    public void browseLibraryItems() {
        for (int i = 0; i < bookshelf.length; i++) {
            System.out.println(bookshelf[i].getLibraryCode() + ": " + bookshelf[i].summarize());
        }
    }

    /**
     * Adds a new item to the bookshelf in the sorted order
     * @param newItem the new item on the bookshelf
     */
    public void addLibraryItem(LibraryItem newItem) {
        LibraryItem[] newBookshelf = new LibraryItem[bookshelf.length + 1];
        for (int i = 0; i < bookshelf.length; i++) {
            newBookshelf[i] = bookshelf[i];
        }
        newBookshelf[newBookshelf.length - 1] = newItem;
        bookshelf = newBookshelf;
        Arrays.sort(bookshelf);
    }

    /**
     * Returns the library item with the given code
     * @param code the code being searched for
     * @return the library item with the same code (or null)
     */
    public LibraryItem getLibraryItem(int code) {
        for (int i = 0; i < bookshelf.length; i++) {
            if (bookshelf[i].getLibraryCode() == code) {
                return bookshelf[i];
            }
        }
        return null;
    }

    /**
     * @return the number of items on the shelf
     */
    public int getNumberOfItems() {
        return bookshelf.length;
    }

}