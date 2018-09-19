package ua.nure.shot.calculator;

import ua.nure.shot.calculator.engine.CalculationEngine;
import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.model.ShotContext;
import ua.nure.shot.calculator.model.ShotGrade;
import ua.nure.shot.calculator.model.ShotType;
import ua.nure.shot.calculator.validator.BlessedSpiritShotCrystalCountValidator;
import ua.nure.shot.calculator.validator.MinusCrystalCountValidator;
import ua.nure.shot.calculator.validator.Validator;

/**
 * Created on 19.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class CalculationProcessor {

    private static Validator<Long> minusCrystalCountValidator = MinusCrystalCountValidator.getInstance();
    private static Validator<Long> blessedSpiritShotCrystalCountValidator =
        BlessedSpiritShotCrystalCountValidator.getInstance();

    private static CalculationEngine calculationEngine = CalculationEngine.getInstance();

    private static CalculationProcessor calculationProcessor;

    private CalculationProcessor() {
    }

    public static CalculationProcessor getInstance() {
        if (calculationProcessor == null) {
            synchronized (CalculationProcessor.class) {
                if (calculationProcessor == null) {
                    calculationProcessor = new CalculationProcessor();
                }
            }
        }
        return calculationProcessor;
    }

    public OutputContext process(ShotGrade shotGrade, ShotType shotType, long crystalCount) {
        minusCrystalCountValidator.validate(crystalCount);

        if (ShotType.BLESSED_SPIRITSHOT == shotType) {
            crystalCount = crystalCount / 2 * 2;
            blessedSpiritShotCrystalCountValidator.validate(crystalCount);
        }

        ShotContext shotContext = new ShotContext(shotGrade, shotType, crystalCount);

        return calculationEngine.calculate(shotContext);
    }
}
