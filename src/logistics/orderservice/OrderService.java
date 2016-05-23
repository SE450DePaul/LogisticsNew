package logistics.orderservice;

/**
* This class represents an Order service Manager that keeps track of all Orders.
* 
* It provides methods for creating a Facility Order, returning
* a Facility's information to a requesting client, as well as display the 
* list of all available Facilities.
* 
* @author David Olorundare
*/

import java.util.Collection;
import java.util.HashMap;
import logistics.inventoryservice.Inventory;
import logistics.inventoryservice.InventoryService;
import logistics.inventoryservice.inventoryitem.InventoryItemDTO;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.factory.LoaderFactory;
import logistics.utilities.loader.interfaces.Loader;

public final class OrderService
{
    private volatile static OrderService instance;
    private HashMap<String, Order> orderHashMap = new HashMap<>();
    private Loader<Inventory> loader;

    private OrderService() 
    {
        loader = LoaderFactory.build("order");

        try {
            Collection<Order> orders = loader.load();
            for (Order order : orders){
                orderHashMap.put(inventory.getFacilityName(), inventory);
            }
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Returns an instance of the Inventory Service 
     */
    public static OrderService getInstance() 
    {
        if (instance == null)
        {
            synchronized (OrderService.class)
            {
                if (instance == null)
                {
                    instance = new OrderService();
                }
            }
        }
        return instance;
    }
    
    /*
     * Returns an Inventory Item's information given a Facility
     * and the Item being sort for. 
     */
    public OrderDTO getInventoryItem(String facilityName, String itemId) {

        Order order = orderHashMap.get(facilityName);
        if (inventory == null) { return null; }
        Integer quantity = inventory.getQuantity(itemId);
        if (quantity == null) { return null; }
        return new InventoryItemDTO(itemId, quantity);
    }

    /*
     * Returns the Inventory of a given Facility.
     */
    public String getOutput(String facilityName){
        Order order = orderHashMap.get(facilityName);
        if (order == null) { return ""; }
        return inventory.getInventoryOutput();

    }
}