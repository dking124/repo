/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the 
 * password is shorter than 10 characters
 * and longer than 6 characters.
 */
public class WeakPasswordException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}