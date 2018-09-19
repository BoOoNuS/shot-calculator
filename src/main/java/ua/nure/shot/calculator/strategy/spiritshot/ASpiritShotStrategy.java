package ua.nure.shot.calculator.strategy.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ASpiritShotStrategy implements ShotStrategy {

    private static ASpiritShotStrategy soulShotStrategy;

    private ASpiritShotStrategy() {
    }

    public static ASpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (ASpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new ASpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount * 22);
        outputContext.setCountOfShotsInOut(crystalCount * 200);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE * 22);
        return outputContext;
    }
}
