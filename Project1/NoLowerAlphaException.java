/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the 
 * password does not contain at least 1 lowercase character
 */
public class NoLowerAlphaException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}