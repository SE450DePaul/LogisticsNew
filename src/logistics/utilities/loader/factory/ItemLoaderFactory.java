package logistics.utilities.loader.factory;

import logistics.utilities.loader.LoaderConfig.FilePath;
import logistics.utilities.loader.interfaces.ItemLoader;
import logistics.utilities.loader.implementation.ItemXmlLoaderImpl;

/**
 * This class represents an Item Loader Factory, which handles object creation 
 * of new Item Loader Implementation classes.
 * 
 * @author Uchenna F. Okoye
 */
public class ItemLoaderFactory {

    public static ItemLoader build() {
        switch (FilePath.FILE_TYPE){
            case "xml":
                return new ItemXmlLoaderImpl(FilePath.ITEM);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
