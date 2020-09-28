/**
 * 
 * @author Darren King
 * An exception class that occurs when a
 * top or pop method is called on a empty stack.
 */
public class StackOverflowException extends Exception {
	/**
	 * Default constructor
	 */
	public StackOverflowException() {
		super("The stack is empty.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public StackOverflowException(String message) {
		super(message);
	}
}