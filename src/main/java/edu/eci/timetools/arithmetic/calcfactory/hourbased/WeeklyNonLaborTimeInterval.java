package edu.eci.timetools.arithmetic.calcfactory.hourbased;

import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public class WeeklyNonLaborTimeInterval extends edu.eci.timetools.arithmetic.calcfactory.WeeklyNonLaborTimeInterval {

    public WeeklyNonLaborTimeInterval(int startTimeUnit,
            int endTimeUnit) {
        super(startTimeUnit, endTimeUnit);
    }

    @Override
    public int getUnitsInAWeek() {
        return 168;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.HOUR;
    }
}
