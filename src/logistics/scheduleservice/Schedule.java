package logistics.scheduleservice;

/**
 * This is a Schedule Interface which provides common behaviors 
 * every Facility Schedule should be able to perform.
 * 
 * @author David Olorundare
 */
public interface Schedule
{
    public int getTotalFacilityRate();
    public void computeChangedSchedule(int processItemNum);
    public String getScheduleOutput();
}
