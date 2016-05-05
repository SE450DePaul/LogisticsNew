package logistics.facilityservice;

/**
 * This class represents a Facility Factory, which handles object creation 
 * of new Facility Implementation classes.
 * 
 * @author David Olorundare and Uchenna F.okoye
 */

import logistics.utilities.exceptions.NullParameterException;

public class FacilityFactory 
{
    public static Facility build(String name, Integer rate, Double cost) throws NullParameterException
    {
        return new FacilityImpl(name, rate, cost);
    }
}
