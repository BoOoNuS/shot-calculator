package ua.nure.shot.calculator.strategy.blessed.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class SBlessedSpiritShotStrategy implements ShotStrategy {

    private static SBlessedSpiritShotStrategy soulShotStrategy;

    private SBlessedSpiritShotStrategy() {
    }

    public static SBlessedSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (SBlessedSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new SBlessedSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSoulOre(crystalCount / 2 * 50);
        outputContext.setCountOfShotsInOut(crystalCount / 2 * 200);
        outputContext.setCostInAdena(crystalCount / 2 * SPIRIT_ORE_PRICE);
        return outputContext;
    }
}
