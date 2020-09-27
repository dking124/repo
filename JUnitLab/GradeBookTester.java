import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	GradeBook g1, g2;
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(95);
		g1.addScore(80);
		g2.addScore(92.5);
		g2.addScore(79);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("95.0 80.0 "));
		assertTrue(g2.toString().equals("92.5 79.0 "));
	}

	@Test
	void testSum() {
		assertEquals(175, g1.sum(), .0001);
		assertEquals(171.5, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		assertEquals(80, g1.minimum(), .001);
		assertEquals(79, g2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(95, g1.finalScore());
		assertEquals(92.5, g2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize(), .001);
		assertEquals(2, g2.getScoreSize(), .001);
	}

	@Test
	void testToString() {
		assertTrue(g1.toString().equals("95.0 80.0 "));
		assertTrue(g2.toString().equals("92.5 79.0 "));
	}

}
