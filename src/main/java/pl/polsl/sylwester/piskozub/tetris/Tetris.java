package pl.polsl.sylwester.piskozub.tetris;

import pl.polsl.sylwester.piskozub.tetris.controler.Game;

/**
 * Main class of the application tetris.
 *
 * @author Sylwester Piskozub
 * @version 1.3
 */
public class Tetris {

    /**
     * Main method of the application. Makes the Game object and starts the game
     *
     * @param args first arg - player name
     */
    public static void main(String[] args) {

        Game game = new Game(args);
        game.run();
    }
}
