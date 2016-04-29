package logistics.utilities.loader.factory;

import logistics.utilities.loader.implementation.FacilityXmlLoaderImpl;
import logistics.utilities.loader.interfaces.FacilityLoader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class FacilityLoaderFactory extends LoaderFactory {

    public FacilityLoader createLoader(String type, String filepath) {
        if (type.equals("xml")){
            return new FacilityXmlLoaderImpl(filepath);
        } else if (type.equals("json")){
            return null;
        }

        return null;
    }
}
