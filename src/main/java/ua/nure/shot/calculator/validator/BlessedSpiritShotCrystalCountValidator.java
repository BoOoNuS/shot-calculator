package ua.nure.shot.calculator.validator;

import ua.nure.shot.calculator.exception.ValidationException;

import static ua.nure.shot.calculator.model.Constants.Messages.TO_CREATE_BLESSED_SPIRIT_SHOT_EXCEPTION_MESSAGE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class BlessedSpiritShotCrystalCountValidator implements Validator<Long> {

    private static Validator<Long> validator;

    private BlessedSpiritShotCrystalCountValidator() {
    }

    public static Validator<Long> getInstance() {
        if (validator == null) {
            synchronized (BlessedSpiritShotCrystalCountValidator.class) {
                if (validator == null) {
                    validator = new BlessedSpiritShotCrystalCountValidator();
                }
            }
        }
        return validator;
    }

    @Override
    public void validate(Long crystalCount) {
        if (crystalCount < 2) {
            throw new ValidationException(TO_CREATE_BLESSED_SPIRIT_SHOT_EXCEPTION_MESSAGE);
        }
    }
}
