package logistics.scheduleservice;

/**
 * @author David Olorundare
 */
public interface Schedule
{
    public int getTotalAvailableDays();
    public void computeChangedSchedule(int processItemNum);
    public String displaySchedule();
}
