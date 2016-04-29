package logistics.utilities.loader.factory;

import logistics.utilities.loader.implementation.InventoryXmlLoaderImpl;
import logistics.utilities.loader.interfaces.FacilityLoader;
import logistics.utilities.loader.interfaces.InventoryLoader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class InventoryLoaderFactory extends LoaderFactory {

    public InventoryLoader createLoader(String type, String filepath) {
        if (type.equals("xml")){
            return new InventoryXmlLoaderImpl(filepath);
        } else if (type.equals("json")){
            return null;
        }

        return null;
    }
}
