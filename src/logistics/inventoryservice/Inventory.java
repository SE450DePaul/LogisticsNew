package logistics.inventoryservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * @author David Olorundare
 */
public interface Inventory
{
    void updateInventory(String itemId, int quantity) throws NullParameterException;
    void addInventoryItem(String itemId, int quantity) throws NullParameterException;
    Integer getQuantity(String itemId);
    String getFacilityName();
    String getInventoryOutput();
}
