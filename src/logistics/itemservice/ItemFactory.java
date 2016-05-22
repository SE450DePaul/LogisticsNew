package logistics.itemservice;

/**
 * This class represents an Item Factory, which handles object creation 
 * of new Items implementation classes.
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.exceptions.NullParameterException;

public class ItemFactory {

	/*
	 * Returns a newly created item object given
	 * an item ID and price.
	 */
    public static Item build(String id, Double price) throws NullParameterException {
        return new ItemImpl(id, price);
    }
}
