package edu.eci.timetools.arithmetic.test;

import org.junit.Assert;


import edu.eci.timetools.arithmetic.TimeUnit;
import edu.eci.timetools.arithmetic.WeekDays;
import edu.eci.timetools.arithmetic.calcfactory.LaborTimeCalculatorFactory;
import edu.eci.timetools.arithmetic.calcfactory.WeekLaborCalendar;

public class MinuteBasedTimeCalcualtionTest {

    @org.junit.Test
    public void testTimeSkipNonBasic0() {

        LaborTimeCalculatorFactory cf = LaborTimeCalculatorFactory.getInstance(TimeUnit.MINUTE);

        WeekLaborCalendar c = cf.createWeekLaborCalendar();

        c.addDailyNonLaborableInterval(WeekDays.MON, cf.createDailyTimeInterval(0, 8 * 60));
        c.addDailyNonLaborableInterval(WeekDays.MON, cf.createDailyTimeInterval(17 * 60, 24 * 60));
        c.addDailyNonLaborableInterval(WeekDays.TUE, cf.createDailyTimeInterval(0, 8 * 60));
        c.addDailyNonLaborableInterval(WeekDays.TUE, cf.createDailyTimeInterval(17 * 60, 24 * 60));

        Assert.assertEquals(369 * 60, cf.getCalculator().moveTimeLaboralHours(c, (336 + 16) * 60, 2 * 60));
    }

    @org.junit.Test
    public void testTimeSkipNonBasic1() {

        LaborTimeCalculatorFactory cf = LaborTimeCalculatorFactory.getInstance(TimeUnit.MINUTE);

        WeekLaborCalendar c = cf.createWeekLaborCalendar();

        c.addDailyNonLaborableInterval(WeekDays.MON, cf.createDailyTimeInterval(0, 24 * 60));
        c.addDailyNonLaborableInterval(WeekDays.TUE, cf.createDailyTimeInterval(0, 24 * 60));
        c.addDailyNonLaborableInterval(WeekDays.WED, cf.createDailyTimeInterval(0, 24 * 60));
        c.addDailyNonLaborableInterval(WeekDays.THU, cf.createDailyTimeInterval(0, 24 * 60));
        c.addDailyNonLaborableInterval(WeekDays.FRI, cf.createDailyTimeInterval(0, 8 * 60));
        c.addDailyNonLaborableInterval(WeekDays.FRI, cf.createDailyTimeInterval(12 * 60, 24 * 60));
        c.addDailyNonLaborableInterval(WeekDays.SAT, cf.createDailyTimeInterval(0, 24 * 60));
        c.addDailyNonLaborableInterval(WeekDays.SUN, cf.createDailyTimeInterval(0, 24 * 60));

        //jornada laboral: viernes de 8 a 12 ?nicamente.
        //104 = Viernes 8:00am
        //273 = Viernes de la siguiente semana, 9:00am
        //441 = Viernes, de la tercera semana, 9:00am

        //cinco horas y dos minutos
        Assert.assertEquals((273 * 60) + 2, cf.getCalculator().moveTimeLaboralHours(c, 104 * 60, (5 * 60) + 2));


        //cuatro horas y dos minutos (los dos minutos seran en la siguiente semana).
        Assert.assertEquals((272 * 60) + 2, cf.getCalculator().moveTimeLaboralHours(c, 104 * 60, (4 * 60) + 2));



        Assert.assertEquals(441 * 60, cf.getCalculator().moveTimeLaboralHours(c, 104 * 60, 9 * 60));
    }
}
