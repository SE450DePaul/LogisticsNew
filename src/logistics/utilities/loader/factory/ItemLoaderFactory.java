package logistics.utilities.loader.factory;

import logistics.utilities.loader.ItemLoader;
import logistics.utilities.loader.ItemXMLLoaderImpl;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemLoaderFactory extends LoaderFactory {

    public ItemLoader createLoader(String type, String filepath) {
        if (type.equals("xml")){
            return new ItemXMLLoaderImpl(filepath);
        } else if (type.equals("json")){
            return null;
        }

        return null;
    }
}
