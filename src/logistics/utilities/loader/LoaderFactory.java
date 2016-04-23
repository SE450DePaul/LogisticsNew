package logistics.utilities.loader;

import logistics.utilities.loader.Loader;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public abstract class LoaderFactory {
    public abstract Loader createLoader(String file_type, String file_path);
}
