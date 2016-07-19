package edu.eci.timetools.arithmetic.calcfactory.hourbased;

import edu.eci.timetools.arithmetic.calcfactory.hourbased.LaborTimeCalculator;
import edu.eci.timetools.arithmetic.calcfactory.hourbased.DailyNonLaborTimeInterval;
import edu.eci.timetools.arithmetic.calcfactory.LaborTimeCalculatorFactory;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public class TimeCalculatorFactory extends LaborTimeCalculatorFactory {

    private static final LaborTimeCalculator calc = new LaborTimeCalculator();

    @Override
    public LaborTimeCalculator getCalculator() {
        return calc;
    }

    @Override
    public DailyNonLaborTimeInterval createDailyTimeInterval(int st, int et) {
        return new DailyNonLaborTimeInterval(st, et);
    }

    @Override
    public WeeklyNonLaborTimeInterval createWeeklyTimeInterval(int st, int et) {
        return new WeeklyNonLaborTimeInterval(st, et);
    }

    @Override
    public WeekLaborCalendar createWeekLaborCalendar() {
        return new WeekLaborCalendar();
    }
}
