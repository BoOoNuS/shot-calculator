package ua.nure.shot.calculator.strategy.blessed.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ABlessedSpiritShotStrategy implements ShotStrategy {

    private static ABlessedSpiritShotStrategy soulShotStrategy;

    private ABlessedSpiritShotStrategy() {
    }

    public static ABlessedSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (ABlessedSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new ABlessedSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount / 2 * 70);
        outputContext.setCountOfShotsInOut(crystalCount / 2 * 200);
        outputContext.setCostInAdena(crystalCount / 2 * SPIRIT_ORE_PRICE * 70);
        return outputContext;
    }
}
