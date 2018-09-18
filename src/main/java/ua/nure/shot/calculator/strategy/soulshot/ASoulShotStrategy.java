package ua.nure.shot.calculator.strategy.soulshot;

import ua.nure.shot.calculator.model.OutputContext;
import ua.nure.shot.calculator.strategy.ShotStrategy;

import static ua.nure.shot.calculator.model.Constants.SPIRIT_ORE_PRICE;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public class ASoulShotStrategy implements ShotStrategy {

    private static ASoulShotStrategy soulShotStrategy;

    private ASoulShotStrategy() {
    }

    public static ASoulShotStrategy getInstance() {
        if (soulShotStrategy == null) {
            synchronized (ASoulShotStrategy.class) {
                if (soulShotStrategy == null) {
                    soulShotStrategy = new ASoulShotStrategy();
                }
            }
        }
        return soulShotStrategy;
    }

    @Override
    public OutputContext calculate(long crystalCount) {
        OutputContext outputContext = new OutputContext();
        outputContext.setCountOfSoulOre(crystalCount * 36);
        outputContext.setCountOfShotsInOut(crystalCount * 300);
        outputContext.setCostInAdena(crystalCount * SPIRIT_ORE_PRICE);
        return outputContext;
    }
}