package pl.polsl.sylwester.piskozub.tetris.model;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Scoreboard class.
 *
 * @author Sylwester Piskozub
 * @version 1.0
 */
public class ScoreboardTest {

    /**
     * Test of getRow method, of class Scoreboard. Test performs a check if
     * records are being returned correctly
     */
    @Test
    public void testShouldGetScoreboardRow() {
        //GIVEN
        Player player = new Player("name");
        player.addPoints(20);
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.addRow(player);

        //WHEN
        String[] result = scoreboard.getRow(0);

        //THEN
        String[] expResult = new String[3];
        expResult[0] = "1";
        expResult[1] = "name";
        expResult[2] = "20";
        assertArrayEquals(expResult, result, "Added row is different than expected.");
    }

    /**
     * Test of getSize method, of class Scoreboard. Test performs a check if
     * scoreboard is empty at the point of creation.
     */
    @Test
    public void testShouldThrowIndexOutOfBoundsException() {
        //GIVEN
        Scoreboard scoreboard = new Scoreboard();

        //WHEN
        try {
            scoreboard.getRow(0);
        } //THEN
        catch (IndexOutOfBoundsException e) {
            return;
        }
        fail("Did not throw index out of bounds exception");
    }

    /**
     * Test of getSize method, of class Scoreboard. Test performs a check if
     * scoreboard size is correct
     */
    @Test
    public void testShouldGetScoreBoardSize() {
        //GIVEN
        Player player = new Player("name");
        player.addPoints(20);
        Scoreboard scoreboard = new Scoreboard();
        for (int i = 0; i != 5; i++) {
            scoreboard.addRow(player);
        }

        //WHEN
        int result = scoreboard.getSize();

        //THEN
        int expResult = 5;
        assertEquals(expResult, result, "Scoreboard size is different than expected.");
    }

    /**
     * Test of addRow method, of class Scoreboard. Test performs a check if row
     * creation works correctly
     */
    @Test
    public void testShouldAddRowToScoreboardData() {
        //GIVEN
        Player player = new Player("name");
        player.addPoints(20);
        Scoreboard scoreboard = new Scoreboard();

        //WHEN
        scoreboard.addRow(player);

        //THEN
        String[] expResult = new String[3];
        expResult[0] = "1";
        expResult[1] = "name";
        expResult[2] = "20";
        assertArrayEquals(expResult, scoreboard.getRow(0), "Added row is different than expected.");
    }

    /**
     * Test of readDataFromFile method, of class Scoreboard. Test performs a
     * check if method throws exception then file does not exist.
     */
    @Test
    public void testShouldThrowIOExceptionOnFileLoad() {
        //GIVEN
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.setFileName("test.txt");

        //WHEN
        try {
            scoreboard.readDataFromFile();
        } //THEN
        catch (IOException ex) {
            return;
        }
        fail("Did not catch IOException, file test.txt exists");
    }

    /**
     * Test of readDataFromFile method, of class Scoreboard. Test performs a
     * check if scoreboard file that exists is opened correctly.
     */
    @Test
    public void testShouldOpenFileAndLoadData() {
        //GIVEN
        Scoreboard scoreboard = new Scoreboard();
        File file = new File(scoreboard.getFileName());

        //WHEN
        if (file.exists()) {
            try {
                scoreboard.readDataFromFile();
            } catch (IOException ex) {
                fail("Scoreboard data file exist but it is corrupted!");
            }
        }

        //THEN
        return;
    }

}
