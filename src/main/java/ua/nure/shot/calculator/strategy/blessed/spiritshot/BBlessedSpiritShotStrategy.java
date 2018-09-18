package ua.nure.shot.calculator.strategy.blessed.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class BBlessedSpiritShotStrategy implements ShotStrategy {

    private static BBlessedSpiritShotStrategy soulShotStrategy;

    private BBlessedSpiritShotStrategy() {
    }

    public static BBlessedSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (BBlessedSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new BBlessedSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSoulOre(crystalCount / 2 * 16);
        outputContext.setCountOfShotsInOut(crystalCount / 2 * 100);
        outputContext.setCostInAdena(crystalCount / 2 * SPIRIT_ORE_PRICE);
        return outputContext;
    }
}
