package ua.nure.shot.calculator.strategy.soulshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class CSoulShotStrategy implements ShotStrategy {

    private static CSoulShotStrategy soulShotStrategy;

    private CSoulShotStrategy() {
    }

    public static CSoulShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (CSoulShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new CSoulShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSoulOre(crystalCount * 15);
        outputContext.setCountOfShotsInOut(crystalCount * 476);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE);
        return outputContext;
    }
}
