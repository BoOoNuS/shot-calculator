package ua.nure.shot.calculator.engine;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.model.ShotContext;
import ua.nure.shot.calculator.model.ShotGrade;
import ua.nure.shot.calculator.model.ShotType;
import ua.nure.shot.calculator.strategy.ShotStrategy;
import ua.nure.shot.calculator.strategy.blessed.spiritshot.*;
import ua.nure.shot.calculator.strategy.soulshot.*;
import ua.nure.shot.calculator.strategy.spiritshot.*;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class CalculationEngine {

    private static CalculationEngine calculationEngine;

    private Table<ShotGrade, ShotType, ShotStrategy> gradeTypeStrategyTable = HashBasedTable.create();

    private CalculationEngine() {

        // Soulshots
        gradeTypeStrategyTable.put(ShotGrade.D, ShotType.SOULSHOT, DSoulShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.C, ShotType.SOULSHOT, CSoulShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.B, ShotType.SOULSHOT, BSoulShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.A, ShotType.SOULSHOT, ASoulShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.S, ShotType.SOULSHOT, SSoulShotStrategy.getInstance());

        // Spiritshots
        gradeTypeStrategyTable.put(ShotGrade.D, ShotType.SPIRITSHOT, DSpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.C, ShotType.SPIRITSHOT, CSpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.B, ShotType.SPIRITSHOT, BSpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.A, ShotType.SPIRITSHOT, ASpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.S, ShotType.SPIRITSHOT, SSpiritShotStrategy.getInstance());

        // Blessed spiritshots
        gradeTypeStrategyTable.put(ShotGrade.D, ShotType.BLESSED_SPIRITSHOT, DBlessedSpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.C, ShotType.BLESSED_SPIRITSHOT, CBlessedSpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.B, ShotType.BLESSED_SPIRITSHOT, BBlessedSpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.A, ShotType.BLESSED_SPIRITSHOT, ABlessedSpiritShotStrategy.getInstance());
        gradeTypeStrategyTable.put(ShotGrade.S, ShotType.BLESSED_SPIRITSHOT, SBlessedSpiritShotStrategy.getInstance());
    }

    public static CalculationEngine getInstance() {
        if (calculationEngine == null) {
            synchronized (CalculationEngine.class) {
                if (calculationEngine == null) {
                    calculationEngine = new CalculationEngine();
                }
            }
        }
        return calculationEngine;
    }

    public OutputContext calculate(ShotContext shotContext) {
        ShotStrategy shotStrategy = gradeTypeStrategyTable.get(shotContext.getShotGrade(), shotContext.getShotType());
        OutputContext outputContext = shotStrategy.calculate(shotContext.getCrystalCount());
        outputContext.setInputData(shotContext);
        return outputContext;
    }
}
