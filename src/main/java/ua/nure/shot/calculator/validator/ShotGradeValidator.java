package ua.nure.shot.calculator.validator;

import ua.nure.shot.calculator.exception.ValidationException;
import ua.nure.shot.calculator.model.ShotGrade;

import static ua.nure.shot.calculator.model.Constants.Messages.ILLEGAL_SHOT_GRADE_EXCEPTION_MESSAGE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ShotGradeValidator implements Validator<Object> {

    private static Validator<Object> validator;

    private ShotGradeValidator() {
    }

    public static Validator<Object> getInstance() {
        if (validator == null) {
            synchronized (ShotGradeValidator.class) {
                if (validator == null) {
                    validator = new ShotGradeValidator();
                }
            }
        }
        return validator;
    }

    @Override
    public void validate(Object shotGrade) {
        if (!ShotGrade.isShotGrade(shotGrade.toString())) {
            throw new ValidationException(ILLEGAL_SHOT_GRADE_EXCEPTION_MESSAGE);
        }
    }
}
