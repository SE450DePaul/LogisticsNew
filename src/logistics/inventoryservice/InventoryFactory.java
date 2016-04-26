package logistics.inventoryservice;

/**
 * @author David Olorundare
 */
public class InventoryFactory
{

    public static Inventory build(String name, String itemId, int quantity)
    {
        return new InventoryImpl(name, itemId, quantity);
    }
}
