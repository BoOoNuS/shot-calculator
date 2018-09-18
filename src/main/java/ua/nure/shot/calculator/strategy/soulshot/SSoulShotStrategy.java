package ua.nure.shot.calculator.strategy.soulshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

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
        outputContext.setCountOfSoulOre(crystalCount * 40);
        outputContext.setCountOfShotsInOut(crystalCount * 250);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE);
        return outputContext;
    }
}
