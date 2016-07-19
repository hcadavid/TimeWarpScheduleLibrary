
##Scheduled-based TimeWarp Calculator library for Discrete Event Simulations.

This library is specially suitable for Processes Simulations where the human 
factor is involved. 

#Sample scenario:

For a simulation, at time=0, an employee is going to perform a task which requires 
120 hours. This employee works from Monday to Friday, from 8:00 am to 12:00 and 
(after lunch) from 1:00p.m. to 5:00 p.m.

In a Discrete Simulation, for a Time Warp, it would be required to calculate, 
at what value of 'time' (in hours or minutes) will be the employee's task
finished?


#Example of use

```java
//Use hours as time unit
LaborTimeCalculatorFactory cf = LaborTimeCalculatorFactory.getInstance(TimeUnit.HOUR);

//Set weekly schedule (by default, all the week is laborable). 
//In this case, the employee works 4 hours only 
//at friday (8am - 12pm).
c.addDailyNonLaborableInterval(WeekDays.MON, cf.createDailyTimeInterval(0, 24));
c.addDailyNonLaborableInterval(WeekDays.TUE, cf.createDailyTimeInterval(0, 24));
c.addDailyNonLaborableInterval(WeekDays.WED, cf.createDailyTimeInterval(0, 24));
c.addDailyNonLaborableInterval(WeekDays.THU, cf.createDailyTimeInterval(0, 24));
c.addDailyNonLaborableInterval(WeekDays.FRI, cf.createDailyTimeInterval(0, 8));
c.addDailyNonLaborableInterval(WeekDays.FRI, cf.createDailyTimeInterval(12, 24));
c.addDailyNonLaborableInterval(WeekDays.SAT, cf.createDailyTimeInterval(0, 24));
c.addDailyNonLaborableInterval(WeekDays.SUN, cf.createDailyTimeInterval(0, 24));

//if the job is assigned at friday, at 8:00am (104'th hour of the week),
//when will the employee finish a 5-hour task?
int timeToJump=cf.getCalculator().moveTimeLaboralHours(c, 104, 5));
```




Héctor Fabio Cadavid Rengifo - 2013
Escuela Colombiana de Ingeniería


hector.cadavid@escuelaing.edu.co
