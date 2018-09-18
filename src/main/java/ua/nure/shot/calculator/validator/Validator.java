package ua.nure.shot.calculator.validator;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public interface Validator<T> {

    /**
     * Throws an exception, when arg incorrect, otherwise do nothing.
     *
     * @throws ua.nure.shot.calculator.exception.ValidationException when arg is incorrect
     * @param arg input arg to validation
     */
    void validate(T arg);
}
