package logistics.utilities.loader.factory;

import logistics.utilities.loader.Loader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public abstract class LoaderFactory {
    public abstract Loader createLoader(String file_type, String file_path);
    public static LoaderFactory getLoaderFactory(String type) {
        type = type.toLowerCase();
        if (type == "item"){
            return new ItemLoaderFactory();
        } else if (type == "facility"){
            return null;
        }

        return null;
    }
}
