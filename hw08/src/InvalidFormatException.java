/**
 * Represents a checked Exception that's thrown when the first line of a ShoppingList csv
 * doesn't have the magic number
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class InvalidFormatException extends Exception {

    /**
     * Constructs an InvalidFormatException with a given String message
     * @param message a given String message
     */
    public InvalidFormatException(String message) {
        super(message);
    }

    /**
     * Construct a default InvalidFormatException
     */
    public InvalidFormatException() {
        super();
    }

}
