/**
 * Represents a library item
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public abstract class LibraryItem implements Comparable<LibraryItem>, Summarizable {

    private String title;
    private int libraryCode;

    /**
     * Constructs a library item with a given title and library code
     * @param title the library item's title
     * @param libraryCode the library item's code
     */
    public LibraryItem(String title, int libraryCode) {
        this.title = title;
        this.libraryCode = libraryCode;
    }

    @Override
    public String summarize() {
        return "This item is called " + title + ".";
    }

    @Override
    public int compareTo(LibraryItem other) {
        if (this.libraryCode < other.libraryCode) {
            return 1;
        } else if (this.libraryCode > other.libraryCode) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * @return the current library item's code
     */
    public int getLibraryCode() {
        return libraryCode;
    }

}