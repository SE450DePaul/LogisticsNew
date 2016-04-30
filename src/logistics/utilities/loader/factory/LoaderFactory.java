package logistics.utilities.loader.factory;

import logistics.utilities.loader.interfaces.Loader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class LoaderFactory {

    public static Loader build(String type){
        if (type == "item"){
            return ItemLoaderFactory.build();
        } else if (type == "facility"){
            return FacilityLoaderFactory.build();
        } else if (type == "inventory"){
            return InventoryLoaderFactory.build();
        }

        return null;
    }

}
