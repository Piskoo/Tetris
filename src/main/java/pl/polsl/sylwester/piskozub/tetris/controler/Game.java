package pl.polsl.sylwester.piskozub.tetris.controler;

import java.awt.Color;
import javax.swing.JFrame;
import pl.polsl.sylwester.piskozub.tetris.model.Player;

/**
 * Class processes application parameters and initalizes basic components used
 * for a whole duration of the program
 *
 * @author Sylwester Piskozub
 * @version 2.2
 */
public class Game implements Runnable {

    /**
     * Game window
     */
    private final JFrame gameWindow = new JFrame();
    /**
     * Player information
     */
    private final Player player;

    /**
     * Constructor initializes game window and calls method responsible for
     * processing program parameters
     *
     * @param args first arg - player name
     */
    public Game(String[] args) {
        initGameWindow();
        if (args.length > 0) {
            player = new Player(args[0]);
        } else {
            player = new Player();
        }
    }

    /**
     * Method starts controler responsible for menu
     */
    @Override
    public void run() {
        MenuControler menuControler = new MenuControler(gameWindow, player);
        menuControler.start();
    }

    /**
     * Method configures the frame
     */
    private void initGameWindow() {
        gameWindow.setTitle("Tetris");
        gameWindow.setResizable(false);
        gameWindow.setBackground(Color.red);
        gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameWindow.setVisible(true);
    }

}
