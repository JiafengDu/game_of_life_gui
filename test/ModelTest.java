import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ModelTest {
    private IModel board;

    @Before
    public void setUp(){
        board = new Model();
    }

    /***
     * test initializeBoard method to initalize a board
     */
    @Test
    public void initializeBoard() {
        board.initializeBoard(2);
        String res = Arrays.deepToString(new String[][] {{"false", "false"},{"false", "false"}});
        assertEquals(res, board.toString());
    }
    /***
     * test updateCell method to update a cell in the board
     */
    @Test
    public void updateCell() {
        board.initializeBoard(2);
        board.updateCell(0,0);
        String res = Arrays.deepToString(new String[][] {{"true", "false"},{"false", "false"}});
        assertEquals(res, board.toString());
    }
    /***
     * test updateBoard method to return a new board with updated cell according to the 1th rule
     */
    @Test
    public void updateBoard1() {
        board.initializeBoard(2);
        board.updateCell(0,0);
        board.updateCell(0,1);
        board.updateCell(1,0);
        IModel newBoard = board.updateBoard();
        String res = Arrays.deepToString(new String[][] {{"true", "true"},{"true", "true"}});
        assertEquals(res, newBoard.toString());
    }
    /***
     * test updateBoard method to return a new board with updated cell according to the 2th rule
     */
    @Test
    public void updateBoard2() {
        board.initializeBoard(3);
        board.updateCell(0,0);
        board.updateCell(0,1);
        board.updateCell(1,0);
        board.updateCell(1,1);
        board.updateCell(1,2);
        IModel newBoard = board.updateBoard();
        String res = Arrays.deepToString(new String[][] {{"true", "false", "true"},{"true", "false", "true"},{"false", "true", "false"}});
        System.out.println(res);
        assertEquals(res, newBoard.toString());
    }
    /***
     * test updateBoard method to return a new board with updated cell according to the 3th rule
     */
    @Test
    public void updateBoard3() {
        board.initializeBoard(2);
        board.updateCell(0,0);
        board.updateCell(0,1);
        IModel newBoard = board.updateBoard();
        String res = Arrays.deepToString(new String[][] {{"false", "false"},{"false", "false"}});
        assertEquals(res, newBoard.toString());
    }
    /***
     * test updateBoard method to return a new board with updated cell according to the 4th rule
     */
    @Test
    public void updateBoard4() {
        board.initializeBoard(2);
        board.updateCell(0,0);
        board.updateCell(0,1);
        board.updateCell(1,0);
        IModel newBoard = board.updateBoard();
        String res = Arrays.deepToString(new String[][] {{"true", "true"},{"true", "true"}});
        assertEquals(res, newBoard.toString());
    }
}