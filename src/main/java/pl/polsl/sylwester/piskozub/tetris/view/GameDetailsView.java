package pl.polsl.sylwester.piskozub.tetris.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Class represents game details visiable in the game window
 *
 * @author Sylwester Piskozub
 * @version 1.4
 */
public class GameDetailsView extends JPanel {

    /**
     * Game window used to show the pane
     */
    private final JFrame gameWindow;
    /**
     * Label that shows current amount of points
     */
    private final JLabel points = new JLabel();
    /**
     * Label that shows game over notification
     */
    private final JLabel gameOver = new JLabel();

    /**
     * Constructor sets the window used and initializes components
     *
     * @param gameWindow game window
     */
    public GameDetailsView(JFrame gameWindow) {
        this.gameWindow = gameWindow;
        initGameWindow();
    }

    /**
     * Method adds this pane to the game window
     */
    @Override
    public void show() {
        gameWindow.add(this, BorderLayout.PAGE_START);
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
     * Method updates points display
     *
     * @param pts points to display
     */
    public void updatePoints(int pts) {
        points.setText("Points: " + Integer.toString(pts));
    }

    /**
     * Method prints game over notification in the game
     *
     */
    public void showGameOver() {
        this.add(gameOver);
        revalidate();
        repaint();
    }

    /**
     * Method initializes the pane
     */
    private void initGameWindow() {
        this.setPreferredSize(new Dimension(gameWindow.getWidth(), 120));
        this.setLayout(new BoxLayout(this, Y_AXIS));
        points.setText("Points: 0");
        points.setFont(new Font("Serif", Font.PLAIN, 20));
        points.setAlignmentX(CENTER_ALIGNMENT);
        points.setForeground(Color.white);
        gameOver.setText("Game Over");
        gameOver.setForeground(Color.white);
        gameOver.setFont(new Font("Serif", Font.PLAIN, 20));
        gameOver.setAlignmentX(CENTER_ALIGNMENT);
        this.setBackground(Color.DARK_GRAY);
        this.add(points);
        this.add(Box.createRigidArea(new Dimension(0, 50)));
        this.setVisible(true);
    }
}
