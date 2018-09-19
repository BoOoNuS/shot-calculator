package ua.nure.shot.calculator.strategy.blessed.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class CBlessedSpiritShotStrategy implements ShotStrategy {

    private static CBlessedSpiritShotStrategy soulShotStrategy;

    private CBlessedSpiritShotStrategy() {
    }

    public static CBlessedSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (CBlessedSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new CBlessedSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount / 2 * 30);
        outputContext.setCountOfShotsInOut(crystalCount / 2 * 200);
        outputContext.setCostInAdena(crystalCount / 2 * SPIRIT_ORE_PRICE * 30);
        return outputContext;
    }
}
