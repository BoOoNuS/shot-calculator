package ua.nure.shot.calculator.model;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public enum ShotType {

    SOULSHOT, SPIRITSHOT, BLESSED_SPIRITSHOT;

    public static boolean isShotType(String val) {
        for (ShotType shotType : values()) {
            if (shotType.name().equalsIgnoreCase(val)) {
                return true;
            }
        }
        return false;
    }
}
