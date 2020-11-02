import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface test = new CourseDBManager();
	@BeforeEach
	void setUp() throws Exception {
		test = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testAddToDB() {
		try {
			test.add("CMSC204",22122,4,"Distance-Learning","Professor Thai");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	void testShowAll() {
		test.add("CMSC204",22122,4,"Distance-Learning","Professor Thai");
		test.add("CMSC204",22123,4,"Distance-Learning","Somebody else");
		ArrayList<String> list = test.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC204 CRN:22122 Credits:4 Instructor:Professor Thai Room:Distance-Learning");
		assertEquals(list.get(1),"\nCourse:CMSC204 CRN:22123 Credits:4 Instructor:Somebody else Room:Distance-Learning");
	}
	
	@Test
	void testReadFile() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 22122 4 Distance-Learning Joey Professor Thai");
			inFile.print("CMSC204 22123 4 Distance-Learning Somebody else");
			inFile.close();
			test.readFile(inputFile);
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}

}
