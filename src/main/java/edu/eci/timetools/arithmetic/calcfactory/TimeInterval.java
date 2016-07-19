package edu.eci.timetools.arithmetic.calcfactory;

/**
 * 
 * @author Hector Fabio Cadavid Rengifo
 * 2013
 * Escuela Colombiana de Ingenieria
 * hector.cadavid@escuelaing.edu.co
 */

public abstract class TimeInterval implements Comparable<TimeInterval> {

    int startTimeUnit;
    int endTimeUnit;

    public TimeInterval(int startTimeUnit, int endTimeUnit) {
        super();
        this.startTimeUnit = startTimeUnit;
        this.endTimeUnit = endTimeUnit;
    }

    public int getStartTimeUnit() {
        return startTimeUnit;
    }

    public int getEndTimeUnit() {
        return endTimeUnit;
    }

    @Override
    public String toString() {
        return "{" + this.getStartTimeUnit() + "," + this.getEndTimeUnit() + "}";
    }

    @Override
    public int compareTo(TimeInterval o) {
        return this.getStartTimeUnit() - o.getStartTimeUnit();
    }

    public boolean isInInterval(int h) {
        return (h >= getStartTimeUnit() && h < getEndTimeUnit());
    }

    public boolean aheadOfInterval(int h) {
        return h >= getEndTimeUnit();
    }

    public int remainingToIntervalStart(int h) {
        return this.getStartTimeUnit() - h;
    }
}
