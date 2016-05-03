package logistics.scheduleservice;

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

    public void getSchedule()
    {

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
    	
    }
    
}
