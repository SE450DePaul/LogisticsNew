package logistics.itemservice;

import logistics.exceptions.LoaderFileNotFoundException;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public interface ItemLoader
{
    Item[] load() throws LoaderFileNotFoundException;
}
