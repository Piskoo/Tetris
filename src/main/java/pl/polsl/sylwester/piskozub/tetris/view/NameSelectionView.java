package pl.polsl.sylwester.piskozub.tetris.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class represents a panel which enables player to type in their name
 *
 * @author Sylwester Piskozub
 * @version 1.4
 */
public class NameSelectionView extends JPanel {

    /**
     * Game window used to show the pane
     */
    private final JFrame gameWindow;
    /**
     * Text area where user can input their name
     */
    private final JTextField nameInputField = new JTextField();
    /**
     * Text area description
     */
    private final JLabel nameInputDescription = new JLabel();
    /**
     * Submit button
     */
    private final JButton submitButton = new JButton();
    /**
     * Label that holds wrong name notificaion
     */
    private final JLabel emptyFieldErrorNotification = new JLabel();

    /**
     * Constructor sets the window used and initializes components
     *
     * @param gameWindow game window
     */
    public NameSelectionView(JFrame gameWindow) {
        super();
        this.gameWindow = gameWindow;
        initNameSelectionPanel();
    }

    /**
     * Method adds action listener to the submit button
     *
     * @param actionListener the action listener added
     */
    public void handleSubmitButtonAction(ActionListener actionListener) {
        submitButton.addActionListener(actionListener);
    }

    /**
     * Method takes the input from text box and returns it
     *
     * @return player name
     */
    public String getPlayerInput() {
        return nameInputField.getText();
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
        this.remove(emptyFieldErrorNotification);
        gameWindow.remove(this);
    }

    /**
     * Method adds empty field box notification
     */
    public void addErrorNotification() {
        this.add(emptyFieldErrorNotification);
    }

    /**
     * Method initializes the pane
     */
    private void initNameSelectionPanel() {
        this.setLayout(new BoxLayout(this, Y_AXIS));
        nameInputDescription.setText("Enter your name: ");
        nameInputDescription.setFont(new Font("Serif", Font.PLAIN, 20));
        nameInputField.setFont(new Font("Serif", Font.PLAIN, 20));
        submitButton.setText("Submit");
        emptyFieldErrorNotification.setText("Name field cannot be empty!");
        emptyFieldErrorNotification.setForeground(Color.red);
        nameInputDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameInputField.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        emptyFieldErrorNotification.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(200, 50)));
        this.add(nameInputDescription);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(nameInputField);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(submitButton);
        this.add(Box.createRigidArea(new Dimension(0, 10)));
    }
}
