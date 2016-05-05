package logistics.scheduleservice;

/**
 * This class represents the Schedule of a given Facility.
 * It uses a Java HashMap to keep track of the workdays a Facility uses to 
 * process a given item. The HashMap's key-value representation is mapped to 
 * Facility work-days and available processing rate for each day. 
 * 
 * Thhe class provides methods to create schedules as well as change existing ones.
 * The HashMap dynamically increases to add more workdays whenever the initial
 * set days are exhausted.
 * 
 * @author David Olorundare
 */

import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

import java.util.HashMap;


public class ScheduleImpl implements Schedule
{
    public int count = 0;
    private int workDaysUsed;
    private int remainingFacilityVacancy;
    private int remainder;
    private int previousFacilityVacancy;

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
    
    public ScheduleImpl(FacilityDTO facility) throws NullParameterException
    {
        if (facility == null)
        	throw new NullParameterException("Facility cannot be null");
    	facilityName = facility.name;
        facilityRate = facility.rate;

        for (int i = 1; i <= workDays; i++)
        {
            dayAvailability.put(i, facilityRate);
        }
    }

    /*
     *  Creates a Schedule with a particular length
     */
    public ScheduleImpl(FacilityDTO facility, int workDays) throws NullParameterException, NegativeOrZeroParameterException
    {
        if (facility == null)
        	throw new NullParameterException("Facility cannot be null");
        if (workDays == 0)
        	throw new NegativeOrZeroParameterException("The number of work-days cannot be zero" );
    	
    	facilityName = facility.name;
        facilityRate = facility.rate;

        for (int i = 1; i <= workDays; i++)
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
    public void computeChangedSchedule(int processItemNum) throws NegativeOrZeroParameterException
    {
        if (processItemNum == 0)
        	throw new NegativeOrZeroParameterException("Number of items to process cannot be zero");
    	if (previousFacilityVacancy > 0)
        {
            processItemNum -= previousFacilityVacancy;
            count++;
            previousFacilityVacancy = 0;
        }

        workDaysUsed = processItemNum / facilityRate;
        remainder = processItemNum % facilityRate;

        remainingFacilityVacancy = Math.abs(facilityRate - remainder);

        int workDaysToCrossOut = count + workDaysUsed;
        count = 0;

        for (int i = 1 ; i < workDaysToCrossOut+1; i++)
        {
            dayAvailability.put(i, 0);
            count++;
        }

        dayAvailability.put(count+1, remainingFacilityVacancy);
        previousFacilityVacancy += remainingFacilityVacancy;
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

		ScheduleImpl schedule;
		try 
		{
			schedule = new ScheduleImpl(instance.getFacility("Chicago, IL"));
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
		catch (NullParameterException e) 
		{
			e.printStackTrace();
		} 
		catch (NegativeOrZeroParameterException e) 
		{
			e.printStackTrace();
		}
		
    }
}









