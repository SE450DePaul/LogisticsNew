package logistics.utilities.loader.factory;

import logistics.utilities.loader.LoaderConfig;
import logistics.utilities.loader.implementation.InventoryXmlLoaderImpl;
import logistics.utilities.loader.interfaces.FacilityLoader;
import logistics.utilities.loader.interfaces.InventoryLoader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class InventoryLoaderFactory extends LoaderFactory {


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
