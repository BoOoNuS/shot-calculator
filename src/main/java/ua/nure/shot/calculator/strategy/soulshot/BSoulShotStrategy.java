package ua.nure.shot.calculator.strategy.soulshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class BSoulShotStrategy implements ShotStrategy {

    private static BSoulShotStrategy soulShotStrategy;

    private BSoulShotStrategy() {
    }

    public static BSoulShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (BSoulShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new BSoulShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSoulOre(crystalCount * 54);
        outputContext.setCountOfShotsInOut(crystalCount * 450);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE);
        return outputContext;
    }
}
