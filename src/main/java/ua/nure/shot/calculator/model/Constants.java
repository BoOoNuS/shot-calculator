package ua.nure.shot.calculator.model;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public final class Constants {

    private Constants() {
        throw new UnsupportedOperationException("You can not create util class");
    }

    public static final int SPIRIT_ORE_PRICE = 250;

    public static final class Messages {

        private Messages() {
            throw new UnsupportedOperationException("You can not create util class");
        }

        public static final String TOO_FEW_ARGUMENTS_EXCEPTION_MSG =
                "Too few arguments, should be at least 3: ShotGrade (D, C, B, A, S), " +
                        "ShotType (soulshot, spiritshot, blessed_spiritshot), CrystalCount (number)";

        public static final String ILLEGAL_SHOT_GRADE_EXCEPTION_MESSAGE =
                "Illegal ShotGrade, should be one of (D, C, B, A, S)";

        public static final String ILLEGAL_SHOT_TYPE_EXCEPTION_MESSAGE =
                "Illegal ShotType, should be one of (soulshot, spiritshot, blessed_spiritshot)";

        public static final String INCORRECT_INPUT_NUMBER_EXCEPTION_MESSAGE =
                "Incorrect input crystal count, should be numeric";

        public static final String TO_CREATE_BLESSED_SPIRIT_SHOT_EXCEPTION_MESSAGE =
                "To create blessed spirit shot, you need at lest 2 crystals";

        public static final String CRYSTAL_COUNT_CAN_NOT_BE_MINUS_VALUE_EXCEPTION_MESSAGE =
                "Crystal count can not be minus value";
    }
}
