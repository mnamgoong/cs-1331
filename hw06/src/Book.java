/**
 * Represents a book in the library
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Book extends LibraryItem {

    private String backcoverBlurb;
    private int pages;

    /**
     * Constructs a book with a given title, library code, backcover blurb, and number of pages
     * @param title the book's title
     * @param libraryCode the book's library code
     * @param backcoverBlurb the book's short description
     * @param pages the book's number of pages
     */
    public Book(String title, int libraryCode, String backcoverBlurb, int pages) {
        super(title, libraryCode);
        this.backcoverBlurb = backcoverBlurb;
        this.pages = pages;
    }

    @Override
    public String summarize() {
        return super.summarize() + " The book is " + pages + " pages long. " + backcoverBlurb + ".";
    }

}