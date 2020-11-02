/**
 * 
 * @author Darren King
 * Sorted Double Linked List class that implements multiple
 * methods that access and change elements in nodes
 * @param <T>
 */
import java.util.ListIterator;
import java.util.Comparator;
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	Comparator<T> comparator;
	/**
	 * Default constructor
	 * @param comparator2
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		comparator = comparator2;
	}
	/**
	 * Method that inserts specified element at correct position in the sorted list.
	 * @param data
	 * @return reference to current object
	 */
	public SortedDoubleLinkedList<T> add(T data){
		Node headCopy;
		Node newNode = new Node(data, null, null);
	    if (listSize == 0) { // Addresses if list is empty
	    	 head = newNode;  
	    	 tail = newNode;
	    }
	    else if (comparator.compare(head.data, data) >= 0) // If element in head > data, targetData becomes head
	    {  
	        newNode.next = head;  
	        tail = newNode.next;
	        newNode.next.previous = newNode;  
	        head = newNode;  
	    }  
	    else // Traverses through the list if head < data
	    {  
	        headCopy = head;  
	        while (headCopy.next != null && comparator.compare(headCopy.next.data, data) < 0)  
	        	headCopy = headCopy.next;  
	        newNode.next = headCopy.next; 
	        if (headCopy.next != null)  
	            newNode.next.previous = newNode;  
	        headCopy.next = newNode;
	        newNode.previous = headCopy;  
	        while(newNode.next != null) { // Goes through all nodes until final node to set it as tail
	        	newNode = newNode.next;
	        	tail = newNode;
	        }
	    }  
	    listSize++;
	    return this;
	}
	/**
	 * Method that throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * Method that throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * Method that calls the super class iterator method
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	/**
	 * Method that calls the super class remove method
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator){
		super.remove(data, comparator);
		return this;
	}
}
