package pl.polsl.sylwester.piskozub.tetris.model;

import pl.polsl.sylwester.piskozub.tetris.exception.NoValueException;

/**
 * Class represents player
 *
 * @author Sylwester Piskozub
 * @version 1.7
 */
public class Player {

    /**
     * Player name
     */
    private String playerName;
    /**
     * Player score
     */
    private int playerScore;

    /**
     * Non-parameter constructor
     */
    public Player() {
    }

    /**
     * Constructor sets player name
     *
     * @param name player name
     */
    public Player(String name) {
        playerName = name;
    }

    /**
     * Method returns player name
     *
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Method returns player score
     *
     * @return the player score
     */
    public int getPlayerScore() {
        return this.playerScore;
    }

    /**
     * Method sets player name
     *
     * @param playerName player name
     * @throws NoValueException when attemt to assign empty name
     */
    public void setPlayerName(String playerName) throws NoValueException {
        if (playerName.equals("")) {
            throw new NoValueException();
        } else {
            this.playerName = playerName;
        }
    }

    /**
     * Method adds requested amount of points to player score
     *
     * @param points amount of points to add
     */
    public void addPoints(int points) {
        this.playerScore += points;
    }

    /**
     * Method sets player score to 0
     */
    public void resetPlayerScore() {
        this.playerScore = 0;
    }

    /**
     * Method sets player score to empty
     */
    public void resetPlayerName() {
        this.playerName = null;
    }

}
