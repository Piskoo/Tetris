package pl.polsl.sylwester.piskozub.tetris.model;

import java.awt.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Collider class.
 *
 * @author Sylwester Piskozub
 * @version 1.3
 */
public class ColliderTest {

    /**
     * Test of isCollisionBottom method, of class Collider. Test validates
     * whether method returns false for no collision scenario.
     */
    @Test
    public void testShouldNotCollisionWithBottomSideOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionY(0);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionBottom(tetromino, gameBoard);

        //THEN
        assertFalse(result, "Collision with bottom side of the map occured");
    }

    /**
     * Test of isCollisionBottom method, of class Collider. Test validates
     * whether method returns true if collision with bottoms side gameboard
     * bounds happens.
     */
    @Test
    public void testShouldCollisionWithBottomSideOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionY(gameBoard.getHeight() - tetromino.getHeight());
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionBottom(tetromino, gameBoard);

        //THEN
        assertTrue(result, "No collision with bottom side of the map occured");
    }

    /**
     * Test of isCollisionBottom method, of class Collider. Test validates
     * whether method returns true if collision with filled parts of the game
     * board on the bottom side of the tetromino happens.
     */
    @Test
    public void testShouldCollisionBottomWithFilledPartOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.O, Color.red);
        tetrominoToFill.setPositionX(0);
        tetrominoToFill.setPositionY(gameBoard.getHeight() - tetrominoToFill.getHeight());
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.T, Color.red);
        tetrominoToCollide.setPositionX(1);
        tetrominoToCollide.setPositionY(gameBoard.getHeight() - tetrominoToFill.getHeight() - tetrominoToCollide.getHeight());
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionBottom(tetrominoToCollide, gameBoard);

        //THEN
        assertTrue(result, "No bottom collision with filled part of the gameboard occured");
    }

    /**
     * Test of isCollisionBottom method, of class Collider. Test validates
     * whether method returns false if collision with filled parts of the game
     * board on the bottom side of the tetromino didn't happen.
     */
    @Test
    public void testShouldNotCollisionBottomWithFilledPartOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.O, Color.red);
        tetrominoToFill.setPositionX(0);
        tetrominoToFill.setPositionY(gameBoard.getHeight() - tetrominoToFill.getHeight());
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.T, Color.red);
        tetrominoToCollide.setPositionX(1);
        tetrominoToCollide.setPositionY(0);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionBottom(tetrominoToCollide, gameBoard);

        //THEN
        assertFalse(result, "Collision bottom with filled part of the gameboard occured");
    }

    /**
     * Test of isCollisionLeft method, of class Collider. Test validates whether
     * method returns false for no collision scenario.
     */
    @Test
    public void testShouldNotCollisionWithLeftSideOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionX(3);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionLeft(tetromino, gameBoard);

        //THEN
        assertFalse(result, "Collision with left side of the map occured");
    }

    /**
     * Test of isCollisionLeft method, of class Collider. Test validates whether
     * method returns true if collision with left side of the gameboard bounds
     * happens.
     */
    @Test
    public void testShouldCollisionWithLeftSideOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionX(0);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionLeft(tetromino, gameBoard);

        //THEN
        assertTrue(result, "No collision with left side of the map occured");
    }

    /**
     * Test of isCollisionLeft method, of class Collider. Test validates whether
     * method returns true if collision with filled parts of the game board on
     * the left side of the tetromino happens.
     */
    @Test
    public void testShouldCollisionLeftWithFilledPartOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.O, Color.red);
        tetrominoToFill.setPositionX(1);
        tetrominoToFill.setPositionY(1);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.O, Color.red);
        tetrominoToCollide.setPositionX(3);
        tetrominoToCollide.setPositionY(1);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionLeft(tetrominoToCollide, gameBoard);

        //THEN
        assertTrue(result, "No left collision with filled part of the gameboard occured");
    }

    /**
     * Test of isCollisionLeft method, of class Collider. Test validates whether
     * method returns false if collision with filled parts of the game board on
     * the left side of the tetromino didn't happen.
     */
    @Test
    public void testShouldNotCollisionLeftWithFilledPartOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.O, Color.red);
        tetrominoToFill.setPositionX(1);
        tetrominoToFill.setPositionY(1);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.O, Color.red);
        tetrominoToCollide.setPositionX(3);
        tetrominoToCollide.setPositionY(3);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionLeft(tetrominoToCollide, gameBoard);

        //THEN
        assertFalse(result, "Collision left with filled part of the gameboard occured");
    }

    /**
     * Test of isCollisionRight method, of class Collider. Test validates
     * whether method returns false for no collision scenario.
     */
    @Test
    public void testShouldNotCollisionWithRightSideOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionX(5);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRight(tetromino, gameBoard);

        //THEN
        assertFalse(result, "Collision with right side of the map occured");
    }

    /**
     * Test of isCollisionRight method, of class Collider. Test validates
     * whether method returns true if collision with right side of the gameboard
     * bounds happens.
     */
    @Test
    public void testShouldCollisionWithRightSideOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionX(9);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRight(tetromino, gameBoard);

        //THEN
        assertTrue(result, "No collision with right side of the map occured");
    }

    /**
     * Test of isCollisionRight method, of class Collider. Test validates
     * whether method returns true if collision with filled parts of the game
     * board on the right side of the tetromino happens.
     */
    @Test
    public void testShouldCollisionRightWithFilledPartOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.O, Color.red);
        tetrominoToFill.setPositionX(3);
        tetrominoToFill.setPositionY(1);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.O, Color.red);
        tetrominoToCollide.setPositionX(1);
        tetrominoToCollide.setPositionY(1);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRight(tetrominoToCollide, gameBoard);

        //THEN
        assertTrue(result, "No right collision with filled part of the gameboard occured");
    }

    /**
     * Test of isCollisionRight method, of class Collider. Test validates
     * whether method returns false if collision with filled parts of the game
     * board on the right side of the tetromino didn't happen.
     */
    @Test
    public void testShouldNotCollisionRightWithFilledPartOfGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.O, Color.red);
        tetrominoToFill.setPositionX(5);
        tetrominoToFill.setPositionY(5);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.O, Color.red);
        tetrominoToCollide.setPositionX(3);
        tetrominoToCollide.setPositionY(3);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRight(tetrominoToCollide, gameBoard);

        //THEN
        assertFalse(result, "Collision right with filled part of the gameboard occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns false for no collision scenario.
     */
    @Test
    public void testShouldNotCollisionRotateWithGameBoardOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionY(5);
        tetromino.setPositionX(5);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetromino, gameBoard);

        //THEN
        assertFalse(result, "Collision rotate with gameboard occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns true if collision with bottom side of the
     * gameboard bounds upon rotation happens.
     */
    @Test
    public void testShouldCollisionRotateWithGameBoardBottomSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionY(17);
        tetromino.setPositionX(3);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetromino, gameBoard);

        //THEN
        assertTrue(result, "No collision rotate with bottom side of the gameboard occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns false if collision with bottom side of the
     * gameboard bounds upon rotation did not happen.
     */
    @Test
    public void testShouldNotCollisionRotateWithGameBoardBottomSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionY(16);
        tetromino.setPositionX(3);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetromino, gameBoard);

        //THEN
        assertFalse(result, "No collision rotate with bottom side of the gameboard occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns true if collision with right side of the gameboard
     * bounds upon rotation happens.
     */
    @Test
    public void testShouldCollisionRotateWithGameBoardRightSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionY(10);
        tetromino.setPositionX(7);
        tetromino.rotate();
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetromino, gameBoard);

        //THEN
        assertTrue(result, "No collision rotate with right side of the gameboard occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns false if collision with right side of the
     * gameboard bounds upon rotation did not happen.
     */
    @Test
    public void testShouldNotCollisionRotateWithGameBoardRightSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);
        tetromino.setPositionY(10);
        tetromino.setPositionX(6);
        tetromino.rotate();
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetromino, gameBoard);

        //THEN
        assertFalse(result, "No collision rotate with right side of the gameboard occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns false if collision with filled parts of the game
     * board on the right side of the tetromino upon rotation did not happen.
     */
    @Test
    public void testShouldNotCollisionRotateWithFilledPartOfGameBoardOnRightSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.I, Color.red);
        tetrominoToFill.rotate();
        tetrominoToFill.setPositionY(0);
        tetrominoToFill.setPositionX(9);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.I, Color.red);
        tetrominoToCollide.setPositionY(5);
        tetrominoToCollide.setPositionX(5);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetrominoToCollide, gameBoard);

        //THEN
        assertFalse(result, "Collision rotate with filled part of the gameboard on the right side occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns true if collision with filled parts of the game
     * board on the right side of the tetromino upon rotation happens.
     */
    @Test
    public void testShouldCollisionRotateWithFilledPartOfGameBoardOnRightSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.I, Color.red);
        tetrominoToFill.setPositionY(0);
        tetrominoToFill.setPositionX(7);
        tetrominoToFill.rotate();

        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.I, Color.red);
        tetrominoToCollide.rotate();
        tetrominoToCollide.setPositionY(1);
        tetrominoToCollide.setPositionX(6);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetrominoToCollide, gameBoard);

        //THEN
        assertTrue(result, "No collision rotate with filled part of the gameboard on the right side occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns true if collision with filled parts of the game
     * board on the bottom side of the tetromino upon rotation did not happen.
     */
    @Test
    public void testShouldNotCollisionRotateWithFilledPartOfGameBoardOnBottomSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.I, Color.red);
        tetrominoToFill.setPositionY(10);
        tetrominoToFill.setPositionX(5);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.I, Color.red);
        tetrominoToCollide.setPositionY(5);
        tetrominoToCollide.setPositionX(5);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetrominoToCollide, gameBoard);

        //THEN
        assertFalse(result, "Collision rotate with filled part of the gameboard on the bottom side occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns false if collision with filled parts of the game
     * board on the bottom side of the tetromino upon rotation happens.
     */
    @Test
    public void testShouldCollisionRotateWithFilledPartOfGameBoardOnBottomSideOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.I, Color.red);
        tetrominoToFill.setPositionY(10);
        tetrominoToFill.setPositionX(5);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.I, Color.red);
        tetrominoToCollide.setPositionY(8);
        tetrominoToCollide.setPositionX(5);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionRotate(tetrominoToCollide, gameBoard);

        //THEN
        assertTrue(result, "No collision rotate with filled part of the gameboard on the bottom side occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns false for no collision scenario.
     */
    @Test
    public void testShouldNotCollisionEndOfTheGameOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.I, Color.red);
        tetrominoToFill.setPositionY(1);
        tetrominoToFill.setPositionX(0);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.I, Color.red);
        tetrominoToCollide.setPositionY(0);
        tetrominoToCollide.setPositionX(5);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionEndOfTheGame(tetrominoToCollide, gameBoard);

        //THEN
        assertFalse(result, "Collision end of the game occured");
    }

    /**
     * Test of isCollisionRotate method, of class Collider. Test validates
     * whether method returns true if collision on the bottom side of the
     * tetromino with filled parts that are in the second row happens.
     */
    @Test
    public void testShouldCollisionEndOfTheGameOccured() {
        //GIVEN
        GameBoard gameBoard = new GameBoard();
        Tetromino tetrominoToFill = new Tetromino(Shape.I, Color.red);
        tetrominoToFill.setPositionY(1);
        tetrominoToFill.setPositionX(0);
        gameBoard.fillGameBoard(tetrominoToFill);
        Tetromino tetrominoToCollide = new Tetromino(Shape.I, Color.red);
        tetrominoToCollide.setPositionY(0);
        tetrominoToCollide.setPositionX(3);
        Collider collider = new Collider();

        //WHEN
        boolean result = collider.isCollisionEndOfTheGame(tetrominoToCollide, gameBoard);

        //THEN
        assertTrue(result, "Collision end of the game occured");
    }

}
