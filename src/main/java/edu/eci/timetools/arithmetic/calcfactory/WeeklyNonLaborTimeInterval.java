package edu.eci.timetools.arithmetic.calcfactory;

import edu.eci.timetools.arithmetic.calcfactory.TimeInterval;
import edu.eci.timetools.arithmetic.InvalidIntervalException;
import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public abstract class WeeklyNonLaborTimeInterval extends TimeInterval {

    public WeeklyNonLaborTimeInterval(int startTimeUnit, int endTimeUnit) {
        super(startTimeUnit, endTimeUnit);
        if (startTimeUnit >= endTimeUnit) {
            throw new InvalidIntervalException("Invalid daily time interval:{" + startTimeUnit + ".." + endTimeUnit + "}. Time unit:" + getTimeUnit());
        }
        if (startTimeUnit > (getUnitsInAWeek() - 1) || endTimeUnit > getUnitsInAWeek()) {
            throw new InvalidIntervalException("Invalid daily time interval:{" + startTimeUnit + ".." + endTimeUnit + "}. Time unit:" + getTimeUnit());
        }
    }

    public abstract int getUnitsInAWeek();

    public abstract TimeUnit getTimeUnit();
}
