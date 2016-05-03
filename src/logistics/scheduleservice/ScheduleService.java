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

    private void generateSchedule()
    {

    }

    // Test that the service works
    public static void main(String[] args)
    {
    	
    }
    
}
