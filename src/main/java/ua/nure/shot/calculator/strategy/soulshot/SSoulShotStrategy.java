package ua.nure.shot.calculator.strategy.soulshot;

import static ua.nure.shot.calculator.model.Constants.SOUL_ORE_PRICE;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class SSoulShotStrategy implements ShotStrategy {

    private static SSoulShotStrategy soulShotStrategy;

    private SSoulShotStrategy() {
    }

    public static SSoulShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (SSoulShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new SSoulShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount * 40);
        outputContext.setCountOfShotsInOut(crystalCount * 350);
        outputContext.setCostInAdena(crystalCount * SOUL_ORE_PRICE * 40);
        return outputContext;
    }
}
