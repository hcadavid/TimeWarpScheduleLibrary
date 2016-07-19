package edu.eci.timetools.arithmetic.calcfactory.hourbased;

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
        return TimeUnit.HOUR;
    }

    @Override
    public int getUnitsInAWeek() {
        return 168;
    }
}
