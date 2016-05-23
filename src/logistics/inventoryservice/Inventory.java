package logistics.inventoryservice;

import logistics.utilities.exceptions.NegativeOrZeroParameterException;

/**
 * This is a Facility Inventory Interface which provides common behaviors 
 * every Facility Inventory implementation should be able to perform.
 * 
 * @author David Olorundare
 */

import logistics.utilities.exceptions.NullParameterException;

public interface Inventory
{
    void updateInventory(String itemId, int quantity) throws NullParameterException, NegativeOrZeroParameterException;
    void addInventoryItem(String itemId, int quantity) throws NullParameterException, NegativeOrZeroParameterException;
    Integer getQuantity(String itemId);
    String getFacilityName();
    String getInventoryOutput();
}
