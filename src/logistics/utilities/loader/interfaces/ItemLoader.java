package logistics.utilities.loader.interfaces;

import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.Item;

import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public interface ItemLoader extends Loader<Item>
{
    ArrayList<Item> load() throws LoaderFileNotFoundException;
}
