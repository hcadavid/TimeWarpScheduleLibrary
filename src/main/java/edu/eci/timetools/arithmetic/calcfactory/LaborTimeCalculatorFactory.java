package edu.eci.timetools.arithmetic.calcfactory;

import edu.eci.timetools.arithmetic.calcfactory.LaborTimeCalculator;
import edu.eci.timetools.arithmetic.calcfactory.DailyNonLaborTimeInterval;
import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public abstract class LaborTimeCalculatorFactory {

    public static LaborTimeCalculatorFactory getInstance(TimeUnit tu) {
        if (tu == TimeUnit.HOUR) {
            return new edu.eci.timetools.arithmetic.calcfactory.hourbased.TimeCalculatorFactory();
        } else if (tu == TimeUnit.MINUTE) {
            return new edu.eci.timetools.arithmetic.calcfactory.minutebased.TimeCalculatorFactory();
        } else {
            throw new RuntimeException("Time unit not supported yet.");
        }
    }

    public abstract LaborTimeCalculator getCalculator();

    public abstract DailyNonLaborTimeInterval createDailyTimeInterval(int st, int et);

    public abstract WeeklyNonLaborTimeInterval createWeeklyTimeInterval(int st, int et);

    public abstract WeekLaborCalendar createWeekLaborCalendar();
}
