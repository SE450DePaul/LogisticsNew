package logistics.utilities.loader.factory;

/**
 * This class represents a Network Loader Factory, which handles object creation 
 * of new Network Loader implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.loader.LoaderConfig;
import logistics.utilities.loader.implementation.NetworkXmlLoaderImpl;
import logistics.utilities.loader.interfaces.NetworkLoader;

public class NetworkLoaderFactory {

    public static NetworkLoader build() {
        switch (LoaderConfig.FilePath.FILE_TYPE){
            case "xml":
                return new NetworkXmlLoaderImpl(LoaderConfig.FilePath.NETWORK);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
