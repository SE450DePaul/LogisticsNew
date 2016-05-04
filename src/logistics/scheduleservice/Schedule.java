package logistics.scheduleservice;

import logistics.facilityservice.Facility;
import logistics.facilityservice.FacilityDTO;

/**
 * @author David Olorundare
 */
public interface Schedule
{

    // ability to adjust schedule
    // perhaps generate the schedule for the next few days
	public void getFacilityName(Facility facility);
	public void getRunDays();
	public void getAvailableDays();
	

}
