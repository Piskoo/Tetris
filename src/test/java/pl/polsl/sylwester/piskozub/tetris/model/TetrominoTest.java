package pl.polsl.sylwester.piskozub.tetris.model;

import java.awt.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Player class.
 *
 * @author Sylwester Piskozub
 * @version 1.4
 */
public class TetrominoTest {

    /**
     * Test of emptyElement method, of class Tetromino. Test should return empty
     * element.
     */
    @Test
    public void testShouldReturnEmptyElement() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);

        //WHEN
        int result = tetromino.emptyElement();

        //THEN
        int expResult = 0;
        assertEquals(expResult, result, "Element representing empty value is different than expected.");
    }

    /**
     * Test of filledElement method, of class Tetromino. Test should return
     * filled element.
     */
    @Test
    public void testShouldReturnFilledElement() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);

        //WHEN
        int result = tetromino.filledElement();

        //THEN
        int expResult = 1;
        assertEquals(expResult, result, "Element representing filled value is different than expected.");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on I
     * shaped tetromino.
     */
    @Test
    public void testShouldGetWidthOfIShapedTetromino() {
        //GIVEN
        Tetromino tetrominoI = new Tetromino(Shape.I, Color.red);

        //WHEN
        int resultShapeI = tetrominoI.getWidth();

        //THEN
        int expResultShapeI = 4;
        assertEquals(expResultShapeI, resultShapeI, "I shaped tetromino width is does not equal 4");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is perfomed on J shaped
     * tetromino.
     */
    @Test
    public void testShouldGetWidthOfJShapedTetromin() {
        //GIVEN
        Tetromino tetrominoJ = new Tetromino(Shape.J, Color.red);

        //WHEN
        int resultShapeJ = tetrominoJ.getWidth();

        //THEN
        int expResultShapeJ = 3;
        assertEquals(expResultShapeJ, resultShapeJ, "J shaped tetromino width does not equal 3");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on L
     * shaped tetromino.
     */
    @Test
    public void testShouldGetWidthOfLShapedTetromin() {
        //GIVEN
        Tetromino tetrominoL = new Tetromino(Shape.L, Color.red);

        //WHEN
        int resultShapeL = tetrominoL.getWidth();

        //THEN
        int expResultShapeL = 3;
        assertEquals(expResultShapeL, resultShapeL, "L shaped tetromino width does not equal 3");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on O
     * shaped tetromino.
     */
    @Test
    public void testShouldGetWidthOfOShapedTetromin() {
        //GIVEN
        Tetromino tetrominoO = new Tetromino(Shape.O, Color.red);

        //WHEN
        int resultShapeO = tetrominoO.getWidth();

        //THEN
        int expResultShapeO = 2;
        assertEquals(expResultShapeO, resultShapeO, "O shaped tetromino width does not equal 2");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on S
     * shaped tetromino.
     */
    @Test
    public void testShouldGetWidthOfSShapedTetromin() {
        //GIVEN
        Tetromino tetrominoS = new Tetromino(Shape.S, Color.red);

        //WHEN
        int resultShapeS = tetrominoS.getWidth();

        //THEN
        int expResultShapeS = 3;
        assertEquals(expResultShapeS, resultShapeS, "S shaped tetromino width does not equal 3");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on T
     * shaped tetromino.
     */
    @Test
    public void testShouldGetWidthOfTShapedTetromin() {
        //GIVEN
        Tetromino tetrominoT = new Tetromino(Shape.T, Color.red);

        //WHEN
        int resultShapeT = tetrominoT.getWidth();

        //THEN
        int expResultShapeT = 3;
        assertEquals(expResultShapeT, resultShapeT, "T shaped tetromino width does not equal 3");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on Z
     * shaped tetromino.
     */
    @Test
    public void testShouldGetWidthOfZShapedTetromin() {
        //GIVEN
        Tetromino tetrominoZ = new Tetromino(Shape.Z, Color.red);

        //WHEN
        int resultShapeZ = tetrominoZ.getWidth();

        //THEN
        int expResultShapeZ = 3;
        assertEquals(expResultShapeZ, resultShapeZ, "Z shaped tetromino width does not equal 3");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on I
     * shaped tetromino.
     */
    @Test
    public void testShouldGetHeightOfIShapedTetromino() {
        //GIVEN
        Tetromino tetrominoI = new Tetromino(Shape.I, Color.red);

        //WHEN
        int resultShapeI = tetrominoI.getHeight();

        //THEN
        int expResultShapeI = 1;
        assertEquals(expResultShapeI, resultShapeI, "I shaped tetromino height does not equal 1");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on J
     * shaped tetromino.
     */
    @Test
    public void testShouldGetHeightOfJShapedTetromino() {
        //GIVEN
        Tetromino tetrominoJ = new Tetromino(Shape.J, Color.red);

        //WHEN
        int resultShapeJ = tetrominoJ.getHeight();

        //THEN
        int expResultShapeJ = 2;
        assertEquals(expResultShapeJ, resultShapeJ, "J shaped tetromino height does not equal 2");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on L
     * shaped tetromino.
     */
    @Test
    public void testShouldGetHeightOfLShapedTetromino() {
        //GIVEN
        Tetromino tetrominoL = new Tetromino(Shape.L, Color.red);

        //WHEN
        int resultShapeL = tetrominoL.getHeight();

        //THEN
        int expResultShapeL = 2;
        assertEquals(expResultShapeL, resultShapeL, "L shaped tetromino height does not equal 2");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on O
     * shaped tetromino.
     */
    @Test
    public void testShouldGetHeightOfOShapedTetromino() {
        //GIVEN
        Tetromino tetrominoO = new Tetromino(Shape.O, Color.red);

        //WHEN
        int resultShapeO = tetrominoO.getHeight();

        //THEN
        int expResultShapeO = 2;
        assertEquals(expResultShapeO, resultShapeO, "O shaped tetromino height does not equal 2");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on S
     * shaped tetromino.
     */
    @Test
    public void testShouldGetHeightOfSShapedTetromino() {
        //GIVEN
        Tetromino tetrominoS = new Tetromino(Shape.S, Color.red);

        //WHEN
        int resultShapeS = tetrominoS.getHeight();

        //THEN
        int expResultShapeS = 2;
        assertEquals(expResultShapeS, resultShapeS, "S shaped tetromino height does not equal 2");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on T
     * shaped tetromino.
     */
    @Test
    public void testShouldGetHeightOfTShapedTetromino() {
        //GIVEN
        Tetromino tetrominoT = new Tetromino(Shape.T, Color.red);

        //WHEN
        int resultShapeT = tetrominoT.getHeight();

        //THEN
        int expResultShapeT = 2;
        assertEquals(expResultShapeT, resultShapeT, "T shaped tetromino height does not equal 2");
    }

    /**
     * Test of getWidth method, of class Tetromino. Test is performed on Z
     * shaped tetromino.
     */
    @Test
    public void testShouldGetHeightOfZShapedTetromino() {
        //GIVEN
        Tetromino tetrominoZ = new Tetromino(Shape.Z, Color.red);

        //WHEN
        int resultShapeZ = tetrominoZ.getHeight();

        //THEN
        int expResultShapeZ = 2;
        assertEquals(expResultShapeZ, resultShapeZ, "Z shaped tetromino height does not equal 2");
    }

    /**
     * Test of getElement method, of class Tetromino.
     */
    @Test
    public void testShouldThrowIndexOutOfBoundsExceptionOnGetElement() {
        //GIVEN
        Tetromino tetrominoI = new Tetromino(Shape.I, Color.red);

        //WHEN
        try {
            tetrominoI.getElement(1, 5);
        } //THEN
        catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("Did not catch IndexOutOfBoundsException");
    }

    /**
     * Test of getElement method, of class Tetromino. Test should retrun filled
     * element.
     */
    @Test
    public void testShouldReturnFilledElementOnGetElement() {
        //GIVEN
        Tetromino tetrominoI = new Tetromino(Shape.I, Color.red);

        //WHEN
        int result = tetrominoI.getElement(0, 0);

        //THEN
        int expResult = 1;
        assertEquals(expResult, result, "Element of tetromino is not filled");
    }

    /**
     * Test of getElement method, of class Tetromino. Test should retrun empty
     * element.
     */
    @Test
    public void testShouldReturnEmptyElementOnGetElement() {
        //GIVEN
        Tetromino tetrominoT = new Tetromino(Shape.T, Color.red);

        //WHEN
        int result = tetrominoT.getElement(0, 0);

        //THEN
        int expResult = 0;
        assertEquals(expResult, result, "Element of tetromino is not empty");
    }

    /**
     * Test of moveLeft method, of class Tetromino. Test should return position
     * shifted to left.
     */
    @Test
    public void testShouldMoveLeft() {
        //GIVEN
        Tetromino tetrominoI = new Tetromino(Shape.I, Color.red);
        tetrominoI.setPositionX(0);

        //WHEN
        tetrominoI.moveLeft();
        int result = tetrominoI.getPositionX();

        //THEN
        int expResult = -1;
        assertEquals(expResult, result, "Tetromino has not been moved to the left");
    }

    /**
     * Test of moveRight method, of class Tetromino. Test should return position
     * shifted to right.
     */
    @Test
    public void testShouldMoveRight() {
        //GIVEN
        Tetromino tetrominoI = new Tetromino(Shape.I, Color.red);
        tetrominoI.setPositionX(0);

        //WHEN
        tetrominoI.moveRight();
        int result = tetrominoI.getPositionX();

        //THEN
        int expResult = 1;
        assertEquals(expResult, result, "Tetromino has not been moved to the right");
    }

    /**
     * Test of moveDown method, of class Tetromino. Test should return position
     * shifted to bottom.
     */
    @Test
    public void testShouldMoveDown() {
        //GIVEN
        Tetromino tetrominoI = new Tetromino(Shape.I, Color.red);
        tetrominoI.setPositionY(0);

        //WHEN
        tetrominoI.moveDown();
        int result = tetrominoI.getPositionY();

        //THEN
        int expResult = 1;
        assertEquals(expResult, result, "Tetromino has not been moved down");
    }

    /**
     * Test of rotate method, of class Tetromino. Test is performed on I shaped
     * tetromino.
     */
    @Test
    public void testShouldRotateIShapedTetrominoClockwise() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.I, Color.red);

        //WHEN
        tetromino.rotate();

        //THEN
        assertEquals(1, tetromino.getElement(0, 0), "I Shaped has not beed rotated correctly, error in 0,0 position");
        assertEquals(1, tetromino.getElement(1, 0), "I Shaped has not beed rotated correctly, error in 1,0 position");
        assertEquals(1, tetromino.getElement(2, 0), "I Shaped has not beed rotated correctly, error in 2,0 position");
        assertEquals(1, tetromino.getElement(3, 0), "I Shaped has not beed rotated correctly, error in 3,0 position");
    }

    /**
     * Test of rotate method, of class Tetromino. Test is performed on J shaped
     * tetromino.
     */
    @Test
    public void testShouldRotateJShapedTetrominoClockwise() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.J, Color.red);

        //WHEN
        tetromino.rotate();

        //THEN
        assertEquals(1, tetromino.getElement(0, 0), "J shaped tetromino has not beed rotated correctly, error in 0,0 position");
        assertEquals(1, tetromino.getElement(0, 1), "J shaped tetromino has not beed rotated correctly, error in 0,1 position");
        assertEquals(1, tetromino.getElement(1, 0), "J shaped tetromino has not beed rotated correctly, error in 1,0 position");
        assertEquals(0, tetromino.getElement(1, 1), "J shaped tetromino has not beed rotated correctly, error in 1,1 position");
        assertEquals(1, tetromino.getElement(2, 0), "J shaped tetromino has not beed rotated correctly, error in 2,0 position");
        assertEquals(0, tetromino.getElement(2, 1), "J shaped tetromino has not beed rotated correctly, error in 2,1 position");
    }

    /**
     * Test of rotate method, of class Tetromino. Test is performed on L shaped
     * tetromino.
     */
    @Test
    public void testShouldRotateLShapedTetrominoClockwise() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.L, Color.red);

        //WHEN
        tetromino.rotate();

        //THEN
        assertEquals(1, tetromino.getElement(0, 0), "L shaped tetromino has not beed rotated correctly, error in 0,0 position");
        assertEquals(0, tetromino.getElement(0, 1), "L shaped tetromino has not beed rotated correctly, error in 0,1 position");
        assertEquals(1, tetromino.getElement(1, 0), "L shaped tetromino has not beed rotated correctly, error in 1,0 position");
        assertEquals(0, tetromino.getElement(1, 1), "L shaped tetromino has not beed rotated correctly, error in 1,1 position");
        assertEquals(1, tetromino.getElement(2, 0), "L shaped tetromino has not beed rotated correctly, error in 2,0 position");
        assertEquals(1, tetromino.getElement(2, 1), "L shaped tetromino has not beed rotated correctly, error in 2,1 position");
    }

    /**
     * Test of rotate method, of class Tetromino. Test is performed on O shaped
     * tetromino.
     */
    @Test
    public void testShouldRotateOShapedTetrominoClockwise() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.O, Color.red);

        //WHEN
        tetromino.rotate();

        //THEN
        assertEquals(1, tetromino.getElement(0, 0), "O shaped tetromino has not beed rotated correctly, error in 0,0 position");
        assertEquals(1, tetromino.getElement(0, 1), "O shaped tetromino has not beed rotated correctly, error in 0,1 position");
        assertEquals(1, tetromino.getElement(1, 0), "O shaped tetromino has not beed rotated correctly, error in 1,0 position");
        assertEquals(1, tetromino.getElement(1, 1), "O shaped tetromino has not beed rotated correctly, error in 1,1 position");
    }

    /**
     * Test of rotate method, of class Tetromino. Test is performed on S shaped
     * tetromino.
     */
    @Test
    public void testShouldRotateSShapedTetrominoClockwise() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.S, Color.red);

        //WHEN
        tetromino.rotate();

        //THEN
        assertEquals(1, tetromino.getElement(0, 0), "S shaped tetromino has not beed rotated correctly, error in 0,0 position");
        assertEquals(0, tetromino.getElement(0, 1), "S shaped tetromino has not beed rotated correctly, error in 0,1 position");
        assertEquals(1, tetromino.getElement(1, 0), "S shaped tetromino has not beed rotated correctly, error in 1,0 position");
        assertEquals(1, tetromino.getElement(1, 1), "S shaped tetromino has not beed rotated correctly, error in 1,1 position");
        assertEquals(0, tetromino.getElement(2, 0), "S shaped tetromino has not beed rotated correctly, error in 2,0 position");
        assertEquals(1, tetromino.getElement(2, 1), "S shaped tetromino has not beed rotated correctly, error in 2,1 position");
    }

    /**
     * Test of rotate method, of class Tetromino. Test is performed on T shaped
     * tetromino.
     */
    @Test
    public void testShouldRotateTShapedTetrominoClockwise() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.T, Color.red);

        //WHEN
        tetromino.rotate();

        //THEN
        assertEquals(1, tetromino.getElement(0, 0), "T shaped tetromino has not beed rotated correctly, error in 0,0 position");
        assertEquals(0, tetromino.getElement(0, 1), "T shaped tetromino has not beed rotated correctly, error in 0,1 position");
        assertEquals(1, tetromino.getElement(1, 0), "T shaped tetromino has not beed rotated correctly, error in 1,0 position");
        assertEquals(1, tetromino.getElement(1, 1), "T shaped tetromino has not beed rotated correctly, error in 1,1 position");
        assertEquals(1, tetromino.getElement(2, 0), "T shaped tetromino has not beed rotated correctly, error in 2,0 position");
        assertEquals(0, tetromino.getElement(2, 1), "T shaped tetromino has not beed rotated correctly, error in 2,1 position");
    }

    /**
     * Test of rotate method, of class Tetromino. Test is performed on Z shaped
     * tetromino.
     */
    @Test
    public void testShouldRotateZShapedTetrominoClockwise() {
        //GIVEN
        Tetromino tetromino = new Tetromino(Shape.Z, Color.red);

        //WHEN
        tetromino.rotate();

        //THEN
        assertEquals(0, tetromino.getElement(0, 0), "Z shaped tetromino has not beed rotated correctly, error in 0,0 position");
        assertEquals(1, tetromino.getElement(0, 1), "Z shaped tetromino has not beed rotated correctly, error in 0,1 position");
        assertEquals(1, tetromino.getElement(1, 0), "Z shaped tetromino has not beed rotated correctly, error in 1,0 position");
        assertEquals(1, tetromino.getElement(1, 1), "Z shaped tetromino has not beed rotated correctly, error in 1,1 position");
        assertEquals(1, tetromino.getElement(2, 0), "Z shaped tetromino has not beed rotated correctly, error in 2,0 position");
        assertEquals(0, tetromino.getElement(2, 1), "Z shaped tetromino has not beed rotated correctly, error in 2,1 position");
    }

}
