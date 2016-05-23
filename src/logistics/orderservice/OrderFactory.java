package logistics.orderservice;

/**
 * This class represents an Order Factory, which handles object creation 
 * of new Order implementation classes.
 * 
 * @author David Olorundare
 */

import logistics.itemservice.ItemImpl;
import logistics.utilities.exceptions.NullParameterException;
import java.util.ArrayList;

public class OrderFactory 
{
	/*
	 * Returns a newly created order object given its name, the
	 * order destination, processing-start day, and a list order items.
	 */
    public static Order build(String orderName, String orderDestination, Integer orderStartDay, ArrayList<ItemImpl> orderItems ) throws NullParameterException {
        return new OrderImpl(orderName, orderDestination, orderStartDay, orderItems);
    }
}