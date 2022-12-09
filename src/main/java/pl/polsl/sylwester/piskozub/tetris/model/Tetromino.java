package pl.polsl.sylwester.piskozub.tetris.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class represents tetris block called tetromino. A tetromino is a geometric
 * shape composed of four squares, connected orthogonally.
 *
 * @author Sylwester Piskozub
 * @version 1.13
 */
public class Tetromino {

    /**
     * Tetromino shape
     */
    private List<List<Integer>> tetrominoShape = new ArrayList<>();
    /**
     * Tetromino color
     */
    private final Color tetrominoColor;
    /**
     * Horizontal position of the top left square
     */
    private int positionX = 0;
    /**
     * Vertical position of the top left square
     */
    private int positionY = 0;

    /**
     * Constructor sets block shape, color and its position.
     *
     * @param shape shape of the block
     * @param tetrominoColor color of the block
     */
    public Tetromino(Shape shape, Color tetrominoColor) {
        fillShape(shape);
        this.tetrominoColor = tetrominoColor;
        positionX = (10 - getWidth()) / 2;
        positionY = -getHeight();
    }

    /**
     * Copy contructor, creates shallow copy.
     *
     * @param tetromino tetromino object to copy
     */
    public Tetromino(Tetromino tetromino) {
        this.tetrominoShape = tetromino.tetrominoShape;
        this.tetrominoColor = tetromino.tetrominoColor;
        this.positionX = tetromino.positionX;
        this.positionY = tetromino.positionY;
    }

    /**
     * Horizontal position setter.
     *
     * @param positionX horizontal position
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Vertical position setter.
     *
     * @param positionY vertical position
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Method returns integer that corresponds to empty square.
     *
     * @return the integer representation of the empty square
     */
    public int emptyElement() {
        return 0;
    }

    /**
     * Method returns integer that corresponds to filled square.
     *
     * @return the integer representation of the filled square
     */
    public int filledElement() {
        return 1;
    }

    /**
     * Method returns horizontal position of top left corner square
     *
     * @return horizonal position
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Method returns vertical position of top left corner square
     *
     * @return vertical position
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Method returns tetromino height
     *
     * @return the tetromino height
     */
    public final int getHeight() {
        return tetrominoShape.size();
    }

    /**
     * Method returns tetromino width
     *
     * @return the tetromino width
     */
    public final int getWidth() {
        return tetrominoShape.get(0).size();
    }

    /**
     * Method returns value contained in the specified row and column
     *
     * @param row horizontal position
     * @param col vertical position
     * @return the value contained
     */
    public int getElement(int row, int col) {
        return tetrominoShape.get(row).get(col);
    }

    /**
     * Method used to control tetromino position, decreases horizontal
     * coordinate. Movement to the left.
     */
    public void moveLeft() {
        this.positionX--;
    }

    /**
     * Method used to control tetromino position, increases horizontal
     * coordinate. Movement to the right.
     */
    public void moveRight() {
        this.positionX++;
    }

    /**
     * Method used to control tetromino position, increases vertical coordinate.
     * Movement down.
     */
    public void moveDown() {
        this.positionY++;
    }

    /**
     * Method used to rotate tetromino clockwise. Shape gets transposed first
     * then content of rows is reversed.
     */
    public void rotate() {
        List<List<Integer>> newShape = IntStream.range(0, tetrominoShape.get(0).size())
                .mapToObj(i -> tetrominoShape.stream().map(l -> l.get(i)).collect(Collectors.toList()))
                .collect(Collectors.toList());
        for (List<Integer> i : newShape) {
            Collections.reverse(i);
        }
        tetrominoShape = newShape;

    }

    /**
     * Tetromino color getter
     *
     * @return the block color
     */
    public Color getColor() {
        return tetrominoColor;
    }

    /**
     * Method fills shape container
     *
     * @param shape type of tetromino
     */
    private void fillShape(Shape shape) {
        switch (shape) {
            case I ->
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1, 1, 1)));
            case J -> {
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 0, 0)));
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1, 1)));
            }
            case L -> {
                tetrominoShape.add(new ArrayList(Arrays.asList(0, 0, 1)));
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1, 1)));
            }
            case O -> {
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1)));
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1)));
            }
            case S -> {
                tetrominoShape.add(new ArrayList(Arrays.asList(0, 1, 1)));
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1, 0)));
            }
            case T -> {
                tetrominoShape.add(new ArrayList(Arrays.asList(0, 1, 0)));
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1, 1)));
            }
            case Z -> {
                tetrominoShape.add(new ArrayList(Arrays.asList(1, 1, 0)));
                tetrominoShape.add(new ArrayList(Arrays.asList(0, 1, 1)));
            }
        }
    }

}
