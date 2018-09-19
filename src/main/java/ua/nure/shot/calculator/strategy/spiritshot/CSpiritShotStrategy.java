package ua.nure.shot.calculator.strategy.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class CSpiritShotStrategy implements ShotStrategy {

    private static CSpiritShotStrategy soulShotStrategy;

    private CSpiritShotStrategy() {
    }

    public static CSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (CSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new CSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount * 10);
        outputContext.setCountOfShotsInOut(crystalCount * 952);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE * 10);
        return outputContext;
    }
}
