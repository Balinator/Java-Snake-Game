package test;

import org.junit.Test;
import src.Board;
import src.Element;

import static org.junit.Assert.*;

/**
 * Created by Balinator on 2018. 11. 29..
 */
public class BoardTest {
    private Board board = new Board();

    @Test
    public void test() {
        assertFalse(board.isSuicide(1));
    }

    @Test
    public void testTimerStarted() {
        assertTrue(board.timer.isRunning());
    }

    @Test
    public void testTimerStopped() {
        board.endGame();
        assertFalse(board.timer.isRunning());
    }

    @Test
    public void testGetScore() {
        Element e = new Element(null, 4, 0, 0);
        assertEquals(5,board.getScore(e));
    }

    @Test
    public void testGetHigherScore() {
        Element e = new Element(null, 4, 0, 0);
        assertNotSame(10,board.getScore(e));
    }

    @Test
    public void testCommitedSuicide() {
        board.helperFunction(-10, 50);
        assertTrue(board.commitedSuicide());
    }

    @Test
    public void testnotCommitedSuicide() {
        board.helperFunction(10, 50);
        assertFalse(board.commitedSuicide());
    }

}