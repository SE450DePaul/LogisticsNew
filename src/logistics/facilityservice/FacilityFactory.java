package logistics.facilityservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * @author David Olorundare and Uchenna F.Okoye
 */
public class FacilityFactory 
{
    public static Facility build(String name, Double rate, Double cost) throws IllegalParameterException
    {
        return new FacilityImpl(name, rate, cost);
    } 
}
