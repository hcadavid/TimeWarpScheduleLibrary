package edu.eci.timetools.arithmetic.calcfactory.hourbased;

import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public class DailyNonLaborTimeInterval extends edu.eci.timetools.arithmetic.calcfactory.DailyNonLaborTimeInterval {

    public DailyNonLaborTimeInterval(int startTimeUnit, int endTimeUnit) {
        super(startTimeUnit, endTimeUnit);
        // TODO Auto-generated constructor stub
    }

    @Override
    public int getUnitsInADay() {
        return 24;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.HOUR;
    }
}
