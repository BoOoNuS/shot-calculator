package ua.nure.shot.calculator.strategy.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class SSpiritShotStrategy implements ShotStrategy {

    private static SSpiritShotStrategy soulShotStrategy;

    private SSpiritShotStrategy() {
    }

    public static SSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (SSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new SSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount * 15);
        outputContext.setCountOfShotsInOut(crystalCount * 200);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE * 15);
        return outputContext;
    }
}
