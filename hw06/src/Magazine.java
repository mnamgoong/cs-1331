/**
 * Represents a magazine in the library
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class Magazine extends LibraryItem {

    private String coverDescription;

    /**
     * Constructs a magazine with a given title, library code, and cover description
     * @param title the magazine's title
     * @param libraryCode the magazine's library code
     * @param coverDescription the magazine's short description
     */
    public Magazine(String title, int libraryCode, String coverDescription) {
        super(title, libraryCode);
        this.coverDescription = coverDescription;
    }

    @Override
    public String summarize() {
        return super.summarize() + " The cover looks like " + coverDescription + ".";
    }

}