package logistics.scheduleservice;

/**
 * This class represents the Schedule of a given Facility.
 * It uses a Java HashMap to keep track of the workdays a Facility uses to 
 * process a given item. The HashMap's key-value representation is mapped to 
 * Facility work-days and available processing rate for each day. 
 * 
 * This class provides methods to create schedules as well as change existing ones.
 * The HashMap dynamically increases to add more workdays whenever the initial
 * set days are exhausted.
 * 
 * @author David Olorundare
 */

import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import java.util.HashMap;


public class ScheduleImpl implements Schedule
{
    public int globalCounter = 0;
    private int daysUsed;
    private int remainingFacilityVacancy;
    private int remainder;
    private int lastOpRemainder;

    private int workDays = 20;

    /* 
    * Stores schedule work-days and available process-rate.
    */ 
    private HashMap<Integer, Integer> dayAvailability = new HashMap<>();

    private String facilityName;

    /*
     * Returns the name of the Facility associated with a Schedule
     */
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
        for (int i = 1; i <= workDays; i++)
        {
            dayAvailability.put(i, facilityRate);
        }
    }

    /*
     *  Creates a Schedule with a particular length
     */
    public ScheduleImpl(FacilityDTO facility, int processDays)
    {
        facilityName = facility.name;
        facilityRate = facility.rate;

        // populate schedule with initial available process days
        for (int i = 1; i <= processDays; i++)
        {
            dayAvailability.put(i, facilityRate);
        }
    }

    /*
     *  Returns how many days the facility is working
     */
    public int getWorkDays()
    {
        return workDays;
    }

    /*
     *  Returns the total process-rate for the available 
     *  number of days the facility can currently work for.
     */
    public int getTotalFacilityRate()
    {
        int totalRate = 0;
        for(Integer day: dayAvailability.keySet())
        {
            totalRate += dayAvailability.get(day);
        }

        return totalRate;
    }

    /*
     *  Process a certain number of items and compute the new resulting schedule.
     */
    public void computeChangedSchedule(int processItemNum)
    {
        // determine if there were any vacancies from the last call of this method
        if (lastOpRemainder > 0)
        {
            processItemNum -= lastOpRemainder;
            globalCounter++;

            //reset Last Operation's Remainder to Zero
            lastOpRemainder = 0;
        }

        // calculate the number of days used-up for processing of the items
        daysUsed = processItemNum / facilityRate;

        // determine the remainder, and use it to evaluate the facility processing vacancy
        remainder = processItemNum % facilityRate;

        // calculate the remaining processing-vacancy in that facility
        remainingFacilityVacancy = Math.abs(facilityRate - remainder);

        // calculate the number of used-up days on the schedule that should be crossed-out
        int fillToCounter = globalCounter + daysUsed;

        // reset the counter to the first day
        globalCounter = 0;

        // cross-out the used-up days
        for (int i = 1 ; i < fillToCounter+1; i++)
        {
            dayAvailability.put(i, 0);
            globalCounter++;
        }

        //update the next available facility vacancy
        dayAvailability.put(globalCounter+1, remainingFacilityVacancy);

        // keep track of the available facility vacancy amount
        // for the next call of this method
        lastOpRemainder += remainingFacilityVacancy;
    }

    /*
     *  Returns the schedule of the associated facility
     */
    public String getScheduleOutput()
    {
        StringBuffer str = new StringBuffer();
        str.append("\n");
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

    // Test that this class works
    public static void main(String[] args)
    {
		FacilityService instance = FacilityService.getInstance();

		ScheduleImpl schedule = new ScheduleImpl(instance.getFacility("Chicago, IL"));
		System.out.println("-----------Initial Schedule for Chicago, IL Facility ------------------------------------------");
		System.out.println(schedule.getScheduleOutput());
		schedule.computeChangedSchedule(26);
		System.out.println("-----------New Schedule After Processing 26 Items ------------------------------------------");
		System.out.println(schedule.getScheduleOutput());
		System.out.println("-----------New Schedule After Processing another 33 Items------------------------------------------");
		schedule.computeChangedSchedule(33);
		System.out.println(schedule.getScheduleOutput());
		System.out.println("-----------------New Schedule After Processing 7 more Items------------------------------------");
		schedule.computeChangedSchedule(7);
		System.out.println(schedule.getScheduleOutput());
    }
}









