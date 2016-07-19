package edu.eci.timetools.arithmetic.calcfactory;

import edu.eci.timetools.arithmetic.InvalidIntervalException;
import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public abstract class DailyNonLaborTimeInterval extends TimeInterval {

    public DailyNonLaborTimeInterval(int startTimeUnit, int endTimeUnit) {
        super(startTimeUnit, endTimeUnit);
        if (startTimeUnit >= endTimeUnit) {
            throw new InvalidIntervalException("Invalid daily time interval:{" + startTimeUnit + ".." + endTimeUnit + "}. Time unit:" + getTimeUnit());
        }
        if (startTimeUnit > (getUnitsInADay() - 1) || getUnitsInADay() > getUnitsInADay()) {
            throw new InvalidIntervalException("Invalid daily time interval:{" + startTimeUnit + ".." + endTimeUnit + "}. Time unit:" + getTimeUnit());
        }

    }

    public abstract int getUnitsInADay();

    public abstract TimeUnit getTimeUnit();
}
