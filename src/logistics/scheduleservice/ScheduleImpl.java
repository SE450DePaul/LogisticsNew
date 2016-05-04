package logistics.scheduleservice;

import java.util.ArrayList;
import java.util.HashMap;
import logistics.facilityservice.FacilityDTO;
import logistics.facilityservice.FacilityService;

/**
 * 
 * @author David Olorundare
 *
 */

public class ScheduleImpl implements Schedule
{
	public int counter = 0;
	private double daysUsed;
	private int floorDaysUsed;
	private int remainingVacancy;
	private int remainder;
	
	private int runDays = 20;
	
	// Approaches to storing the dynamic Day and Available fields
	// using Two ArrayLists OR One HashMap. Actually had considered
	// using a LinkedList too.
	//private ArrayList<Integer> workDays;
	//private ArrayList<Integer> facilityAvailableRate;
	private HashMap<Integer, Integer> dayAvailability = new HashMap<>();
	
	private String facilityName;
	private int facilityRate;
	
	public ScheduleImpl(FacilityDTO facility)
	{
		facilityName = facility.facilityName;
		facilityRate = facility.facilityRate;
		
		// populate schedule with initial available process days
		for (int i = 1; i <= runDays; i++)
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
		for (int i = 1; i <= run; i++)
		{
			//workDays.add(i);
			//facilityAvailableRate.add(facilityRate);
			dayAvailability.put(i, facilityRate);
		}
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

	// process certain number of items and compute the new resulting schedule
	public void computeSchedule(int processItemNum) 
	{
		// calculate stuff
		daysUsed = processItemNum / facilityRate;
		System.out.println("daysUsed: " + daysUsed);
		floorDaysUsed = (int) Math.floor(daysUsed);
		System.out.println("floorDays " + floorDaysUsed);
		remainder = processItemNum % facilityRate;
		System.out.println("remainder: " + remainder);
		remainingVacancy = Math.abs(facilityRate - remainder);
		System.out.println("remVac " + remainingVacancy);
		
		int pinch = counter + floorDaysUsed;
		counter = 0;
		System.out.println("pinch: " + pinch);
		// zeroing fields
		for (int i = 0 ; i < pinch; i++)
		{
			
			dayAvailability.put(i, 0);	
			//don't forget to do bounds checking
			
			counter++;
		}
		
		//update next slot
		dayAvailability.put(counter, remainingVacancy);
		remainingVacancy = facilityRate;
		System.out.println("counter: " +counter);
		System.out.println("counter: " +facilityRate);
	}

	// increase or decrease the number of days the facility
	// should work for
	public Schedule adjustScheduleDays(int lengthOfDays, String adjustType) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	// 

	// displays the schedule of the facility
	public void displaySchedule() 
	{
		System.out.print("Days:\t\t");
		
		for(Integer day: dayAvailability.keySet())
		{
			System.out.print(day + "\t");
	    }
		System.out.print("\nSchedule:\t");
		for(Integer day: dayAvailability.keySet())
		{
			System.out.print(dayAvailability.get(day) + "\t");	
		}
		System.out.println("\n");
	}
	
	
	public static void main(String[] args)
	{
		FacilityService instance = FacilityService.getInstance();
		
		ScheduleImpl schedule = new ScheduleImpl(instance.getFacility("Chicago, IL"));
		//schedule.displaySchedule();
		schedule.computeSchedule(26);
		//schedule.computeSchedule(33);
		schedule.displaySchedule();
		
		
	}
}



	
	
	
	
	

