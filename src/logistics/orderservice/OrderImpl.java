package logistics.orderservice;

/**
 * This class represents the implementation of an Order.
 * 
 * The class provides methods to create new orders as well 
 * as update the properties of existing orders.
 * 
 * @author David Olorundare
 */

import logistics.utilities.exceptions.NullParameterException;
import java.util.ArrayList;
import logistics.itemservice.Item;
import logistics.itemservice.ItemImpl;

public class OrderImpl implements Order
{	

	private String orderDestination;
	private String orderStartDay;  // NEED a way to convert string 'Day 1' into just an integer 
	private ArrayList<Item> orderItems;
	private String orderId;
	
	/*
     * Creates a new Facility Order
     */
	public OrderImpl(String name, String dest, String startDay, ArrayList<Item> items)
	{
		orderId = name;
		orderStartDay = startDay;
		
		for (Item itm: items)
		{
			orderItems.add(itm);
		}	
	}
	
	/*
	 * Helper method that sets the ID of this order given a name.
	 */
	public void setOrderId(String name) throws NullParameterException 
	{
		validateOrderId(name);
		orderId = name;
	}

	/*
	 * Helper method that sets this order's destination name.
	 */
	public void setOrderDestination(String destination) throws NullParameterException 
	{
		validateOrderDestination(destination);
		orderDestination = destination;
	}

	/*
	 * Helper method that sets the start day of this order.
	 */
	public void setOrderStartDay(String startDay) throws NullParameterException 
	{
		validateOrderStartDay(startDay);
		orderStartDay = startDay;
	}

	/*
	 * Helper method that adds a new item to this order.
	 */
	public void setOrderItems(Item items) throws NullParameterException
	{
		validateOrderItem(items);
		orderItems.add(items);
	}
	
	/*
	 * Returns the name of the Order
	 */
	public String getId() 
	{
	
		return orderId;
	}

	/*
	 * Returns the starting Day the Order is to be processed from. 
	 */
	public String getStartDay() 
	{
	
		return orderStartDay;
	}
	
	/*
	 * Returns (as an Integer) the starting Day the Order is to be processed from. 
	 */
	public Integer getStartDay() 
	{
	
		return null;
	}

	/*
	 * Returns the name of the Facility destination of this order.
	 */
	public String getDestination() 
	{
	
		return orderDestination;
	}

	/*
	 * Returns a list of all Items in this order.
	 */
	public ArrayList<Item> getOrderItems() 
	{
		
		return null;
	}

	/*
	 * Helper method that validates that a given Order's ID is not Null or Empty.
	 */
	private void validateOrderId(String name) throws NullParameterException
	{
		if (orderId == null)
			throw new NullParameterException("Order ID cannot be Null");
		if (orderId.isEmpty())
			throw new NullParameterException("Order ID cannot be Empty");
	}
	
	/*
	 * Helper method that validates that a given Order's Starting Day is not Null or Empty.
	 */
	private void validateOrderStartDay(String startDay) throws NullParameterException
	{
		if (orderId == null)
			throw new NullParameterException("Order Start Day cannot be Null");
		if (orderId.isEmpty())
			throw new NullParameterException("Order Start Day cannot be Empty");
	}
	
	/*
	 * Helper method that validates that a given Order's Destination is not Null or Empty.
	 */
	private void validateOrderDestination(String dest) throws NullParameterException
	{
		if (orderId == null)
			throw new NullParameterException("Order Destination cannot be Null");
		if (orderId.isEmpty())
			throw new NullParameterException("Order Destination cannot be Empty");
	}
	
	/*
	 * Helper method that validates that the Items in a given Order are not Null.
	 */
	private void validateOrderItem(Item orderItem) throws NullParameterException
	{
		if (orderItem == null)
			throw new NullParameterException("Item cannot be Null");
		
	}

	/*
	 * Helper method to output the details of an Order.
	 */
	public String toString() 
	{
		return "Order Details:\n\nOrder ID: " + orderId + " Destination: " + orderDestination + " Start Day: " + orderStartDay + "\nOrder Items:\n"
				+ getOrderItems();
	}	
	
	
}
