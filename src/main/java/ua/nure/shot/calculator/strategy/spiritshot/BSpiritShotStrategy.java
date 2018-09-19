package ua.nure.shot.calculator.strategy.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class BSpiritShotStrategy implements ShotStrategy {

    private static BSpiritShotStrategy soulShotStrategy;

    private BSpiritShotStrategy() {
    }

    public static BSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (BSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new BSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount * 15);
        outputContext.setCountOfShotsInOut(crystalCount * 150);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE * 15);
        return outputContext;
    }
}
