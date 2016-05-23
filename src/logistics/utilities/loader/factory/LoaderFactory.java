package logistics.utilities.loader.factory;

/**
 * This class represents a Loader Factory, which handles creation 
 * of Facility, Item, Inventory, and Network Loader Factories.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.loader.interfaces.Loader;

public class LoaderFactory {

    public static Loader build(String type){
        if (type.equals("item")){
            return ItemLoaderFactory.build();
        } else if (type.equals("facility")){
            return FacilityLoaderFactory.build();
        } else if (type.equals("inventory")){
            return InventoryLoaderFactory.build();
        } else if (type.equals("network")){
            return NetworkLoaderFactory.build();
        } else if (type.equals("order")){
            return OrderLoaderFactory.build();
        }
        return null;
    }
}
