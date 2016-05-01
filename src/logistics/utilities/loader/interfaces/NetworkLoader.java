package logistics.utilities.loader.interfaces;

import logistics.networkservice.interfaces.FacilityVertex;
import logistics.utilities.exceptions.LoaderFileNotFoundException;

import java.util.Collection;

/**
 * Created by uchennafokoye on 4/26/16.
 */
public interface NetworkLoader extends Loader<FacilityVertex>
{
    Collection<FacilityVertex> load() throws LoaderFileNotFoundException;
}
