/**
 * 
 * @author Darren King
 *
 * An exception class that is thrown when the 
 * passwords do not match
 */
public class UnmatchedException extends RuntimeException {
	/**
	 * Default constructor
	 */
	public UnmatchedException() {
		super("The passwords do not match.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}