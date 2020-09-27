/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the 
 * password does not contain at least 1 uppercase character
 */
public class NoUpperAlphaException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}