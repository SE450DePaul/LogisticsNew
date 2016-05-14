package logistics.scheduleservice;

/**
 * This class represents a Schedule Manager that keeps track of the schedules
 * of all the Facilities.
 * The class provides methods for creating a Schedule (given a Facility), updating a
 * Facility's Schedule, as well as display the list of all available Facility Schedules.
 *  
 * @author David Olorundare
 *
 */

import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;
import java.util.Set;


public final class ScheduleService
{
    private volatile static ScheduleService instance;
    FacilityService facilityService;

    private ScheduleService()
    {
        facilityService = FacilityService.getInstance();
    }

    /*
     *  Returns a static instance of the Schedule Service
     */
    public static ScheduleService getInstance()
    {
        if (instance == null)
        {
            synchronized (ScheduleService.class)
            {
                if (instance == null)
                {
                    instance = new ScheduleService();
                }
            }
        }
        return instance;
    }

    /*
     *  Returns string output of a Schedule of a given Facility name
     */
    public String getOutput(String facilityName) throws NullParameterException
    {
        if (facilityName == "")
        	throw new NullParameterException("Facility name cannot be empty");
        if (facilityName == null)
        	throw new NullParameterException("Facility name cannot be null");
    	return getSchedule(facilityService.getFacility(facilityName));
    }

    /*
     * Returns a Schedule given a Facility
     */
    public String getSchedule(FacilityDTO facility) throws NullParameterException
    {
    	if (facility == null)
    		throw new NullParameterException("Facility cannot be null");
        Schedule schedule = ScheduleFactory.build(facility);;
        return schedule.getScheduleOutput();
    }

    /*
     *  Creates and returns a Schedule given a FacilityDTO
     */
    public Schedule createSchedule(FacilityDTO facility) throws NullParameterException
    {
        if (facility == null)
        	throw new NullParameterException("Facility cannot be null");
    	return ScheduleFactory.build(facility);
    }

    /*
     *  Creates and returns a Schedule for a specific number of 
     *  work-days, given a facility
     */
    public Schedule createSchedule(FacilityDTO facility, int workDays) throws NullParameterException, NegativeOrZeroParameterException
    {
    	if (facility == null)
    	 throw new NullParameterException("Facility cannot be null");
    	if (workDays == 0)
    		throw new NegativeOrZeroParameterException("Number of work-days cannot be zero");
        return ScheduleFactory.build(facility);
    }

    /*
     *  Returns a list of all Facilities and their Schedules
     */
    public void getFacilitySchedules()
    {
        Set<String> facilities = facilityService.getFacilityNames();
        for (String facility : facilities)
        {
            System.out.println(" " + facility);
            try 
            {
				getOutput(facility);
			} 
            catch (NullParameterException e) 
            {
				e.printStackTrace();
			}
        }
    }

    /*
     *  Updates and returns the Schedule of a Facility 
     *  given a number of items to process
     */
    public Schedule updateSchedule(FacilityDTO facility, int itemNums) throws NullParameterException, NegativeOrZeroParameterException
    {
        if (facility == null)
        	throw new NullParameterException("Facility cannot be null");
        if(itemNums == 0)
        	throw new NegativeOrZeroParameterException("Number of items cannot be zero");
    	
    	Schedule updatedSchedule = ScheduleFactory.build(facility);
        updatedSchedule.bookFacility(itemNums);
        return updatedSchedule;
    }

    // Test that the service works
    public static void main(String[] args)
    {
	    FacilityService instance = FacilityService.getInstance();

		Schedule schedule;
		try 
		{
			schedule = ScheduleFactory.build(instance.getFacility("Chicago, IL"));
			System.out.println("-------------------------Initial Schedule-----------------------------------------------\n");
			System.out.println(schedule.getScheduleOutput());

			System.out.println("--------------------New Schedule when 26 items processed--------------------------------\n");
			schedule.bookFacility(26);
			System.out.println(schedule.getScheduleOutput());
			System.out.println("--------------------New Schedule when another 33 items are processed--------------------\n");
			schedule.bookFacility(33);
			System.out.println(schedule.getScheduleOutput());
			System.out.println("--------------------New Schedule when 7 more items processed----------------------------\n");
			schedule.bookFacility(7);
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
		
        // Get all the current schedules in the facility
        ScheduleService test = new ScheduleService();
        test.getFacilitySchedules();
    }
}
