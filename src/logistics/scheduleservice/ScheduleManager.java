package logistics.scheduleservice;

/**
 * @author David Olorundare

 */

public final class ScheduleManager
{

    private volatile static ScheduleManager instance;



    private ScheduleManager() 
    {



    }


    
    public static ScheduleManager getInstance() {
        if (instance == null)
        {
            synchronized (ScheduleManager.class)
            {
                if (instance == null)
                {
                    instance = new ScheduleManager();
                }
            }
        }
        return instance;
    }

    public void getSchedule(){

    }

    private void generateSchedule(){

    }


}
