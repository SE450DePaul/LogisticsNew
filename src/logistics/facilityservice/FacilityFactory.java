package logistics.facilityservice;

import logistics.facilityservice.inventory.Inventory;

import java.util.ArrayList;

/**
 * @author David Olorundare
 */
public class FacilityFactory 
{

    public static Facility build(String name, Double rate, Double cost, ArrayList<Inventory> inventories)
    {
        return new FacilityImpl(name, rate, cost, inventories);
    }

    public static Facility build(String name, Double rate, Double cost)
    {
        return null;
    }
}
