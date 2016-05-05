package logistics.utilities.loader.factory;

/**
 * This class represents a Facility Loader Factory, which handles object creation 
 * of new Facility Loader implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.loader.LoaderConfig;
import logistics.utilities.loader.implementation.FacilityXmlLoaderImpl;
import logistics.utilities.loader.interfaces.FacilityLoader;

public class FacilityLoaderFactory {

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
