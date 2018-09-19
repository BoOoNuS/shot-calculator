package ua.nure.shot.calculator.strategy.blessed.spiritshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class DBlessedSpiritShotStrategy implements ShotStrategy {

    private static DBlessedSpiritShotStrategy soulShotStrategy;

    private DBlessedSpiritShotStrategy() {
    }

    public static DBlessedSpiritShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (DBlessedSpiritShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new DBlessedSpiritShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSpiritOre(crystalCount / 2 * 8);
        outputContext.setCountOfShotsInOut(crystalCount / 2 * 100);
        outputContext.setCostInAdena(crystalCount / 2 * SPIRIT_ORE_PRICE * 8);
        return outputContext;
    }
}
