package pl.polsl.sylwester.piskozub.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import pl.polsl.sylwester.piskozub.tetris.model.GameBoard;
import pl.polsl.sylwester.piskozub.tetris.model.Tetromino;

/**
 * Class represents the playfield where the game takes place
 *
 * @author Sylwester Piskozub
 * @version 1.10
 */
public class GameView extends JPanel {

    /**
     * Game window used to show the pane
     */
    private final JFrame gameWindow;
    /**
     * Size of a square that represents one tile in the game
     */
    private final int cellSize = 32;
    /**
     * Game board that is being draw
     */
    private final GameBoard gameBoard;
    /**
     * Tetromino that is being draw
     */
    private Tetromino currentTetromino;

    /**
     * Constructor sets the window,game board used and initializes components
     *
     * @param gameWindow game window
     * @param gameBoard game board that will be drew
     */
    public GameView(JFrame gameWindow, GameBoard gameBoard) {
        this.gameWindow = gameWindow;
        this.gameBoard = gameBoard;
        initGameWindow();
    }

    /**
     * Method sets new tetromino block to draw
     *
     * @param tetromino tetromino block
     */
    public void addTetromino(Tetromino tetromino) {
        currentTetromino = tetromino;
    }

    /**
     * Method adds game controls to the pane
     *
     * @param keyStroke key stroke action
     * @param label label for key stroke action performed
     * @param abstractAction action performed as a result of key stroke
     */
    public void setGameControl(KeyStroke keyStroke, String label, AbstractAction abstractAction) {
        this.getInputMap().put(keyStroke, label);
        this.getActionMap().put(label, abstractAction);
    }

    /**
     * Method adds this pane to the game window
     */
    @Override
    public void show() {
        gameWindow.add(this, BorderLayout.CENTER);
        gameWindow.setVisible(true);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * Method removes this pane from the game window
     */
    @Override
    public void hide() {
        gameWindow.remove(this);
    }

    /**
     * Method called to repaint current pane
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentTetromino != null && gameBoard != null) {
            drawTetromino(g);
            drawGameBoard(g);
        }
    }

    /**
     * Method draws tetromino black on the pane
     */
    private void drawTetromino(Graphics g) {
        for (int i = 0; i != currentTetromino.getHeight(); i++) {
            for (int j = 0; j != currentTetromino.getWidth(); j++) {
                if (currentTetromino.getElement(i, j) != currentTetromino.emptyElement()) {
                    int tetrominoPositionX = (currentTetromino.getPositionX() + j) * cellSize;
                    int tetrominoPositionY = (currentTetromino.getPositionY() + i) * cellSize;
                    g.setColor(currentTetromino.getColor());
                    g.fillRect(tetrominoPositionX, tetrominoPositionY, cellSize, cellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(tetrominoPositionX, tetrominoPositionY, cellSize, cellSize);
                }
            }
        }
    }

    /**
     * Method draws rectangular game board on the pane
     */
    private void drawGameBoard(Graphics g) {
        for (int i = 0; i != gameBoard.getHeight(); i++) {
            for (int j = 0; j != gameBoard.getWidth(); j++) {
                if (gameBoard.getElement(i, j) != gameBoard.emptyElement()) {
                    int positionX = j * cellSize;
                    int positionY = i * cellSize;
                    g.setColor(gameBoard.getElement(i, j));
                    g.fillRect(positionX, positionY, cellSize, cellSize);
                    g.setColor(Color.BLACK);
                    g.drawRect(positionX, positionY, cellSize, cellSize);
                }
            }
        }
    }

    /**
     * Method initializes the pane
     */
    private void initGameWindow() {
        this.setPreferredSize(new Dimension(gameBoard.getWidth() * cellSize, gameBoard.getHeight() * cellSize));
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
