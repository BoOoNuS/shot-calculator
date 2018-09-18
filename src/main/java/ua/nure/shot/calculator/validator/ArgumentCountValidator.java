package ua.nure.shot.calculator.validator;

import ua.nure.shot.calculator.exception.FewArgumentsException;

import static ua.nure.shot.calculator.model.Constants.Messages.TOO_FEW_ARGUMENTS_EXCEPTION_MSG;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ArgumentCountValidator implements Validator<Integer> {

    private static Validator<Integer> validator;

    private ArgumentCountValidator() {
    }

    public static Validator<Integer> getInstance() {
        if (validator == null) {
            synchronized (ArgumentCountValidator.class) {
                if (validator == null) {
                    validator = new ArgumentCountValidator();
                }
            }
        }
        return validator;
    }

    @Override
    public void validate(Integer argCount) {
        if (argCount < 3) {
            throw new FewArgumentsException(TOO_FEW_ARGUMENTS_EXCEPTION_MSG);
        }
    }
}
