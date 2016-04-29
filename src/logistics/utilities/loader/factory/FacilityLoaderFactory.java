package logistics.utilities.loader.factory;

import logistics.utilities.loader.LoaderConfig;
import logistics.utilities.loader.implementation.FacilityXmlLoaderImpl;
import logistics.utilities.loader.interfaces.FacilityLoader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityLoaderFactory extends LoaderFactory {

    public static FacilityLoader build() {
        switch (LoaderConfig.FilePath.FILE_TYPE){
            case "xml":
                return new FacilityXmlLoaderImpl(LoaderConfig.FilePath.FACILITY);
            case "json":
                return null;
            default:
                return null;
        }

    }

}
