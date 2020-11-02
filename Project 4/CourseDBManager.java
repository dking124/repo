/**
 * CourseDBManager class that implements CourseDBManagerInterface.
 * Class that reads information from a file and creates a CourseDBElement object.
 * Also implements a method that shows all the CourseDBElement objects within hashtable.
 * @author Darren King
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure CDS = new CourseDBStructure(20);
	/**
	 * Method that uses add method from CourseDBStructure class.
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement newElement = new CourseDBElement(id, crn, credits, roomNum, instructor);
		CDS.add(newElement);
	}
	/**
	 * Method that uses get method from CourseDBStructure class.
	 * @return CourseDBElement
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return CDS.get(crn);
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}
	/**
	 * Method that takes given File object and creates CourseDBElement objects
	 * from the values from each line.
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			Scanner fileData = new Scanner(input);
			while(fileData.hasNext()) {
				String id = fileData.next();
				int crn = fileData.nextInt();
				int numCredits = fileData.nextInt();
				String roomNum = fileData.next();
				String instructor = fileData.nextLine();
				add(id, crn, numCredits, roomNum, instructor);
			}
			fileData.close();
		}
		catch(FileNotFoundException e) {
			System.out.print("File not found");
			e.getMessage();
		}
	}
	/**
	 * Method that traverses through a hashtable and its buckets
	 * and converts each CourseDBElement object into a string that 
	 * is put into a arraylist.
	 * @return list
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < CDS.hashTable.length; i++) { // loop through hashTable
			LinkedList<CourseDBElement> tempList = CDS.hashTable[i];
			if(tempList != null) {
				for(int j = 0; j < tempList.size(); j++) { // loop through buckets
					CourseDBElement element = tempList.get(j);
					list.add(element.toString());
				}
			}
		}
		return list;
	}

}
