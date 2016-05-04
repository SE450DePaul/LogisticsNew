package logistics.scheduleservice;

import java.util.ArrayList;

import logistics.facilityservice.Facility;
import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;
import logistics.itemservice.ItemCatalogService;

/**
 * @author David Olorundare
 *
 */

public final class ScheduleService
{
	
    private volatile static ScheduleService instance;



    private ScheduleService() 
    {



    }

    // return static instance of the service
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

    // return string output of a schedule of a given facility name 
    public String getOutput(String facility)
    {
    	return "";
    }
    
    // create a schedule given a facilityDTO
    public Schedule createSchedule(FacilityDTO facility)
    {
    	return new ScheduleImpl(facility);
    }
    
    // create a schedule for a specific number of days, given a facility
	public Schedule createSchedule(FacilityDTO facility, int runDays)
	{
		return new ScheduleImpl(facility, runDays);
	}
	
	// return a list of all facilities and their schedules
	public ArrayList<Schedule> getSchedules()
	{
		return null;
	}
	
	// update the schedule of a facility given a number of items to process
	public Schedule updateSchedule() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	// given a facility return its schedule
	public void getOutput(FacilityDTO facility)
	{
		ScheduleImpl schedule = new ScheduleImpl(facility);
		schedule.displaySchedule();
	}

    // Test that the service works
    public static void main(String[] args)
    {
    	ScheduleService scheduleService = ScheduleService.getInstance();
    	
    	//this should not be here
    	FacilityService instance = FacilityService.getInstance();
		
    	// neither should use of instance.getFacility
    	scheduleService.getOutput(instance.getFacility("Chicago, IL"));
		
    	
    }
}
