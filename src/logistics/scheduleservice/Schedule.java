package logistics.scheduleservice;

import java.util.ArrayList;

import logistics.facilityservice.Facility;

/**
 * @author David Olorundare
 */
public interface Schedule
{

    // ability to adjust schedule
    // perhaps generate the schedule for the next few days
	
	//public String getFacilityName(Facility facility);
	//public Integer getFacilityRate(Facility facility)
	public int getRunDays();
	public int getAvailableDays();
	public void computeChangedSchedule(int processItemNum);
	public void displaySchedule();
	

}
