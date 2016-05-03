package logistics.utilities.loader.factory;

import logistics.utilities.loader.config.LoaderConfig;
import logistics.utilities.loader.implementation.FacilityXmlLoaderImpl;
import logistics.utilities.loader.interfaces.FacilityLoader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityLoaderFactory 
{
    public static FacilityLoader build() 
    {
        switch (LoaderConfig.FilePath.FILE_TYPE)
        {
            case "xml":
                return new FacilityXmlLoaderImpl(LoaderConfig.FilePath.FACILITY);
            case "json":
                return null;
            default:
                return null;
        }
    }
}
