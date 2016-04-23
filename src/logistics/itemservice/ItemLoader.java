package logistics.itemservice;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.Loader;

import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public interface ItemLoader extends Loader<Item>
{
    ArrayList<Item> load() throws LoaderFileNotFoundException;
}
