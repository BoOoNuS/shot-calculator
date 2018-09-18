package ua.nure.shot.calculator.model;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public enum ShotGrade {

    D, C, B, A, S;

    public static boolean isShotGrade(String val) {
        for (ShotGrade shotGrade : values()) {
            if (shotGrade.name().equalsIgnoreCase(val)) {
                return true;
            }
        }
        return false;
    }
}
