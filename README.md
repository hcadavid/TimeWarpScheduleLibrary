
##Scheduled-based TimeWarp Calculator library for Discrete Events simulations.

This library is specially suitable for Processes Simulations where the human 
factor is involved. 

#Sample scenario:

In a simulation of a Workstatio W, at t=0, a man-made manufacturing which takes 
120 hours is going to start. The employee at W works from Monday to 
Friday, from 8:00 am to 12:00 and (after lunch) from 1:00p.m. to 5:00 p.m.

In a Discrete Simulation, a Time Warp would require to know, at what value of 't'
(in our or minutes) will be the manufacturing process finished?


#Example of use

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

        //jornada laboral: viernes de 8 a 12 ?nicamente.
        //104 = Viernes 8:00am
        //273 = Viernes de la siguiente semana, 9:00am
        //441 = Viernes, de la tercera semana, 9:00am

//if the job is assigned at friday, at 8:00am (104'th hour of the week),
//when will the employee finish a 5-hour task?
int timeToJump=cf.getCalculator().moveTimeLaboralHours(c, 104, 5));





Héctor Fabio Cadavid Rengifo
Escuela Colombiana de Ingeniería


hector.cadavid@escuelaing.edu.co