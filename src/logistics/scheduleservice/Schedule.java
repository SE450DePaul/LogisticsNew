package logistics.scheduleservice;

import logistics.facilityservice.FacilityDTO;

/**
 * @author David Olorundare
 */
public interface Schedule
{

    // ability to adjust schedule
    // perhaps generate the schedule for the next few days
	public void getfacilityRate(FacilityDTO facility);

}
