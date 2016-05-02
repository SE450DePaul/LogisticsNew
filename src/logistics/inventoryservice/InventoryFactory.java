package logistics.inventoryservice;
import logistics.utilities.exceptions.IllegalParameterException;

/**
 * @author David Olorundare
 */
public class InventoryFactory
{
    public static Inventory build(String facilityName) throws IllegalParameterException 
    {
        return new InventoryImpl(facilityName);
    }
}
