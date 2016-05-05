package logistics.scheduleservice;

/**
 * This class represents a Schedule Factory, which handles object creation 
 * of new Schedule Implementation classes.
 * 
 * @author Uchenna F.Okoye
 */

import logistics.facilityservice.FacilityDTO;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

public class ScheduleFactory
{
    public static Schedule build(FacilityDTO facility) throws NullParameterException
    {
        return new ScheduleImpl(facility);
    }

    public static Schedule build(FacilityDTO facility, int runDays) throws NullParameterException, NegativeOrZeroParameterException
    {
        return new ScheduleImpl(facility, runDays);
    }
}
