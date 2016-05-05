package logistics.scheduleservice;

import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;

import java.util.HashMap;

/**
 *
 * @author David Olorundare
 *
 */

public class ScheduleImpl implements Schedule
{
    public int globalCounter = 0;
    private int daysUsed;
    private int remainingFacilityVacancy;
    private int remainder;
    private int lastOpRemainder;

    private int runDays = 20;

    // Approaches to storing the dynamic Day and Available fields
    // using a HashMap
    private HashMap<Integer, Integer> dayAvailability = new HashMap<>();

    private String facilityName;

    private String getFacilityName()
    {
        return facilityName;
    }

    private int facilityRate;

    public ScheduleImpl(FacilityDTO facility)
    {
        facilityName = facility.name;
        facilityRate = facility.rate;

        // populate schedule with initial available facility-process days
        for (int i = 1; i <= runDays; i++)
        {
            dayAvailability.put(i, facilityRate);
        }
    }

    // create schedule with a particular length
    public ScheduleImpl(FacilityDTO facility, int run)
    {
        facilityName = facility.name;
        facilityRate = facility.rate;

        // populate schedule with initial available process days
        for (int i = 1; i <= run; i++)
        {
            //workDays.add(i);
            //facilityAvailableRate.add(facilityRate);
            dayAvailability.put(i, facilityRate);
        }
    }

    // return how many days the facility is working
    public int getRunDays()
    {
        return runDays;
    }

    // return the total number of available days
    // the facility can still work.
    public int getTotalAvailableDays()
    {
        int totalDays = 0;
        for(Integer day: dayAvailability.keySet())
        {
            totalDays += dayAvailability.get(day);
        }

        return totalDays;
    }

    // process certain number of items and compute the new resulting schedule
    // schedule dynamically increases if you run out of process days
    public void computeChangedSchedule(int processItemNum)
    {
        // determine if there were any vacancies from the last call of the method
        if (lastOpRemainder > 0)
        {
            processItemNum -= lastOpRemainder;
            globalCounter++;

            //reset Last Operation's Remainder to Zero
            lastOpRemainder = 0;
        }

        // calculate the number of days used-up for processing of the items
        daysUsed = processItemNum / facilityRate;

        // determine the remainder, and use it to evaluate the facility vacancy
        remainder = processItemNum % facilityRate;

        // calculate the remaining vacancy in that facility
        remainingFacilityVacancy = Math.abs(facilityRate - remainder);

        // calculate the number of used-up days on the schedule to cross-out
        int fillToCounter = globalCounter + daysUsed;

        // reset the counter to the first day
        globalCounter = 0;

        // zero-ing of the used-up days
        for (int i = 1 ; i < fillToCounter+1; i++)
        {
            dayAvailability.put(i, 0);
            globalCounter++;
        }

        //update the next available facility vacancy
        dayAvailability.put(globalCounter+1, remainingFacilityVacancy);

        // keep track of the available facility vacancy amount
        // for the next call of the method
        lastOpRemainder += remainingFacilityVacancy;
    }



    // displays the schedule of the facility
    public String getScheduleOutput()
    {
        StringBuffer str = new StringBuffer();
        str.append("Days:\t\t");

        for(Integer day: dayAvailability.keySet())
        {
            str.append(day + "\t" );
        }
        str.append("\nAvailable:\t");
        for(Integer day: dayAvailability.keySet())
        {
            str.append(dayAvailability.get(day) + "\t");
        }
        str.append("\n");

        return str.toString();
    }

    public static void main(String[] args)
    {
		FacilityService instance = FacilityService.getInstance();

		ScheduleImpl schedule = new ScheduleImpl(instance.getFacility("Chicago, IL"));
		System.out.println(schedule.getScheduleOutput());
		schedule.computeChangedSchedule(26);
		System.out.println("-----------------------------------------------------");
		schedule.computeChangedSchedule(33);
		System.out.println("-----------------------------------------------------");
		schedule.computeChangedSchedule(7);
		System.out.println(schedule.getScheduleOutput());
    }
}









