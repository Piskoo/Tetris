package pl.polsl.sylwester.piskozub.tetris.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class represents initial menu that user sees
 *
 * @author Sylwester Piskozub
 * @version 1.6
 */
public class MenuView extends JPanel {

    /**
     * Game window used to show the pane
     */
    private final JFrame gameWindow;
    /**
     * Start button
     */
    private final JButton startButton = new JButton();
    /**
     * Scoreboard button
     */
    private final JButton scoreboardButton = new JButton();
    /**
     * Quit the game button
     */
    private final JButton quitButton = new JButton();

    /**
     * Constructor sets the window used and initializes components
     *
     * @param gameWindow game window
     */
    public MenuView(JFrame gameWindow) {
        super();
        this.gameWindow = gameWindow;
        initMenuPanel();
    }

    /**
     * Method adds action listener to the start button
     *
     * @param actionListener the action listener added
     */
    public void handleStartButtonAction(ActionListener actionListener) {
        startButton.addActionListener(actionListener);
    }

    /**
     * Method adds action listener to the scoreboard button
     *
     * @param actionListener the action listener added
     */
    public void handleScoreboardButtonAction(ActionListener actionListener) {
        scoreboardButton.addActionListener(actionListener);
    }

    /**
     * Method adds action listener to quit button
     *
     * @param actionListener the action listener added
     */
    public void handleQuitButtonAction(ActionListener actionListener) {
        quitButton.addActionListener(actionListener);
    }

    /**
     * Method adds this pane to the game window
     */
    @Override
    public void show() {
        gameWindow.add(this);
        gameWindow.pack();
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
    }

    /**
     * Method removes this pane from the game window
     */
    @Override
    public void hide() {
        gameWindow.remove(this);
    }

    /**
     * Method initializes the pane
     */
    private void initMenuPanel() {
        this.setLayout(new BoxLayout(this, Y_AXIS));
        startButton.setText("Start");
        scoreboardButton.setText("Scoreboard");
        quitButton.setText("Quit");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(200, 50)));
        this.add(startButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(scoreboardButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(quitButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
    }

}
