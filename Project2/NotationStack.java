/**
 * @author Darren King
 * Generic Stack class
 */
import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T> {
	private T[] stack;
	private int topIndex;
	private static final int DEFAULT = 50;
	/**
	 * Constructor that takes in a given size
	 * and sets array size.
	 * @param size
	 */
	NotationStack(int size){
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[size];
		stack = tempStack;
		topIndex = -1;
	}
	/**
	 * Default Constructor
	 */
	NotationStack(){
		this(DEFAULT);
	}
	/**
	 * Method that checks if array is empty.
	 */
	@Override
	public boolean isEmpty() {
		return topIndex < 0;
	}
	/**
	 * Method that checks if array is full.
	 */
	@Override
	public boolean isFull() {
		if(topIndex == stack.length - 1)
			return true;
		else return false;
	}
	/**
	 * Method that deletes and returns the top element in array.
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty())
			throw new StackUnderflowException();
		else {
			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		}
	}
	/**
	 * Method that returns the top element in array.
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty())
			throw new StackUnderflowException();
		else 
			return stack[topIndex];
	}
	/**
	 * Method that returns size of array.
	 */
	@Override
	public int size() {
		int size = topIndex + 1;
		return size;
	}
	/**
	 * Method that adds a new element at the top of array.
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(isFull())
			throw new StackOverflowException();
		else {
			stack[topIndex + 1] = e;
			topIndex++;
			return true;
		}
	}
	/**
	 * Method that returns string of all elements in array.
	 */
	public String toString() {
		String string = "";
		for(int i = 0; i < topIndex + 1; i++) {
			if(stack[i] == null) {
				
			}
			else
				string += stack[i];
		}
		return string;
	}
	/**
	 * Method that returns string of all elements in array with delimiter in between each element.
	 */
	@Override
	public String toString(String delimiter) {
		String string = "";
		for(int i = 0; i < topIndex + 1; i++) {
			if(i < topIndex)
				string += stack[i] + delimiter;
			if(i == topIndex)
				string += stack[i];
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
			stack[j] = copyList.get(j);
			topIndex++;
		}
	}

}
