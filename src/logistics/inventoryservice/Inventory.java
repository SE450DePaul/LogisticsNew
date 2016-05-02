package logistics.inventoryservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * @author David Olorundare
 */
public interface Inventory
{

    void updateInventory(String itemId, int quantity) throws IllegalParameterException;
    void addInventoryItem(String itemId, int quantity) throws IllegalParameterException;
    Integer getQuantity(String itemId);
    String getFacilityName();
    String getInventoryOutput();


}
