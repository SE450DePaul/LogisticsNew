package logistics.scheduleservice;

import java.util.ArrayList;
import java.util.Set;

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
    FacilityService facilityService;

    private ScheduleService() 
    {
    	facilityService = FacilityService.getInstance();


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
    public void getOutput(String facilityName)
    {
    	getSchedule(facilityService.getFacility(facilityName));
    }
    
	// given a facility return its schedule
	public void getSchedule(FacilityDTO facility)
	{
		ScheduleImpl schedule = new ScheduleImpl(facility);
		schedule.displaySchedule();
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
	public void getFacilitySchedules()
	{
		Set<String> facilities = facilityService.getFacilities();
		for (String facility : facilities)
		{
			System.out.println(" " + facility);
			getOutput(facility);
		}
	}
	
	// update the schedule of a facility given a number of items to process
	public Schedule updateSchedule(FacilityDTO facility, int itemNums) 
	{
		ScheduleImpl updatedSchedule = new ScheduleImpl(facility);
		updatedSchedule.computeChangedSchedule(itemNums);
		return updatedSchedule;
	}
	

    // Test that the service works
    public static void main(String[] args)
    {
/*
		FacilityService instance = FacilityService.getInstance();
		
		ScheduleImpl schedule = new ScheduleImpl(instance.getFacility("Chicago, IL"));
		System.out.println("-------------------------Initial Schedule-----------------------------------------------\n");
		schedule.displaySchedule();
		System.out.println("--------------------New Schedule when 26 items processed--------------------------------\n");
		schedule.computeChangedSchedule(26);
		schedule.displaySchedule();
		System.out.println("--------------------New Schedule when another 33 items are processed--------------------\n");
		schedule.computeChangedSchedule(33);
		schedule.displaySchedule();
		System.out.println("--------------------New Schedule when 7 more items processed----------------------------\n");
		schedule.computeChangedSchedule(7);
		schedule.displaySchedule();	*/
    	
    	// Get all the current schedules in the facility
    	ScheduleService test = new ScheduleService();
    	test.getFacilitySchedules();
    	
    }
}
