/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the length of a password is
 * not at least 6 characters long
 */
public class LengthException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public LengthException() {
		super("The password must be at least 6 characters long.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public LengthException(String message) {
		super(message);
	}
}
