package ua.nure.shot.calculator.strategy.soulshot;

import static ua.nure.shot.calculator.model.Constants.SOUL_ORE_PRICE;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

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
        outputContext.setCountOfSpiritOre(crystalCount * 3);
        outputContext.setCountOfShotsInOut(crystalCount * 156);
        outputContext.setCostInAdena(crystalCount * SOUL_ORE_PRICE * 3);
        return outputContext;
    }
}
