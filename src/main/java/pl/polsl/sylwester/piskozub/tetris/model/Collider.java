package pl.polsl.sylwester.piskozub.tetris.model;

/**
 * Class enables collision tests between game objects
 *
 * @author Sylwester Piskozub
 * @version 1.5
 */
public class Collider {

    /**
     * Non-parameter constructor
     */
    public Collider() {
    }

    /**
     * Method for each part of the tetromino block checks if a block directly
     * below it is outside gameboard bounds or is filled.
     *
     * @param tetromino tetris block
     * @param gameBoard game board
     * @return true if any block below is out of gameboard bounds or is filled
     */
    public boolean isCollisionBottom(Tetromino tetromino, GameBoard gameBoard) {
        for (int i = 0; i != tetromino.getHeight(); i++) {
            for (int j = 0; j != tetromino.getWidth(); j++) {
                if (tetromino.getElement(i, j) != tetromino.emptyElement()) {
                    if (tetromino.getPositionY() + i == gameBoard.getHeight() - 1) {
                        return true;
                    }
                    if (tetromino.getPositionY() + i >= 0) {
                        if (gameBoard.getElement(tetromino.getPositionY() + i + 1, tetromino.getPositionX() + j) != gameBoard.emptyElement()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method for each part of the tetromino block checks if a block to the left
     * of it is outside gameboard bounds or is filled.
     *
     * @param tetromino tetris block
     * @param gameBoard game board
     * @return true if any block to the left is out of gameboard bounds or is
     * filled
     */
    public boolean isCollisionLeft(Tetromino tetromino, GameBoard gameBoard) {
        for (int i = 0; i != tetromino.getHeight(); i++) {
            for (int j = 0; j != tetromino.getWidth(); j++) {
                if (tetromino.getElement(i, j) != tetromino.emptyElement()) {
                    if (tetromino.getPositionX() + j == 0) {
                        return true;
                    }
                    if (tetromino.getPositionX() + j > 0 && tetromino.getPositionY() + i > 0) {
                        if (gameBoard.getElement(tetromino.getPositionY() + i, tetromino.getPositionX() + j - 1) != gameBoard.emptyElement()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method for each part of the tetromino block checks if a block to the
     * right of it is outside gameboard bounds or is filled.
     *
     * @param tetromino tetris block
     * @param gameBoard game board
     * @return true if any block to the right is out of gameboard bounds or is
     * filled
     */
    public boolean isCollisionRight(Tetromino tetromino, GameBoard gameBoard) {
        for (int i = 0; i != tetromino.getHeight(); i++) {
            for (int j = 0; j != tetromino.getWidth(); j++) {
                if (tetromino.getElement(i, j) != tetromino.emptyElement()) {
                    if (tetromino.getPositionX() + j == gameBoard.getWidth() - 1) {
                        return true;
                    }
                    if (tetromino.getPositionX() + j < gameBoard.getWidth() - 1 && tetromino.getPositionY() + i > 0) {
                        if (gameBoard.getElement(tetromino.getPositionY() + i, tetromino.getPositionX() + j + 1) != gameBoard.emptyElement()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method for each part of the tetromino block checks if rotating it
     * clockwise 90 degrees causes of out gameboard bounds positions or
     * overlapping with already filled gameboard blocks
     *
     * @param tetromino tetris block
     * @param gameBoard game board
     * @return true if any tetromino part overlaps or goes out of bounds
     */
    public boolean isCollisionRotate(Tetromino tetromino, GameBoard gameBoard) {
        if (tetromino.getPositionX() + tetromino.getHeight() - 1 > gameBoard.getWidth() - 1) {
            return true;
        }
        if (tetromino.getPositionY() + tetromino.getWidth() - 1 > gameBoard.getHeight() - 1) {
            return true;
        }
        Tetromino copy = new Tetromino(tetromino);
        copy.rotate();
        for (int i = 0; i != copy.getHeight(); i++) {
            for (int j = 0; j != copy.getWidth(); j++) {
                if (copy.getPositionY() + i > 0) {
                    if (gameBoard.getElement(copy.getPositionY() + i, copy.getPositionX() + j) != gameBoard.emptyElement()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Method tests if in the second to highest row on the gameboard exists
     * filled block and if there is, directly above it, a filled tetris block
     * part.
     *
     * @param tetromino tetris block
     * @param gameBoard game board
     * @return true if in a column a tetromino part exists in the highest row on
     * the gameboard and in the same column second to the highest row of the
     * gameboard is filled.
     */
    public boolean isCollisionEndOfTheGame(Tetromino tetromino, GameBoard gameBoard) {
        for (int i = 0; i < gameBoard.getWidth(); i++) {
            if (gameBoard.getElement(1, i) != gameBoard.emptyElement()) {
                for (int j = 0; j != tetromino.getWidth(); j++) {
                    if (tetromino.getElement(tetromino.getHeight() - 1, j) != tetromino.emptyElement()) {
                        if (tetromino.getPositionX() + j == i) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
