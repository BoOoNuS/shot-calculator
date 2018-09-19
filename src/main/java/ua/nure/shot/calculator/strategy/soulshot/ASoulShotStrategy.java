package ua.nure.shot.calculator.strategy.soulshot;

import static ua.nure.shot.calculator.model.Constants.SOUL_ORE_PRICE;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ASoulShotStrategy implements ShotStrategy {

    private static ASoulShotStrategy soulShotStrategy;

    private ASoulShotStrategy() {
    }

    public static ASoulShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (ASoulShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new ASoulShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount * 36);
        outputContext.setCountOfShotsInOut(crystalCount * 300);
        outputContext.setCostInAdena(crystalCount * SOUL_ORE_PRICE * 36);
        return outputContext;
    }
}
