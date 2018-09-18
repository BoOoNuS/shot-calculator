package ua.nure.shot.calculator.exception;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
