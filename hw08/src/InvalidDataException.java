/**
 * Represents an unchecked Exception that's thrown when there's a negative max price or an empty field
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class InvalidDataException extends RuntimeException {

    /**
     * Constructs an InvalidDataException with a given String message
     * @param message a given String message
     */
    public InvalidDataException(String message) {
        super(message);
    }

    /**
     * Construct a default InvalidDataException
     */
    public InvalidDataException() {
        super();
    }

}
