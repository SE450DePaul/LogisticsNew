package logistics.scheduleservice;

import logistics.utilities.exceptions.NegativeOrZeroParameterException;

/**
 * This is a Schedule Interface which provides common behaviors 
 * every Facility Schedule should be able to perform.
 * 
 * @author David Olorundare
 */
public interface Schedule
{
    public int getTotalFacilityRate();
    public void computeChangedSchedule(int processItemNum) throws NegativeOrZeroParameterException;
    public String getScheduleOutput();
}
