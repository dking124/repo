/**
 * 
 * @author Darren King
 * Basic Double Linked List class that implements 
 * multiple methods that access and change the elements within nodes.
 * @param <T>
 */
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Comparator;
import java.util.ArrayList;
public class BasicDoubleLinkedList<T> {
	protected int listSize;
	protected Node head, tail;
	/**
	 * Inner class Node
	 *
	 */
	protected class Node{
		protected T data;
		protected Node next;
		protected Node previous;
		
		protected Node(T dataPortion) {
			this(dataPortion, null, null);
		}
		
		protected Node(T dataPortion, Node nextNode, Node previousNode) {
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		}
	}
	/**
	 * Default Constructor
	 */
	public BasicDoubleLinkedList() {
		listSize = 0;
		head = null;
		tail = null;
	}
	/**
	 * Method that adds an element to the end of the list.
	 * @param data
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node newNode = new Node(data);
		if(tail == null) {
			tail = newNode;
			head = tail;
		}
		else {
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		listSize++;
		return this;
	}
	/**
	 * Method that adds element to the front of the list.
	 * @param data
	 * @return reference to current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = head;
		}
		else {
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		}
		listSize++;
		return this;
	}
	/**
	 * Method that returns first element of the list.
	 * @return first element of list or null
	 */
	public T getFirst() {
		if(listSize == 0)
			return null;
		else
			return head.data;
	}
	/**
	 * Method that returns last element of the list.
	 * @return last element or null.
	 */
	public T getLast() {
		if(listSize == 0)
			return null;
		else
			return tail.data;
	}
	/**
	 * Method that returns the size of the list.
	 * @return listSize
	 */
	public int getSize() {
		return listSize;
	}
	/**
	 * Method that returns an ListIterator<object>.
	 * @return list
	 * @throws UnsupportedOperationException
	 * @throws NoSuchElementException
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		listIterator list = new listIterator(head);
		return list;
	}
	/**
	 * Inner class that implements ListIterator for the method iterator().
	 *
	 */
	public class listIterator implements ListIterator<T>{
		Node nextNode, previousNode;
		listIterator(Node next){
			nextNode = next;
			previousNode = null;
		}
		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public boolean hasPrevious() {
			return previousNode != null;
		}

		@Override
		public T next() {
			T result;
			if(hasNext()) {
				previousNode = nextNode;
				result = previousNode.data;
				nextNode = nextNode.next;
			}
			else
				throw new NoSuchElementException();
			return result;
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public T previous() {
			T result;
			if(hasPrevious()) {
				nextNode = previousNode;
				result = nextNode.data;
				previousNode = previousNode.previous;
			}
			else
				throw new NoSuchElementException();
			return result;
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
			
		}

		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
	}
	/**
	 * Method that removes the first instance of targetData from the list
	 * @param targetData
	 * @param comparator
	 * @return data element or null.
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node newNode = head;
		if(listSize == 0) // Addresses if the list is empty
			return null;
		while(newNode != null) { // Loop until the list is traversed completely 
			if(comparator.compare(targetData, newNode.data) == 0) { // if targetData = current node data
				if(head == newNode && head.next != null) { // Addresses if head is targetData and there is a value after head
					head = head.next;
					head.previous = null;
					listSize--;
					return this;
				}
				else if(head == newNode && head.next == null) { // Addresses if head is targetData and there is no value after head
					head = null;
					tail = null;
					listSize--;
					return this;
				}
				else if(tail == newNode && tail.previous != null) { // Addresses if tail is targetData and there is a value before tail
					tail = tail.previous;
					tail.next = null;
					listSize--;
					return this;
				}
				else if(tail == newNode && tail.previous == null) { // Addresses if tail is targetData and there is no value before tail
					tail = null;
					head = null;
					listSize--;
					return this;
				}
				else { // Addresses if targetData is in between head and tail
					newNode.previous.next = newNode.next;
					newNode.next.previous = newNode.previous;
					listSize--;
					return this;
				}
				
			}
			else if(comparator.compare(targetData, newNode.data) != 0){ // If target data != current node data, goes to next node
				newNode = newNode.next;
			}
		}
		return this;
	}
	/**
	 * Method that removes and retrieves the first element of the list.
	 * @return firstElement or null.
	 */
	public T retrieveFirstElement() {
		if(listSize == 0)
			return null;
		T firstElement = head.data;
		head.data = null;
		head = head.next;
		listSize--;
		return firstElement;
	}
	/**
	 * Method that removes and retrieves the last element of the list.
	 * @return lastElement or null.
	 */
	public T retrieveLastElement() {
		if(listSize == 0)
			return null;
		T lastElement = tail.data;
		tail.data = null;
		tail = tail.previous;
		listSize--;
		return lastElement;
	}
	/**
	 * Method that returns an arraylist of the items in the list from head of list to tail of list.
	 * @return list
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<>();
		Node newNode = head;
		while(newNode != null) {
			list.add(newNode.data);
			newNode = newNode.next;
		}
		return list;
	}
	
}
