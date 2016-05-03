package logistics.scheduleservice;

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

    
    // should be renamed to generate Schedule
    public String getOutput(String facility)
    {
    	return "";
    }
    
    // generate SCHEDULE for facility using Schedule Manager API
    public void getSchedule()//Facility facility)
    {
    	//daysUsed = 	(int) Math.abs(numberToProcess - facility.getFacilityRate());
    	
    	System.out.print("Day: \t\t");
    	for (int i = 1; i < 21; i++)
    	{
    		System.out.print(i + "  ");
    		
    	}
    	System.out.print("\nAvailable: \t");
    	
    	// j should be the remaining number of days available
    	for (int j = 1; j < 21; j++)
    	{
    		System.out.print(10 + " ");
    	}
    	
    }

    // generate SCHEDULE availability using API
    private void generateSchedule()
    {

    }

    // Test that the service works
    public static void main(String[] args)
    {
    	ScheduleService scheduleService = ScheduleService.getInstance();
    	
    	scheduleService.getSchedule();
    	//scheduleService.generateSchedule();
    	
    }
    
}
