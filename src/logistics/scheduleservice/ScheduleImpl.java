package logistics.scheduleservice;

import java.util.ArrayList;
import java.util.HashMap;

import logistics.facilityservice.Facility;
import logistics.facilityservice.FacilityDTO;

public class ScheduleImpl implements Schedule
{
	
	//private int Day;
	//private int AvailableNum;
	private int runDays = 20;
	
	// approaches to storing the dynamic Day and Available fields
	// using Two ArrayLists OR One HashMap 
	private ArrayList<Integer> workDays;
	private ArrayList<Integer> facilityAvailableRate;
	private HashMap<Integer, Integer> dayAvailability = new HashMap<>();
	
	private String facilityName;
	private int facilityRate;
	
	public ScheduleImpl(FacilityDTO facility)
	{
		facilityName = facility.facilityName;
		facilityRate = facility.facilityRate;
		
		// populate schedule with initial available process days
		for (int i = 1; i <= runDays+1; i++)
		{
			//workDays.add(i);
			//facilityAvailableRate.add(facilityRate);
			dayAvailability.put(i, facilityRate);
		}
	}
	
	// create schedule with a particular length
	public ScheduleImpl(FacilityDTO facility, int run)
	{
		facilityName = facility.facilityName;
		facilityRate = facility.facilityRate;
		
		// populate schedule with initial available process days
		for (int i = 1; i <= run+1; i++)
		{
			//workDays.add(i);
			//facilityAvailableRate.add(facilityRate);
			dayAvailability.put(i, facilityRate);
		}
	}
	
    // returns the facilty's rate
    private int getFacilityRate()
    {
    	return facilityRate;
    }
  
    // return how many days the facility is working
	public int getRunDays() 
	{
		return runDays;
	}
	
	/*
	 * change the runDays of the schedule
	public void setRunDays(int run)
	{
		runDays = run;
	}
	*/
	
	// return the number of available days, for 
	// a given day, that the facility can still work.
	public int getAvailableDays(int day) 
	{
		return dayAvailability.get(day);
	}
	
	// return the total number of available days 
	// the facility can still work.
	public int getAvailableDays() 
	{
		int totalDays = 0;
		for(Integer day: dayAvailability.keySet())
		{
            totalDays += dayAvailability.get(day);
		}
		
		return totalDays;
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



	
	
	
	
	

