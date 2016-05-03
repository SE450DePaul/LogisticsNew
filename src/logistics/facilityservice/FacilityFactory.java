package logistics.facilityservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * @authors David Olorundare and Uchenna F.Okoye
 */
public class FacilityFactory 
{
    public static Facility build(String name, Double rate, Double cost) throws NullParameterException
    {
        return new FacilityImpl(name, rate, cost);
    }
}
