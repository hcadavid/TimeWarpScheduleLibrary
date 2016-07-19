package edu.eci.timetools.arithmetic.calcfactory;

import edu.eci.timetools.arithmetic.calcfactory.LaborTimeCalculatorFactory;
import edu.eci.timetools.arithmetic.calcfactory.DailyNonLaborTimeInterval;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import edu.eci.timetools.arithmetic.TimeUnit;
import edu.eci.timetools.arithmetic.WeekDays;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public abstract class WeekLaborCalendar {

    private Map<Integer, Set<DailyNonLaborTimeInterval>> nwd = new LinkedHashMap<>();
    private static Map<WeekDays, Integer> weekDayNumbers = new LinkedHashMap<>();

    static {
        weekDayNumbers.put(WeekDays.MON, 1);
        weekDayNumbers.put(WeekDays.TUE, 2);
        weekDayNumbers.put(WeekDays.WED, 3);
        weekDayNumbers.put(WeekDays.THU, 4);
        weekDayNumbers.put(WeekDays.FRI, 5);
        weekDayNumbers.put(WeekDays.SAT, 6);
        weekDayNumbers.put(WeekDays.SUN, 7);

    }

    public WeekLaborCalendar() {
        for (int i = 1; i <= 7; i++) {
            nwd.put(i, new TreeSet<DailyNonLaborTimeInterval>());
        }
    }

    public void addDailyNonLaborableInterval(WeekDays day, DailyNonLaborTimeInterval interval) {
        nwd.get(weekDayNumbers.get(day)).add(interval);
    }

    public List<WeeklyNonLaborTimeInterval> getWeekNonLaboralIntervals() {
        LinkedList<WeeklyNonLaborTimeInterval> out = new LinkedList<WeeklyNonLaborTimeInterval>();

        LaborTimeCalculatorFactory cf = LaborTimeCalculatorFactory.getInstance(getTimeUnit());

        for (int i = 1; i <= 7; i++) {
            Set<DailyNonLaborTimeInterval> dnlts = nwd.get(i);
            for (DailyNonLaborTimeInterval dnlt : dnlts) {
                out.add(cf.createWeeklyTimeInterval(((i - 1) * getUnitsInADay()) + dnlt.getStartTimeUnit(), ((i - 1) * getUnitsInADay()) + dnlt.getEndTimeUnit()));
            }
        }

        return out;

    }

    public abstract int getUnitsInADay();

    public abstract TimeUnit getTimeUnit();
}
