package logistics.inventoryservice;
import logistics.utilities.exceptions.NullParameterException;

/**
 * @author David Olorundare
 */
public class InventoryFactory
{
    public static Inventory build(String facilityName) throws NullParameterException 
    {
        return new InventoryImpl(facilityName);
    }
}
