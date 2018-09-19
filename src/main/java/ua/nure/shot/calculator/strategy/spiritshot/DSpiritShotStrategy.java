package ua.nure.shot.calculator.strategy.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class DSpiritShotStrategy implements ShotStrategy {

    private static DSpiritShotStrategy soulShotStrategy;

    private DSpiritShotStrategy() {
    }

    public static DSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (DSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new DSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount * 3);
        outputContext.setCountOfShotsInOut(crystalCount * 100);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE * 3);
        return outputContext;
    }
}
