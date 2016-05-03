package logistics.scheduleservice;

import logistics.facilityservice.Facility;
import logistics.facilityservice.FacilityDTO;

public class ScheduleImpl implements Schedule
{

	Integer [] facilityAvailableRate = new Integer[20];
    //int numberToProcess = 26;
    int daysRemaining;
	
    
    
    public void computeRemaingDay(Facility facility)
    {
    		
    	// populate schedule with initial facility rate 
    	for (int i = 0; i < facilityAvailableRate.length ; i++)
        {
        	facilityAvailableRate[i] = facility.getFacilityRate();
        }
    }
    
	public void getfacilityRate(FacilityDTO facility) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
}
