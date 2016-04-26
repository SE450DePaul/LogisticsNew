package logistics.facilityservice;

import logistics.facilityservice.inventory.Inventory;
import logistics.utilities.exceptions.IllegalParameterException;

import java.util.ArrayList;

/**
 * @author David Olorundare
 */
public class FacilityFactory 
{

    public static Facility build(String name, Double rate, Double cost, ArrayList<Inventory> inventories) throws IllegalParameterException
    {
        return new FacilityImpl(name, rate, cost, inventories);
    }

    public static Facility build(String name, Double rate, Double cost)
    {
        return null;
    }
}
