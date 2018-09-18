package ua.nure.shot.calculator.validator;

import ua.nure.shot.calculator.exception.ValidationException;
import ua.nure.shot.calculator.model.ShotType;

import static ua.nure.shot.calculator.model.Constants.Messages.ILLEGAL_SHOT_TYPE_EXCEPTION_MESSAGE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ShotTypeValidator implements Validator<Object> {

    private static Validator<Object> validator;

    private ShotTypeValidator() {
    }

    public static Validator<Object> getInstance() {
        if (validator == null) {
            synchronized (ShotTypeValidator.class) {
                if (validator == null) {
                    validator = new ShotTypeValidator();
                }
            }
        }
        return validator;
    }

    @Override
    public void validate(Object shotType) {
        if (!ShotType.isShotType(shotType.toString())) {
            throw new ValidationException(ILLEGAL_SHOT_TYPE_EXCEPTION_MESSAGE);
        }
    }
}
