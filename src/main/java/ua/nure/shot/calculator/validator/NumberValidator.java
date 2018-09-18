package ua.nure.shot.calculator.validator;

import ua.nure.shot.calculator.exception.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.nure.shot.calculator.model.Constants.Messages.INCORRECT_INPUT_NUMBER_EXCEPTION_MESSAGE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class NumberValidator implements Validator<Object> {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    private static Validator<Object> validator;

    private NumberValidator() {
    }

    public static Validator<Object> getInstance() {
        if (validator == null) {
            synchronized (NumberValidator.class) {
                if (validator == null) {
                    validator = new NumberValidator();
                }
            }
        }
        return validator;
    }

    @Override
    public void validate(Object num) {
        Matcher numberMatcher = NUMBER_PATTERN.matcher(num.toString());

        if (!numberMatcher.find()) {
            throw new ValidationException(INCORRECT_INPUT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
