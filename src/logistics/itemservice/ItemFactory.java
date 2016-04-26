package logistics.itemservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemFactory {

    public static Item build(String id, Double price) throws IllegalParameterException{
        return new ItemImpl(id, price);
    }
}
