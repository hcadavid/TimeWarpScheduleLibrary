package edu.eci.timetools.arithmetic.calcfactory.minutebased;

import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public class LaborTimeCalculator extends edu.eci.timetools.arithmetic.calcfactory.LaborTimeCalculator {

    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.MINUTE;
    }

    @Override
    public int getUnitsInAWeek() {
        return 10080;
    }
}
