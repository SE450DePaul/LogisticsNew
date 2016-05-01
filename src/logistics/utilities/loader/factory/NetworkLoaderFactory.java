package logistics.utilities.loader.factory;

import logistics.utilities.loader.LoaderConfig;
import logistics.utilities.loader.implementation.NetworkXmlLoaderImpl;
import logistics.utilities.loader.interfaces.NetworkLoader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class NetworkLoaderFactory {


    public static NetworkLoader build() {
        switch (LoaderConfig.FilePath.FILE_TYPE){
            case "xml":
                return new NetworkXmlLoaderImpl(LoaderConfig.FilePath.INVENTORY);
            case "json":
                return null;
            default:
                return null;
        }

    }

}
