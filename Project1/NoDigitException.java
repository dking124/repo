/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the 
 * password does not contain a single digit
 */
public class NoDigitException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public NoDigitException() {
		super("The password must contain at least one digit.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public NoDigitException(String message) {
		super(message);
	}
}