/**
 * CourseDBStructure class that implements CourseDBStructureInterface.
 * Class that adds a CourseDBElement object into a hashtable and
 * gets the CourseDBElement if given crn.
 * @author Darren King
 */
import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {
	protected int size;
	protected LinkedList<CourseDBElement> hashTable[];
	
	/**
	 * Default constructor
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	/**
	 * Constructor for testing
	 * @param testing
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int size) {
		this.size = size;
		hashTable = new LinkedList[size];
	}
	/**
	 * Method that takes a given CourseDBElement object and adds it into hashtable.
	 * If the index of the CRN is null, creates new linked list.
	 * Otherwise use bucket method.
	 * @param element
	 */
	@Override
	public void add(CourseDBElement element) {
		int index = element.hashCode() % size;
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<CourseDBElement>();
		}
		hashTable[index].add(element);
	}
	/**
	 * Method that gets the CourseDBElement object given the CRN.
	 * If the index of CRN does not exist in hashtable, throw IOException.
	 * If it does, traverses through hashtable buckests until a CRN is matched
	 * @param crn
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String str = crn + "";
		int index = str.hashCode() % size;
		if(hashTable[index] == null) {
			throw new IOException();
		}
		else {
			for(int i = 0; i < size; i++) {
				CourseDBElement temp = hashTable[index].get(i);
				if(temp.getCRN() == crn) {
					return temp;
				}
			}
			return null;
		}
	}
	/**
	 * Method that gets the size of hashtable.
	 * @return size
	 */
	@Override
	public int getTableSize() {
		return size;
	}

}
