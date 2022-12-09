package pl.polsl.sylwester.piskozub.tetris.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Class represents a table that contains other players highest score.
 *
 * @author Sylwester Piskozub
 * @version 1.1
 */
public class ScoreboardView extends JPanel {

    /**
     * Game window used to show the pane
     */
    private final JFrame gameWindow;
    /**
     * Holder for score data
     */
    private final DefaultTableModel scoreboardModel = new DefaultTableModel();
    /**
     * Holder for score data
     */
    private final JTable scoreboard = new JTable(scoreboardModel);
    /**
     * JTable holder
     */
    private final JScrollPane scrollpane = new JScrollPane(scoreboard);
    /**
     * Back button
     */
    private final JButton backButton = new JButton();
    /**
     * Label that holds failed to open file notification
     */
    private final JLabel failedToOpenFileNotification = new JLabel();

    /**
     * Constructor sets the window used and initializes components
     *
     * @param gameWindow game window
     */
    public ScoreboardView(JFrame gameWindow) {
        this.gameWindow = gameWindow;
        initScoreboardPanel();
    }

    /**
     * Method adds action listener to the back button
     *
     * @param actionListener the action listener added
     */
    public void handleBackButtonAction(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
    
    /**
     * Method adds record to JTable
     *
     * @param record data that should be added to table
     */
    public void addNewRecord(String[] record) {
        scoreboardModel.addRow(record);
        scoreboard.setPreferredScrollableViewportSize(new Dimension(225, scoreboard.getPreferredSize().height));
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
        scoreboardModel.setRowCount(0);
        this.remove(failedToOpenFileNotification);
        gameWindow.remove(this);
    }

    /**
     * Method adds failed to open file notification
     */
    public void addErrorNotification() {
        this.add(failedToOpenFileNotification);
    }

    /**
     * Method initializes the pane
     */
    private void initScoreboardPanel() {
        this.setLayout(new BoxLayout(this, Y_AXIS));
        scoreboard.setRowHeight(30);
        backButton.setText("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreboardModel.setColumnIdentifiers(new String[]{"Position", "Player name", "Player score"});
        failedToOpenFileNotification.setText("Failed to open scoreboard file");
        failedToOpenFileNotification.setAlignmentX(Component.CENTER_ALIGNMENT);
        failedToOpenFileNotification.setForeground(Color.red);
        this.add(scrollpane);
        this.add(backButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
    }

}
