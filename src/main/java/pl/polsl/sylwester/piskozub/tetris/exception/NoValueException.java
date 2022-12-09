package pl.polsl.sylwester.piskozub.tetris.exception;

/**
 * Exception class for objects thrown when they have been submited empty, with
 * no value.
 *
 * @author Sylwester Piskozub
 * @version 1.0
 */
public class NoValueException extends Exception {

    /**
     * Non-parameter constructor
     */
    public NoValueException() {
        super();
    }

    /**
     * Exception class constructor
     *
     * @param message display message
     */
    public NoValueException(String message) {
        super(message);
    }

}
