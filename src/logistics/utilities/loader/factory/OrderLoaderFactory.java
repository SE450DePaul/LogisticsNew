package logistics.utilities.loader.factory;

import logistics.utilities.loader.LoaderConfig.FilePath;
import logistics.utilities.loader.implementation.OrderXmlLoaderImpl;
import logistics.utilities.loader.interfaces.OrderLoader;

/**
 * This class represents an Item Loader Factory, which handles object creation 
 * of new Item Loader Implementation classes.
 * 
 * @author Uchenna F. Okoye
 */
public class OrderLoaderFactory {

    public static OrderLoader build() {
        switch (FilePath.FILE_TYPE){
            case "xml":
                return new OrderXmlLoaderImpl(FilePath.ORDERS);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
