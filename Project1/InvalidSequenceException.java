/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the 
 * password contains more than two of the same
 * character in sequence.
 */
public class InvalidSequenceException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}