package logistics.utilities.loader.interfaces;

import logistics.inventoryservice.Inventory;
import logistics.utilities.exceptions.LoaderFileNotFoundException;

import java.util.Collection;

/**
 * Created by uchennafokoye on 4/26/16.
 */
public interface InventoryLoader extends Loader<Inventory>
{
    Collection<Inventory> load() throws LoaderFileNotFoundException;
}
