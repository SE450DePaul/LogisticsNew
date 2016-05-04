package logistics.scheduleservice;

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
	public int globalCounter = 0;
	private int daysUsed;
	private int remainingVacancy;
	private int remainder;
	private int lastOpRemainder;
	
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
		
		// populate schedule with initial available facility-process days
		for (int i = 1; i <= runDays; i++)
		{
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
	// schedule dynamically increases if you run out of process days
	public void computeChangedSchedule(int processItemNum) 
	{
		System.out.println("processIteNum BEFORE the subtraction: " + processItemNum + " items\n");
		
		System.out.println("Last Operation Facility Vacancy (BEFORE the subtraction): " + lastOpRemainder + "\n");
		
		// determine if there were any vacancies from the last call of the method
		if (lastOpRemainder > 0)
		{
			processItemNum -= lastOpRemainder;
			globalCounter++;
			
			//reset Last Operation's Remainder to Zero
			lastOpRemainder = 0;
		}
		System.out.println("Last Operation Facility Vacancy (AFTER the subtraction): " + lastOpRemainder + "\n");
		System.out.println("processItemNum AFTER the subtraction: " + processItemNum + " items\n");
		
		// calculate the number of days used-up for processing of the items
		daysUsed = processItemNum / facilityRate;
		System.out.println("(daysUsed = processItemNum / facilityRate)  Number of Days Used Up: " + daysUsed + " days\n");
		
		// determine the remainder, and use it to evaluate the facility vacancy
		remainder = processItemNum % facilityRate;
		System.out.println("(remainder = processItemNum % facilityRate): " + remainder);
		
		// calculate the remaining vacancy in that facility
		remainingVacancy = Math.abs(facilityRate - remainder);
		System.out.println("Remaing Facility Vacancy slot: " + remainingVacancy);
		
		// calculate the number of used-up days on the schedule to cross-out
		int fillToCounter = globalCounter + daysUsed;
		
		// reset the counter to the first day
		globalCounter = 0;
		System.out.println("Amount to zero-out: " + fillToCounter);
		
		// zero-ing of the used-up days
		for (int i = 1 ; i < fillToCounter+1; i++)
		{
			dayAvailability.put(i, 0);	
			
			//don't forget to do bounds checking code
			// ????
			
			globalCounter++;
		}
		
		//update the next available facility vacancy
		dayAvailability.put(globalCounter+1, remainingVacancy);
		
		// keep track of the available facility vacancy amount
		// for the next call of the method
		lastOpRemainder += remainingVacancy;
		
		System.out.println("\nRemainder of Last Operation " + lastOpRemainder );
		System.out.println("counter: " +globalCounter + "\n");	
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
		schedule.computeChangedSchedule(215);
		System.out.println("-----------------------------------------------------");
		//schedule.computeSchedule(33);
		System.out.println("-----------------------------------------------------");
		//schedule.computeSchedule(7);
		schedule.displaySchedule();
		
		
	}
}



	
	
	
	
	

