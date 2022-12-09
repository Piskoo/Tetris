package pl.polsl.sylwester.piskozub.tetris.model;

/**
 * Class represents scoreboard record
 *
 * @author Sylwester Piskozub
 * @version 1.1
 */
public class Record {

    /**
     * Points counter
     */
    private final int points;
    /**
     * Associated with points position
     */
    private int position;
    /**
     * Associated with points player name
     */
    private final String name;

    /**
     * Contructor used to make a record
     *
     * @param position score position
     * @param name player name
     * @param points player score
     */
    public Record(int position, String name, int points) {
        this.position = position;
        this.name = name;
        this.points = points;
    }

    /**
     * Position getter
     *
     * @return record position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Name getter
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Points getter
     *
     * @return player points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Position setter
     */
    public void setPosition(int position) {
        this.position = position;
    }

}
