package edu.eci.timetools.arithmetic.calcfactory.minutebased;

import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public class WeekLaborCalendar extends edu.eci.timetools.arithmetic.calcfactory.WeekLaborCalendar {

    @Override
    public int getUnitsInADay() {
        return 1440;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.MINUTE;
    }
}
