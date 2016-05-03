package logistics.facilityservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * @authors David Olorundare and Uchenna F.Okoye
 */
public class FacilityFactory 
{
    public static Facility build(String facilityName, Double facilityRate, Double facilityCost) throws NullParameterException
    {
        return new FacilityImpl(facilityName, facilityRate, facilityCost);
    }
}
