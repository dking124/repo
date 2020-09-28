/**
 * 
 * @author Darren King
 *	An exception class that is thrown when the given 
 * expression format is invalid.
 */
public class InvalidNotationFormatException extends Exception {
	/**
	 * Default constructor
	 */
	public InvalidNotationFormatException() {
		super("The given expression format is invalid.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public InvalidNotationFormatException(String message) {
		super(message);
	}
}
