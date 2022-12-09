package pl.polsl.sylwester.piskozub.tetris.controler;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import pl.polsl.sylwester.piskozub.tetris.model.Collider;
import pl.polsl.sylwester.piskozub.tetris.model.Player;
import pl.polsl.sylwester.piskozub.tetris.model.GameBoard;
import pl.polsl.sylwester.piskozub.tetris.model.Scoreboard;
import pl.polsl.sylwester.piskozub.tetris.model.Tetromino;
import pl.polsl.sylwester.piskozub.tetris.model.TetrominoFactory;
import pl.polsl.sylwester.piskozub.tetris.view.GameDetailsView;
import pl.polsl.sylwester.piskozub.tetris.view.GameView;
import pl.polsl.sylwester.piskozub.tetris.view.ScoreboardView;

/**
 * Class represents controler that reacts to a action taken by user in the game
 * and what is displayed at the time
 *
 * @author Sylwester Piskozub
 * @version 2.3
 */
public class GameControler {

    /**
     * Game board
     */
    private final GameBoard gameBoard = new GameBoard();
    /**
     * Player information
     */
    private final Player player;
    /**
     * Visual representation of game board
     */
    private final GameView gameView;
    /**
     * Visual representation of player score and level
     */
    private final GameDetailsView gameDetailsView;
    /**
     * Game refresh interval
     */
    private final int framesPerSecond = 60;
    /**
     * Used to get another tetromino
     */
    private final TetrominoFactory tetrominoFactory = new TetrominoFactory();
    /**
     * Currently existing tetromino
     */
    private Tetromino tetromino;
    /**
     * Collision tester betwen tetromino and game board
     */
    private final Collider collider = new Collider();
    /**
     * Tetromino drop down interval
     */
    private final int dropDownDelay = 500;
    /**
     * Scoreboard view
     */
    private final ScoreboardView scoreboardView;

    /**
     * Constructor sets the window used and creates first tetromino
     *
     * @param gameWindow game window
     * @param player player information
     * @param scoreboardView scoreboard view used to jump to scoreboard at the
     * end of the game
     */
    public GameControler(JFrame gameWindow, Player player, ScoreboardView scoreboardView) {
        this.player = player;
        this.scoreboardView = scoreboardView;
        gameView = new GameView(gameWindow, gameBoard);
        gameDetailsView = new GameDetailsView(gameWindow);
        tetromino = tetrominoFactory.getTetromino();
        gameView.addTetromino(tetromino);
        tetrominoControls(tetromino, collider);
    }

    /**
     * Method sets game looped behaviour such as tetromino drop down by certain
     * interval, bottom collision handler and game over handler.
     */
    public void start() {
        gameDetailsView.show();
        gameView.show();
        Timer moveDownTimer = new Timer(dropDownDelay, (ActionEvent e) -> {
            if (!collider.isCollisionBottom(tetromino, gameBoard)) {
                tetromino.moveDown();
            }
        });
        moveDownTimer.start();
        Timer boardUpdateTimer = new Timer(1000 / framesPerSecond, (ActionEvent e) -> {
            handleTetrmoinoBottomCollision(moveDownTimer);
            if (collider.isCollisionEndOfTheGame(tetromino, gameBoard)) {
                gameDetailsView.showGameOver();
                moveDownTimer.stop();
                gameView.repaint();
                gameDetailsView.repaint();
                ((Timer) e.getSource()).stop();
                handleGameOverSituation();
            }
            gameView.repaint();
        });
        boardUpdateTimer.start();
    }

    /**
     * Method used to handle game over event, adds player information to
     * scoreboard, performs reset on player information and shows updated
     * scoreboard.
     */
    private void handleGameOverSituation() {
        Timer gameOverDelay = new Timer(3000, (ActionEvent ev) -> {
            gameDetailsView.hide();
            gameView.hide();
            Scoreboard scoreboard = new Scoreboard();
            try {
                scoreboard.readDataFromFile();
            } catch (IOException ex) {
                scoreboardView.addErrorNotification();
            }
            scoreboard.addRow(player);
            for (int i = 0; i != scoreboard.getSize(); ++i) {
                scoreboardView.addNewRecord(scoreboard.getRow(i));
            }
            try {
                scoreboard.saveDataToFile();
            } catch (IOException ex) {
                scoreboardView.addErrorNotification();
            }
            scoreboardView.show();
            player.resetPlayerScore();
            player.resetPlayerName();
            ((Timer) ev.getSource()).stop();
        });
        gameOverDelay.start();
    }

    /**
     * Method controls what happens when bottom collision that will not end the
     * game happened. In order gameboard is filled with current tetromino
     * position, full rows are removed, new tetromino is made and moved down
     * once.
     */
    private void handleTetrmoinoBottomCollision(Timer moveDownTimer) {
        if (collider.isCollisionBottom(tetromino, gameBoard) && !collider.isCollisionEndOfTheGame(tetromino, gameBoard)) {
            gameBoard.fillGameBoard(tetromino);
            int rows = gameBoard.removeFullRows();
            handlePoints(rows);
            gameDetailsView.updatePoints(player.getPlayerScore());
            tetromino = tetrominoFactory.getTetromino();
            tetrominoControls(tetromino, collider);
            gameView.addTetromino(tetromino);
            tetromino.moveDown();
            moveDownTimer.restart();
        }
    }

    /**
     * Method controls how many points gets added accodring to how many rows
     * have been removed.
     */
    private void handlePoints(int rows) {
        switch (rows) {
            case 1 ->
                player.addPoints(40);
            case 2 ->
                player.addPoints(100);
            case 3 ->
                player.addPoints(300);
            case 4 ->
                player.addPoints(1200);
        }
    }

    /**
     * Method maps W,S,A,D and SPACE key strokes to appropriate in game action.
     * W - rotate tetromino; S - drop tetromino down once; A - move tetromino to
     * the left; D - move tetromino to the right; SPACE - drop tetromino down
     * until it collides
     *
     * @param tetromino controled tetromino
     * @param collider collider that tests if collision happens
     */
    private void tetrominoControls(Tetromino tetromino, Collider collider) {
        gameView.setGameControl(KeyStroke.getKeyStroke('S', 0), "S", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!collider.isCollisionBottom(tetromino, gameBoard)) {
                    tetromino.moveDown();
                }
            }
        });

        gameView.setGameControl(KeyStroke.getKeyStroke('A', 0), "A", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!collider.isCollisionLeft(tetromino, gameBoard)) {
                    tetromino.moveLeft();
                }
            }
        });

        gameView.setGameControl(KeyStroke.getKeyStroke('D', 0), "D", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!collider.isCollisionRight(tetromino, gameBoard)) {
                    tetromino.moveRight();
                }
            }
        });

        gameView.setGameControl(KeyStroke.getKeyStroke('W', 0), "W", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!collider.isCollisionRotate(tetromino, gameBoard)) {
                    tetromino.rotate();
                }
            }
        });

        gameView.setGameControl(KeyStroke.getKeyStroke("SPACE"), "SPACE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (!collider.isCollisionBottom(tetromino, gameBoard)) {
                    tetromino.moveDown();
                }
            }
        });

    }

}
