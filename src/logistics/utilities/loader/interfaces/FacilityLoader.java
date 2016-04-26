package logistics.utilities.loader.interfaces;

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.facilityservice.Facility;

import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/26/16.
 */
public interface FacilityLoader extends Loader<Facility>
{
    ArrayList<Facility> load() throws LoaderFileNotFoundException;
}
