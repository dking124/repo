/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the 
 * password does not contain at least 1 special character
 */
public class NoSpecialSymbolException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public NoSpecialSymbolException() {
		super("The password must contain at least one special character.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public NoSpecialSymbolException(String message) {
		super(message);
	}
}
