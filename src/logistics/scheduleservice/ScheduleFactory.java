package logistics.scheduleservice;

import logistics.facilityservice.FacilityDTO;

/**
 * @author uchenna f.okoye
 */
public class ScheduleFactory
{
    public static Schedule build(FacilityDTO facility)
    {
        return new ScheduleImpl(facility);
    }

    public static Schedule build(FacilityDTO facility, int runDays)
    {
        return new ScheduleImpl(facility, runDays);
    }



}
