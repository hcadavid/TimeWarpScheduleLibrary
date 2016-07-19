package edu.eci.timetools.arithmetic.test;

import org.junit.Assert;

import edu.eci.timetools.arithmetic.TimeUnit;
import edu.eci.timetools.arithmetic.WeekDays;
import edu.eci.timetools.arithmetic.calcfactory.LaborTimeCalculatorFactory;
import edu.eci.timetools.arithmetic.calcfactory.WeekLaborCalendar;

public class HourBasedTimeCalculationTest {

    @org.junit.Test
    public void testTimeSkipNonBasic0() {

        LaborTimeCalculatorFactory cf = LaborTimeCalculatorFactory.getInstance(TimeUnit.HOUR);

        WeekLaborCalendar c = cf.createWeekLaborCalendar();

        c.addDailyNonLaborableInterval(WeekDays.MON, cf.createDailyTimeInterval(0, 8));
        c.addDailyNonLaborableInterval(WeekDays.MON, cf.createDailyTimeInterval(17, 24));
        c.addDailyNonLaborableInterval(WeekDays.TUE, cf.createDailyTimeInterval(0, 8));
        c.addDailyNonLaborableInterval(WeekDays.TUE, cf.createDailyTimeInterval(17, 24));

        Assert.assertEquals(369, cf.getCalculator().moveTimeLaboralHours(c, 336 + 16, 2));
    }

    @org.junit.Test
    public void testTimeSkipNonBasic1() {

        LaborTimeCalculatorFactory cf = LaborTimeCalculatorFactory.getInstance(TimeUnit.HOUR);

        WeekLaborCalendar c = cf.createWeekLaborCalendar();

        c.addDailyNonLaborableInterval(WeekDays.MON, cf.createDailyTimeInterval(0, 24));
        c.addDailyNonLaborableInterval(WeekDays.TUE, cf.createDailyTimeInterval(0, 24));
        c.addDailyNonLaborableInterval(WeekDays.WED, cf.createDailyTimeInterval(0, 24));
        c.addDailyNonLaborableInterval(WeekDays.THU, cf.createDailyTimeInterval(0, 24));
        c.addDailyNonLaborableInterval(WeekDays.FRI, cf.createDailyTimeInterval(0, 8));
        c.addDailyNonLaborableInterval(WeekDays.FRI, cf.createDailyTimeInterval(12, 24));
        c.addDailyNonLaborableInterval(WeekDays.SAT, cf.createDailyTimeInterval(0, 24));
        c.addDailyNonLaborableInterval(WeekDays.SUN, cf.createDailyTimeInterval(0, 24));

        //jornada laboral: viernes de 8 a 12 ?nicamente.
        //104 = Viernes 8:00am
        //273 = Viernes de la siguiente semana, 9:00am
        //441 = Viernes, de la tercera semana, 9:00am


        Assert.assertEquals(273, cf.getCalculator().moveTimeLaboralHours(c, 104, 5));

        Assert.assertEquals(441, cf.getCalculator().moveTimeLaboralHours(c, 104, 9));
    }
}
