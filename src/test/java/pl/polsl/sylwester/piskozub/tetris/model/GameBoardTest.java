package pl.polsl.sylwester.piskozub.tetris.model;

import java.awt.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for GameBoard class.
 *
 * @author Sylwester Piskozub
 * @version 1.1
 */
public class GameBoardTest {

    /**
     * Test of getElement method, of class GameBoard. Test returns empty element
     * from bottom right corner of the gameboard.
     */
    @Test
    public void testShouldGetEmptyElement() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();

        //WHEN
        Color result = gameBoard.getElement(19, 9);

        //THEN
        assertNull(result, "Gameboard element is not empty");
    }

    /**
     * Test of isEmpty method, of class GameBoard. Test returns true for
     * specified empty element.
     */
    @Test
    public void testShouldReturnTrueForEmptyElement() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();

        //WHEN
        boolean result = gameBoard.isEmpty(0, 0);

        //THEN
        assertTrue(result, "Gameboard element is not empty");
    }

    /**
     * Test of emptyElement method, of class GameBoard. Test performs a check if
     * empty element is null.
     */
    @Test
    public void testShouldReturnEmptyElement() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();

        //WHEN
        Color result = gameBoard.emptyElement();

        //THEN
        assertNull(result, "Empty element is different than expected");
    }

    /**
     * Test of fillGameBoard method, of class GameBoard. Test fills gameboard
     * with O shaped tetromino i makes checks if action was performed correctly.
     */
    @Test
    public void testShouldFillGameBoardWithOShapedTetromino() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.O, Color.red);
        tetromino.setPositionX(0);
        tetromino.setPositionY(0);

        //WHEN
        gameBoard.fillGameBoard(tetromino);

        //THEN
        assertEquals(Color.red, gameBoard.getElement(0, 0), "Game board element 0,0 has not been filled");
        assertEquals(Color.red, gameBoard.getElement(0, 1), "Game board element 0,1 has not been filled");
        assertEquals(Color.red, gameBoard.getElement(1, 0), "Game board element 1,0 has not been filled");
        assertEquals(Color.red, gameBoard.getElement(1, 1), "Game board element 1,1 has not been filled");
    }

    /**
     * Test of removeFullRows method, of class GameBoard. Test removes 0 rows
     * from empty gameboard.
     */
    @Test
    public void testShouldNotRemoveAnyFullRows() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();

        //WHEN
        int result = gameBoard.removeFullRows();

        //THEN
        int expResult = 0;
        assertEquals(expResult, result, "Some full rows have been removed");
    }

    /**
     * Test of removeFullRows method, of class GameBoard. Test removes 2 rows
     * from gameboard that had 2 rows filled.
     */
    @Test
    public void testShouldRemoveTwoFullRows() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        for (int i = 0; i != 5; i++) {
            Tetromino tetromino = new Tetromino(Shape.O, Color.red);
            tetromino.setPositionX(i * 2);
            tetromino.setPositionY(18);
            gameBoard.fillGameBoard(tetromino);
        }

        //WHEN
        int result = gameBoard.removeFullRows();

        //THEN
        int expResult = 2;
        assertEquals(expResult, result, "Two full rows have not been removed");
    }

    /**
     * Test of removeFullRows method, of class GameBoard. Test removes 4 rows
     * from gameboard that had 4 rows filled.
     */
    @Test
    public void testShouldRemoveFourFullRows() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        for (int i = 0; i != 2; i++) {
            for (int j = 0; j != 5; j++) {
                Tetromino tetromino = new Tetromino(Shape.O, Color.red);
                tetromino.setPositionX(j * 2);
                tetromino.setPositionY(18 - i * 2);
                gameBoard.fillGameBoard(tetromino);
            }
        }

        //WHEN
        int result = gameBoard.removeFullRows();

        //THEN
        int expResult = 4;
        assertEquals(expResult, result, "Four full rows have not been removed");
    }

}
