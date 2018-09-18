package ua.nure.shot.calculator.strategy;

import ua.nure.shot.calculator.model.OutputContext;

/**
 * Created on 18.09.2018.
 *
 * @author Stanislav Vorozhka
 */
public interface ShotStrategy {

    /**
     * Calculate adena cost and spirit ore count by input count of crystals.
     *
     * @param countOfCrystals the input count of crystals
     * @return the output context with all output info,
     * like adena cost, spirit ore count
     */
    OutputContext calculate(long crystalCount);
}
