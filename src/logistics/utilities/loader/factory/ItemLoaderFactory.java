package logistics.utilities.loader.factory;

import logistics.utilities.loader.LoaderConfig.FilePath;
import logistics.utilities.loader.interfaces.ItemLoader;
import logistics.utilities.loader.implementation.ItemXmlLoaderImpl;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemLoaderFactory 
{
    public static ItemLoader build()
    {
        switch (FilePath.FILE_TYPE)
        {
            case "xml":
                return new ItemXmlLoaderImpl(FilePath.ITEM);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
