/**
 * 
 * @author Darren King
 * An exception class that occurs when a
 * push method is called on a full stack.
 */
public class StackUnderflowException extends Exception {
	/**
	 * Default constructor
	 */
	public StackUnderflowException() {
		super("The stack is full.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public StackUnderflowException(String message) {
		super(message);
	}
}
