package logistics.itemservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemFactory {

    public static Item build(String id, Double price) throws NullParameterException {
        return new ItemImpl(id, price);
    }
}
