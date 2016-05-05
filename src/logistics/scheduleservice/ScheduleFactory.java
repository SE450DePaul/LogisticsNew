package logistics.scheduleservice;

/**
 * This class represents a Schedule Factory, which handles object creation 
 * of new Schedule Implementation classes.
 * 
 * @author Uchenna F.Okoye
 */

import logistics.facilityservice.FacilityDTO;

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
