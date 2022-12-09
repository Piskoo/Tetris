package pl.polsl.sylwester.piskozub.tetris.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents game board
 *
 * @author Sylwester Piskozub
 * @version 1.6
 */
public class GameBoard {

    /**
     * Game board height
     */
    public final int rows = 20;
    /**
     * Game board width
     */
    public final int columns = 10;
    /**
     * Game board representation
     */
    private final List<List<Color>> gameBoard = new ArrayList<>();

    /**
     * Non-parameter constructor
     */
    public GameBoard() {
        for(int i = 0; i != rows;++i){
            gameBoard.add(new ArrayList<>());
            for(int j = 0; j != columns;++j){
                gameBoard.get(i).add(null);
            }
        }
    }

    /**
     * Method returns game board width
     *
     * @return the game board width
     */
    public int getWidth() {
        return columns;
    }

    /**
     * Method returns game board height
     *
     * @return the game board height
     */
    public int getHeight() {
        return rows;
    }

    /**
     * Method returns game board element
     *
     * @param row horizontal position
     * @param col vertical position
     * @return the game board element
     */
    public Color getElement(int row, int col) {
        return gameBoard.get(row).get(col);
    }

    /**
     * Method returns if requested element is empty
     *
     * @param row horizontal position
     * @param col vertical position
     * @return true if element is empty
     */
    public boolean isEmpty(int row, int col) {
        return gameBoard.get(row).get(col) == null;
    }

    /**
     * Method returns game board empty element
     *
     * @return empty element
     */
    public Color emptyElement() {
        return null;
    }

    /**
     * Method fills game board with non-empty block of tetromino of the same
     * color
     *
     * @param tetromino the block used to fill game board
     */
    public void fillGameBoard(Tetromino tetromino) {
        for (int i = 0; i != tetromino.getHeight(); i++) {
            for (int j = 0; j != tetromino.getWidth(); j++) {
                if (tetromino.getElement(i, j) != tetromino.emptyElement()) {
                    if (tetromino.getPositionY() >= 0) {
                        gameBoard.get(tetromino.getPositionY() + i).set(tetromino.getPositionX() + j,tetromino.getColor());
                    }
                }
            }
        }
    }

    /**
     * Method checks if there are full rows in the game board, removes them and
     * shifts down everything that was above the removed row
     *
     * @return amount of rows removed
     */
    public int removeFullRows() {
        int removedRows = 0;
        for (int i = 0; i != getHeight(); i++) {
            int counter = 0;
            for(Color element : gameBoard.get(i)){
                if(element == emptyElement()){
                    break;
                } else {
                    counter++;
                }
            }
            if (counter == getWidth()) {
                for (int j = i; j != 0; j--) {
                    for (int k = 0; k != getWidth(); k++) {
                        gameBoard.get(j).set(k, gameBoard.get(j - 1).get(k));
                    }
                }
                removedRows++;
            }
        }
        return removedRows;
    }

}
