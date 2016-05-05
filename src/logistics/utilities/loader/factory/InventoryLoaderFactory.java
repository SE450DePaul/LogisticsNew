package logistics.utilities.loader.factory;

/**
 * This class represents an Inventory Loader Factory, which handles object creation 
 * of new Inventory Loader implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.loader.LoaderConfig;
import logistics.utilities.loader.implementation.InventoryXmlLoaderImpl;
import logistics.utilities.loader.interfaces.InventoryLoader;

public class InventoryLoaderFactory {

    public static InventoryLoader build() {
        switch (LoaderConfig.FilePath.FILE_TYPE){
            case "xml":
                return new InventoryXmlLoaderImpl(LoaderConfig.FilePath.INVENTORY);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
