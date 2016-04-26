package logistics.facilityservice.inventory;


/**
 * @author David Olorundare
 */
public class InventoryFactory
{

    public static Inventory build(String itemId, int quantity)
    {
        return new InventoryImpl(itemId, quantity);
    }
}
