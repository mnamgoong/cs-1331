/**
 * Represents an unchecked Exception that's thrown when the stock of an item is 0
 *
 * @author Michelle Namgoong
 * @version 11.0.12
 */
public class OutOfStockException extends RuntimeException {

    /**
     * Constructs an OutOfStockException with a given String message
     * @param message a given String message
     */
    public OutOfStockException(String message) {
        super(message);
    }

    /**
     * Constructs a default OutOfStockException
     */
    public OutOfStockException() {
        super("There is no stock remaining!");
    }

}
