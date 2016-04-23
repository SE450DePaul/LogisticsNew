package logistics.utilities.loader;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.Item;
import logistics.utilities.loader.Loader;

import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public interface ItemLoader extends Loader<Item>
{
    ArrayList<Item> load() throws LoaderFileNotFoundException;
}
