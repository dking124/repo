/**
 * 
 * @author Darren King
 * An exception class that occurs when a
 * dequeue method is called on a empty queue.
 */
public class QueueOverflowException extends Exception {
	/**
	 * Default constructor
	 */
	public QueueOverflowException() {
		super("The queue is empty.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public QueueOverflowException(String message) {
		super(message);
	}
}