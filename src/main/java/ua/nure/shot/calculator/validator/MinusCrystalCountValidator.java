package ua.nure.shot.calculator.validator;

import ua.nure.shot.calculator.exception.ValidationException;

import static ua.nure.shot.calculator.model.Constants.Messages.CRYSTAL_COUNT_CAN_NOT_BE_MINUS_VALUE_EXCEPTION_MESSAGE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class MinusCrystalCountValidator implements Validator<Long> {

    private static Validator<Long> validator;

    private MinusCrystalCountValidator() {
    }

    public static Validator<Long> getInstance() {
        if (validator == null) {
            synchronized (MinusCrystalCountValidator.class) {
                if (validator == null) {
                    validator = new MinusCrystalCountValidator();
                }
            }
        }
        return validator;
    }

    @Override
    public void validate(Long crystalCount) {
        if (crystalCount < 0) {
            throw new ValidationException(CRYSTAL_COUNT_CAN_NOT_BE_MINUS_VALUE_EXCEPTION_MESSAGE);
        }
    }
}
