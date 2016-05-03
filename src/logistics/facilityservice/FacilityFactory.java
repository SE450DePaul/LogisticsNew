package logistics.facilityservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * @author David Olorundare and uchenna f.okoye
 */
public class FacilityFactory 
{
    public static Facility build(String name, Double rate, Double cost) throws NullParameterException
    {
        return new FacilityImpl(name, rate, cost);
    }
}
