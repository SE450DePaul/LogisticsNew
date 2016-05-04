package logistics.scheduleservice;

import java.util.ArrayList;

import logistics.facilityservice.Facility;
import logistics.facilityservice.FacilityDTO;
import logistics.itemservice.ItemCatalogService;

/**
 * @author David Olorundare

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
    
    // create a schedule given a facility
    public Schedule createSchedule(Facility facility)
    {
    	return null;
    }
    
    // create a schedule for a specific number of days, given a facility
	public Schedule createSchedule(Facility facility, int runDays)
	{
		return null;
	}
	
	// return a list of all facilities and their schedules
	public ArrayList<Schedule> getSchedules()
	{
		return null;
	}
	
	// given a facility return its schedule
	public Schedule getOutput(Facility facility)
	{
		return null;
	}
    
    
    
    
    

    // Test that the service works
    public static void main(String[] args)
    {
    	ScheduleService scheduleService = ScheduleService.getInstance();
    	
    	//scheduleService.getSchedule();
    	//scheduleService.generateSchedule();
    	
    }
    
}
