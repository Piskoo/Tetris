package pl.polsl.sylwester.piskozub.tetris.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.polsl.sylwester.piskozub.tetris.exception.NoValueException;

/**
 * Test class for Player class.
 *
 * @author Sylwester Piskozub
 * @version 1.2
 */
public class PlayerTest {

    /**
     * Test of addPoints method, of class Player. Test given points adds points
     * twice.
     *
     * @param pointsToAdd points that will be added twice
     * @param totalPoints resulted points after addition
     */
    @ParameterizedTest
    @CsvSource({"10,20", "20,40", "30,60", "40,80", "50,100"})
    public void testShouldAddPointsToPlayerScore(String pointsToAdd, String totalPoints) {
        //GIVEN
        Player player = new Player();

        //WHEN
        player.addPoints(Integer.parseInt(pointsToAdd));
        player.addPoints(Integer.parseInt(pointsToAdd));
        int result = player.getPlayerScore();

        //THEN
        int expResult = Integer.parseInt(totalPoints);
        assertEquals(expResult, result, "Player score is not equal to expected result");
    }

    /**
     * Test of resetPlayerScore method, of class Player. Test performs a check
     * if player points have been reseted corretly.
     */
    @Test
    public void testShouldResetPlayerScore() {
        //GIVEN
        Player player = new Player();
        player.addPoints(10);

        //WHEN
        player.resetPlayerScore();
        int result = player.getPlayerScore();

        //THEN
        int expResult = 0;
        assertEquals(expResult, result, "Reseted player score is not 0");
    }

    /**
     * Test of resetPlayerScore method, of class Player. Test is performed to
     * check if NoValueException is thrown when empty String is provided.
     */
    @Test
    public void testShouldThrowExceptionWhenNameIsEmpty() {
        //GIVEN
        Player player = new Player();

        //WHEN
        try {
            player.setPlayerName("");
        } //THEN
        catch (NoValueException e) {
            return;
        }
        fail("Did not catch NoValueException");
    }

}
