package logistics.facilityservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * @author David Olorundare and uchenna f.okoye
 */
public class FacilityFactory 
{
    public static Inventory build(String name, Double rate, Double cost) throws IllegalParameterException
    {
        return new FacilityImpl(name, rate, cost);
    }

}
