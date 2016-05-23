package logistics.orderservice;

/**
 * This class represents the implementation of an Order.
 * 
 * The class provides methods to 
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
	
	public OrderImpl(String name, String dest, String startDay, ArrayList<Item> items)
	{
		
	}
	
	public void setOrderId(String orderName) 
	{
		this.orderId = orderName;
	}

	public void setOrderDestination(String orderDestination) 
	{
		this.orderDestination = orderDestination;
	}

	public void setOrderStartDay(String orderStartDay) 
	{
		this.orderStartDay = orderStartDay;
	}

	public void setOrderItems(ArrayList<Item> orderItems) 
	{
		this.orderItems = orderItems;
	}
	
	/*
	 * Returns the name of the Order
	 */
	public String getId() 
	{
	
		return null;
	}

	/*
	 * Returns the starting Day the Order is to be processed from. 
	 */
	public String getStartDay() 
	{
	
		return null;
	}

	/*
	 * Returns the name of the Facility destination of this order.
	 */
	public String getDestination() 
	{
	
		return null;
	}

	/*
	 * Returns a list of all Items in this order.
	 */
	public ArrayList<Item> getOrderItems() 
	{
		
		return null;
	}

	/*
	 * Helper method that validates that a given Facility's Cost is not Null.
	 */
	private void validateOrderId(String name)
	{
		
	}
	
	/*
	 * Helper method that validates that a given Facility's Cost is not Null.
	 */
	private void validateOrderStartDay(String startDay)
	{
		
	}
	
	/*
	 * Helper method that validates that a given Facility's Cost is not Null.
	 */
	private void validateOrderDestination(String dest)
	{
		
	}
	
	/*
	 * Helper method that validates that a given Facility's Cost is not Null.
	 */
	private void validateOrderItem(String orderItem)
	{
		
	}	
}
