package edu.eci.timetools.arithmetic.calcfactory;

import java.util.List;

import edu.eci.timetools.arithmetic.TimeUnit;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public abstract class LaborTimeCalculator {

    public abstract TimeUnit getTimeUnit();

    public abstract int getUnitsInAWeek();

    /**
     * @param cal
     * @param startHour
     * @return
     */
    public int availableWeekTime(WeekLaborCalendar cal, int starth) {
        int weekBeginHour;

        List<WeeklyNonLaborTimeInterval> nlIntervals = cal.getWeekNonLaboralIntervals();

        if (starth > getUnitsInAWeek()) {
            weekBeginHour = starth % getUnitsInAWeek();
        } else {
            weekBeginHour = starth;
        }

        int nextIntervalIndex = 0;

        if (nlIntervals.size() > 0) {
            boolean lastIntervalPassed = false;

            boolean isTimeInsideInterval = false;
            WeeklyNonLaborTimeInterval insideInterval = null;

            while (!lastIntervalPassed) {
                WeeklyNonLaborTimeInterval wi = nlIntervals.get(nextIntervalIndex);

                if (wi.aheadOfInterval(weekBeginHour)) {
                    nextIntervalIndex++;
                    if (nextIntervalIndex == nlIntervals.size()) {
                        lastIntervalPassed = true;
                    }
                } else if (wi.isInInterval(weekBeginHour)) {
                    nextIntervalIndex++;
                    isTimeInsideInterval = true;
                    insideInterval = wi;
                    if (nextIntervalIndex == nlIntervals.size()) {
                        lastIntervalPassed = true;
                    }
                } else {
                    lastIntervalPassed = true;
                }
            }

            //the given time is inside a non-laborable time interval
            //skip to the end of the interval
            if (isTimeInsideInterval) {
                weekBeginHour = insideInterval.getEndTimeUnit();
            }

            //no more non-laborable intervals ahead
            if (nextIntervalIndex == nlIntervals.size()) {
                //TODO test
                return getUnitsInAWeek() - weekBeginHour;
            } else {

                WeeklyNonLaborTimeInterval nextInterval = nlIntervals.get(nextIntervalIndex);

                int remainingHours = nextInterval.remainingToIntervalStart(weekBeginHour);

                nextIntervalIndex++;

                for (int i = nextIntervalIndex; i < nlIntervals.size(); i++) {
                    remainingHours += nlIntervals.get(i).getStartTimeUnit() - nextInterval.getEndTimeUnit();
                    nextInterval = nlIntervals.get(i);
                }

                remainingHours += getUnitsInAWeek() - nextInterval.getEndTimeUnit();

                return remainingHours;
            }

        } else {
            return getUnitsInAWeek() - weekBeginHour;
        }



    }

    public int moveTimeLaboralHours(WeekLaborCalendar cal, int starth, int deltat) {
        int previousWeeks = starth / getUnitsInAWeek();
        int relativeStartHour = starth % getUnitsInAWeek();

        int availableWt = availableWeekTime(cal, relativeStartHour);

        if (availableWt >= deltat) {
            return previousWeeks * getUnitsInAWeek() + basicMoveTimeLaboralHours(cal, relativeStartHour, deltat);
        } else {
            return ((previousWeeks + 1) * getUnitsInAWeek()) + moveTimeLaboralHours(cal, 0, deltat - availableWt);
        }
    }

    /**
     * @pre availableWeekTime(starth)>=deltat
     * @param cal
     * @param startHour
     * @return
     */
    public int basicMoveTimeLaboralHours(WeekLaborCalendar cal, int starth, int deltat) {
        int weekBeginHour;

        List<WeeklyNonLaborTimeInterval> nlIntervals = cal.getWeekNonLaboralIntervals();

        if (starth > getUnitsInAWeek()) {
            weekBeginHour = starth % getUnitsInAWeek();
        } else {
            weekBeginHour = starth;
        }

        int nextIntervalIndex = 0;

        boolean lastIntervalPassed = false;

        boolean isTimeInsideInterval = false;
        WeeklyNonLaborTimeInterval insideInterval = null;

        while (!lastIntervalPassed) {
            WeeklyNonLaborTimeInterval wi = nlIntervals.get(nextIntervalIndex);

            if (wi.aheadOfInterval(weekBeginHour)) {
                nextIntervalIndex++;
                if (nextIntervalIndex == nlIntervals.size()) {
                    lastIntervalPassed = true;
                }

            } else if (wi.isInInterval(weekBeginHour)) {
                nextIntervalIndex++;
                isTimeInsideInterval = true;
                insideInterval = wi;
                if (nextIntervalIndex == nlIntervals.size()) {
                    lastIntervalPassed = true;
                }

            } else {
                lastIntervalPassed = true;
            }
        }

        //the given time is inside a non-laborable time interval
        //skip to the end of the interval
        if (isTimeInsideInterval) {
            weekBeginHour = insideInterval.getEndTimeUnit();
        }

        //no more non-laborable intervals ahead
        if (nextIntervalIndex == nlIntervals.size()) {
            return weekBeginHour + deltat;
        } else {

            WeeklyNonLaborTimeInterval nextInterval = nlIntervals.get(nextIntervalIndex);


            if (nextInterval.remainingToIntervalStart(weekBeginHour) >= deltat) {
                return weekBeginHour + deltat;
            } else {

                int elapsedTime = nextInterval.remainingToIntervalStart(weekBeginHour);

                int newTime = nextInterval.getEndTimeUnit();

                nextIntervalIndex++;

                while (elapsedTime < deltat) {

                    int nextIntervalTime = nlIntervals.get(nextIntervalIndex).getStartTimeUnit() - nextInterval.getEndTimeUnit();
                    if (elapsedTime + nextIntervalTime >= deltat) {
                        newTime = newTime + (deltat - elapsedTime);
                        elapsedTime = deltat;
                    } else {
                        elapsedTime += nextIntervalTime;
                        newTime = nlIntervals.get(nextIntervalIndex).getEndTimeUnit();
                        nextInterval = nlIntervals.get(nextIntervalIndex);
                        nextIntervalIndex++;
                    }

                }

                return newTime;

            }

        }


    }
}
