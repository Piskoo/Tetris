package pl.polsl.sylwester.piskozub.tetris.controler;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JFrame;
import pl.polsl.sylwester.piskozub.tetris.exception.NoValueException;
import pl.polsl.sylwester.piskozub.tetris.model.Player;
import pl.polsl.sylwester.piskozub.tetris.model.Scoreboard;
import pl.polsl.sylwester.piskozub.tetris.view.MenuView;
import pl.polsl.sylwester.piskozub.tetris.view.NameSelectionView;
import pl.polsl.sylwester.piskozub.tetris.view.ScoreboardView;

/**
 * Class represents controler that reacts to a action taken by user in menu
 *
 * @author Sylwester Piskozub
 * @version 2.1
 */
public class MenuControler {

    /**
     * Game window
     */
    private final JFrame gameWindow;
    /**
     * Visual representation of menu
     */
    private final MenuView menuView;
    /**
     * Player information
     */
    private final Player player;
    /**
     * Visual representation that asks for player name input
     */
    private final NameSelectionView nameSelectionView;
    /**
     * Visual representation that asks for player name input
     */
    private final ScoreboardView scoreboardView;

    /**
     * Constructor sets the window used and initializes components such as
     * action listeners
     *
     * @param gameWindow game window
     * @param player player information
     */
    public MenuControler(JFrame gameWindow, Player player) {
        this.gameWindow = gameWindow;
        this.player = player;
        menuView = new MenuView(gameWindow);
        nameSelectionView = new NameSelectionView(gameWindow);
        scoreboardView = new ScoreboardView(gameWindow);
        setupActionListeners();
    }

    /**
     * Method displays main menu in the game window
     */
    public void start() {
        menuView.show();
    }

    /**
     * Method on start button click takes appropriate action, if player name has
     * been set up via program parameters, launches the game. If it wasn't
     * passed as a paramter displays appropriate form.
     */
    private void startButtonPressed() {
        menuView.handleStartButtonAction((ActionEvent e) -> {
            menuView.hide();
            if (player.getPlayerName() == null) {
                nameSelectionView.show();
            } else {
                GameControler gameControler = new GameControler(gameWindow, player, scoreboardView);
                gameControler.start();
            }
        });
    }

    /**
     * Method on scoreboard button click takes appropriate action.
     */
    private void scoreboardButtonPressed() {
        menuView.handleScoreboardButtonAction((ActionEvent e) -> {
            menuView.hide();
            Scoreboard scoreboard = new Scoreboard();
            try {
                scoreboard.readDataFromFile();
            } catch (IOException ex) {
                scoreboardView.addErrorNotification();
            }
            for (int i = 0; i != scoreboard.getSize(); ++i) {
                scoreboardView.addNewRecord(scoreboard.getRow(i));
            }
            scoreboardView.show();
        });
    }

    /**
     * Method on quit button click closes the program.
     */
    private void quitButtonPressed() {
        menuView.handleQuitButtonAction((ActionEvent e) -> {
            gameWindow.dispose();
        });
    }

    /**
     * Method on submit button click sets player name to the one entered, or
     * shows error notification if name field was empty
     */
    private void submitButtonPressed() {
        nameSelectionView.handleSubmitButtonAction((ActionEvent e) -> {
            nameSelectionView.hide();
            try {
                player.setPlayerName(nameSelectionView.getPlayerInput());
                GameControler gameControler = new GameControler(gameWindow, player, scoreboardView);
                gameControler.start();
            } catch (NoValueException ex) {
                nameSelectionView.addErrorNotification();
                nameSelectionView.show();
            }
        });
    }

    /**
     * Method on back button click closes the program shows main menu
     */
    private void backButtonPressed() {
        scoreboardView.handleBackButtonAction((ActionEvent e) -> {
            scoreboardView.hide();
            menuView.show();
        });
    }

    /**
     * Method adds all of the action listeners to buttons
     */
    private void setupActionListeners() {
        startButtonPressed();
        scoreboardButtonPressed();
        quitButtonPressed();
        submitButtonPressed();
        backButtonPressed();
    }

}
