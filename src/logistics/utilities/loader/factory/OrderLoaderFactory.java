package logistics.utilities.loader.factory;

/**
 * This class represents a Order Loader Factory, which handles object creation 
 * of new Order Loader implementation classes.
 * 
 * @author David Olorundare
 */

import logistics.utilities.loader.LoaderConfig;
import logistics.utilities.loader.implementation.OrderXmlLoaderImpl;
import logistics.utilities.loader.interfaces.OrderLoader;

public class OrderLoaderFactory 
{
	public static OrderLoader build() 
	{
        switch (LoaderConfig.FilePath.FILE_TYPE)
        {
            case "xml":
                return new OrderXmlLoaderImpl(LoaderConfig.FilePath.ORDERS);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
