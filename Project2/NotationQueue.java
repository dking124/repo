/**
 * @author Darren King
 * Generic Queue Class
 */
import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T> {
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private int count;
	private static final int DEFAULT = 50;
	/**
	 * Constructor that takes in a given size
	 * and sets array size.
	 * @param size
	 */
	NotationQueue(int size){
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[size + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = size;
		count = 0;
	}
	/**
	 * Default constructor
	 */
	NotationQueue(){
		this(DEFAULT);
	}
	/**
	 * Method that checks if array is empty.
	 */
	@Override
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);
	}
	/**
	 * Method that checks if array is full.
	 */
	@Override
	public boolean isFull() {
		if(frontIndex == ((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for(int index = 0; index < oldSize - 1; index++) {
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			frontIndex = 0;
			backIndex = oldSize - 2;
			return true;
		}
		else
			return false;
	}
	/**
	 * Method that deletes element at the front of array and pushes every other element forward.
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException();
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			count--;
			return front;
		}
	}
	/**
	 * Method that returns size of array.
	 */
	@Override
	public int size() {
		return count;
	}
	/**
	 * Method that adds a new element at the end of array.
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull())
			throw new QueueOverflowException();
		else {
			backIndex = (backIndex + 1) % queue.length;
			queue[backIndex] = e;
			count++;
			return true;
		}
	}
	/**
	 * Method that returns string of all elements in array.
	 */
	public String toString() {
		String string = "";
		for(int i = 0; i < backIndex + 1; i++) {
			if(queue[i] == null) {
				
			}
			else
				string += queue[i];
		}
		return string;
	}
	/**
	 * Method that returns string of all elements in array with delimiter in between each element.
	 */
	@Override
	public String toString(String delimiter) {
		String string = "";
		for(int i = 0; i < backIndex + 1; i++) {
			if(i < backIndex)
				string += queue[i] + delimiter;
			if(i == backIndex)
				string += queue[i];
		}
		return string;
	}
	/**
	 * Method that copies a given arraylist and pastes its elements into the array.
	 */
	@Override
	public void fill(ArrayList<T> list) {
		@SuppressWarnings("unchecked")
		ArrayList<T> copyList = (ArrayList<T>)list.clone();
		for(int j = 0; j < copyList.size(); j++) {
			queue[j] = copyList.get(j);
			backIndex++;
			count++;
		}
	}
		
}


