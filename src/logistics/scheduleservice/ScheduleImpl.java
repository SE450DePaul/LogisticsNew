package logistics.scheduleservice;

import java.util.ArrayList;

import logistics.facilityservice.Facility;
import logistics.facilityservice.FacilityDTO;

public class ScheduleImpl implements Schedule
{

	private int runDays = 20;
	private Integer[] availableDays = new Integer[runDays];
	private Integer [] facilityAvailableRate;
	private String facilityName; 
	
    
    private int getFacilityRate(Facility facility)
    {
    	return 0;
    }
  
    // return how many days the facility is working
	public int getRunDays() 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
	// return the number of available days 
	// the facility can still work.
	public int getAvailableDays() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	// process certain number of items and compute the new schedule
	public Schedule computeSchedule(int processItemNum) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	// increase or decrease the number of days the facility
	// should work for
	public Schedule adjustScheduleDays(int lengthOfDays, String adjustType) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	// 
	public Schedule updateSchedule() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	// displays the schedule of the facility
	public String displaySchedule() 
	{
		// TODO Auto-generated method stub
		return null;
	}
}



	
	
	
	
	

