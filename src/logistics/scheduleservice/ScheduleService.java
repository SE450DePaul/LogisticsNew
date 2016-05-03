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

    int numberToProcess = 26;
    int daysUsed;

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

    public void computeRemaingDay()
    {
    	
    }
    
    // should be rename to generate Schedule
    public String getOutput(String facility)
    {
    	return "";
    }
    
    
    public void getSchedule()//Facility facility)
    {
    	//daysUsed = 	(int) Math.abs(numberToProcess - facility.getFacilityRate());
    	
    	System.out.print("Day: \t\t");
    	for (int i = 1; i < 21; i++)
    	{
    		System.out.print(i + "  ");
    		
    	}
    	System.out.print("\nAvailable: \t");
    	for (int j = 1; j < 21; j++)
    	{
    		System.out.print(10 + " ");
    	}
    	
    }

    /*
	// generate SCHEDULE for facility using Schedule Manager API
	System.out.println("\nSchedule: ");
	// generate SCHEDULE day using API
	System.out.println("Day: \t\t1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20");
	// generate SCHEDULE availability using API
	System.out.println("Available: \t10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10 10");
	// facility output ends here
	System.out.print("------------------------------------------------------------------------------");
	*/
    
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
