package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import src.Board;
import src.Element;

class BoardTest {
	private Board board = new Board();

	@Test
	void test() {
		assertFalse(board.isSuicide(1));
	}
	
	@Test
	void testTimerStarted() {
		assertTrue(board.timer.isRunning());
	}
	
	@Test
	void testTimerStopped() {
		board.endGame();
		assertFalse(board.timer.isRunning());
	}
	
	@Test
	void testGetScore() {
		Element e = new Element(null, 4, 0, 0);
		assertEquals(5,board.getScore(e));
	}
	
	@Test
	void testGetHigherScore() {
		Element e = new Element(null, 4, 0, 0);
		assertNotEquals(10,board.getScore(e));
	}
	
	@Test
	void testCommitedSuicide() {
		board.helperFunction(-10, 50);
		assertTrue(board.commitedSuicide());
	}
	
	@Test
	void testnotCommitedSuicide() {
		board.helperFunction(10, 50);
		assertFalse(board.commitedSuicide());
	}

}