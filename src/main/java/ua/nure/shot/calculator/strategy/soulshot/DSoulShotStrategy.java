package ua.nure.shot.calculator.strategy.soulshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class DSoulShotStrategy implements ShotStrategy {

    private static DSoulShotStrategy soulShotStrategy;

    private DSoulShotStrategy() {
    }

    public static DSoulShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (DSoulShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new DSoulShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSoulOre(crystalCount * 3);
        outputContext.setCountOfShotsInOut(crystalCount * 156);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE);
        return outputContext;
    }
}
