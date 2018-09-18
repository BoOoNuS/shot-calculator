package ua.nure.shot.calculator;

import ua.nure.shot.calculator.engine.CalculationEngine;
import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.model.ShotContext;
import ua.nure.shot.calculator.model.ShotGrade;
import ua.nure.shot.calculator.model.ShotType;
import ua.nure.shot.calculator.validator.*;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ShotCalculator {

    private static Validator<Integer> argumentsCountValidator = ArgumentCountValidator.getInstance();
    private static Validator<Object> shotGradeValidator = ShotGradeValidator.getInstance();
    private static Validator<Object> shotTypeValidator = ShotTypeValidator.getInstance();
    private static Validator<Object> numberValidator = NumberValidator.getInstance();
    private static Validator<Long> minusCrystalCountValidator = MinusCrystalCountValidator.getInstance();
    private static Validator<Long> blessedSpiritShotCrystalCountValidator =
            BlessedSpiritShotCrystalCountValidator.getInstance();

    private static CalculationEngine calculationEngine = CalculationEngine.getInstance();

    public static void main(String[] args) {
        argumentsCountValidator.validate(args.length);

        String shotGrade = args[0].trim().toUpperCase();
        String shotType = args[1].trim().toUpperCase();

        shotGradeValidator.validate(shotGrade);
        shotTypeValidator.validate(shotType);
        numberValidator.validate(args[2]);

        long countOfCrystals = Long.valueOf(args[2]);
        minusCrystalCountValidator.validate(countOfCrystals);
        countOfCrystals = countOfCrystals / 2 * 2;

        ShotType shotTypeEnum = ShotType.valueOf(shotType);
        if (ShotType.BLESSED_SPIRITSHOT == shotTypeEnum) {
            blessedSpiritShotCrystalCountValidator.validate(countOfCrystals);
        }

        ShotContext shotContext =
                new ShotContext(ShotGrade.valueOf(shotGrade), shotTypeEnum, countOfCrystals);

        OutputContext outputContext = calculationEngine.calculate(shotContext);
        Printer.print(outputContext);
    }

    private static class Printer {

        private static void print(OutputContext outputContext) {
            ShotContext inputData = outputContext.getInputData();

            System.out.println("===========================================================================================================");
            System.out.println("Input data:");
            System.out.println("\tShot grade - " + inputData.getShotGrade());
            System.out.println("\tShot type - " + inputData.getShotType());
            System.out.println("\tCrystal count - " + inputData.getCrystalCount());
            System.out.println("===========================================================================================================");
            System.out.println("Output data:");
            System.out.println("\tCost in adena - " + outputContext.getCostInAdena());
            System.out.println("\tCount of soul ore - " + outputContext.getCountOfSoulOre());
            System.out.println("\tCount of shots as a result - " + outputContext.getCountOfShotsInOut());
            System.out.println("===========================================================================================================");
        }
    }
}
