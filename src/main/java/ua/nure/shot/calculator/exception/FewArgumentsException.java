package ua.nure.shot.calculator.exception;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class FewArgumentsException extends RuntimeException {

    public FewArgumentsException(String message) {
        super(message);
    }
}
