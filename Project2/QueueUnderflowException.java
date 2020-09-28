/**
 * 
 * @author Darren King
 * An exception class that occurs when a
 * enque method is called on a full queue.
 */
public class QueueUnderflowException extends Exception {
	/**
	 * Default constructor
	 */
	public QueueUnderflowException() {
		super("The queue is full.");
	}
	/**
	 * Constructor that receives message
	 * @param message
	 */
	public QueueUnderflowException(String message) {
		super(message);
	}
}