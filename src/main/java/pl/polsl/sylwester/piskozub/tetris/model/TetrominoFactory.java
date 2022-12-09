package pl.polsl.sylwester.piskozub.tetris.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class creates Tetromino objects with predetermined shape and color
 *
 * @author Sylwester Piskozub
 * @version 1.6
 */
public class TetrominoFactory {

    /**
     * Colors collection
     */
    private final List<Color> colorTypes = new ArrayList<>();

    /**
     * Non-parameter constructor, initializes color and shape containers
     */
    public TetrominoFactory() {
        initColors();
    }

    /**
     * Method returns Tetromino object randomized with values contained in shape
     * and color collections
     *
     * @return a Tetromino block
     */
    public Tetromino getTetromino() {
        Random random = new Random();
        return new Tetromino(Shape.values()[random.nextInt(Shape.values().length)],
                colorTypes.get(random.nextInt(colorTypes.size())));
    }

    /**
     * Method fills color container
     */
    private void initColors() {
        colorTypes.add(new Color(0, 240, 240)); // cyan color
        colorTypes.add(new Color(0, 0, 240)); // blue color
        colorTypes.add(new Color(240, 160, 0)); // orange color
        colorTypes.add(new Color(240, 240, 0)); // yellow color
        colorTypes.add(new Color(0, 240, 0)); // green color
        colorTypes.add(new Color(160, 0, 240)); // purple color
        colorTypes.add(new Color(240, 0, 0)); // red color

    }

}
