/**
 * CourseDBElement class that implements Comparable. Used to create a CourseDBElement object.
 * @author Darren King
 *
 */
public class CourseDBElement implements Comparable{
	private String id;
	private int crn;
	private int numCredits;
	private String roomNum;
	private String instructor;
	/**
	 * Default Constructor
	 */
	public CourseDBElement() {
		id = "";
		crn = 0;
		numCredits = 0;
		roomNum = "";
		instructor = "";
	}
	/**
	 * Constructor that takes parameters
	 * @param id
	 * @param crn
	 * @param numCredits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int numCredits, String roomNum, String instructor) {
		this.id = id;
		this.crn = crn;
		this.numCredits = numCredits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	@Override
	public int compareTo(CourseDBElement element) {
		return (this.crn - element.crn);
	}
	/**
	 * Gets current CRN
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}
	/**
	 * Sets CRN
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	/**
	 * Gets CRN and converts it into string, which then the hashcode of the string is returned
	 * @return str.hashCode()
	 */
	@Override
	public int hashCode() {
		String str = crn + "";
		return str.hashCode();
	}
	/**
	 * Generated equals method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDBElement other = (CourseDBElement) obj;
		if (crn != other.crn)
			return false;
		return true;
	}
	/**
	 * toString that returns the values of a CourseDBElement in a string
	 * @return str
	 */
	@Override
	public String toString() {
		String str = "\nCourse:" + id + " CRN:" + crn + " Credits:" + numCredits + " Instructor:" + instructor + " Room:" + roomNum;
		return str;
	}
	
}
