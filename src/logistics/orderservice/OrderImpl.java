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
import logistics.itemservice.ItemImpl;

public class OrderImpl implements Order
{	

	private String orderDestination;
	private Integer orderStartDay;
	private ArrayList<ItemImpl> orderItems;
	private String orderName;
	
	public OrderImpl(String name, String dest, Integer startDay, ArrayList<ItemImpl> items)
	{
		
	}
	
	public void setOrderName(String orderName) 
	{
		this.orderName = orderName;
	}

	public void setOrderDestination(String orderDestination) 
	{
		this.orderDestination = orderDestination;
	}

	public void setOrderStartDay(Integer orderStartDay) 
	{
		this.orderStartDay = orderStartDay;
	}

	public void setOrderItems(ArrayList<ItemImpl> orderItems) 
	{
		this.orderItems = orderItems;
	}
	
	/*
	 * Returns the name of the Order
	 */
	public String getName() 
	{
	
		return null;
	}

	/*
	 * Returns the starting Day the Order is to be processed from. 
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
	
		return null;
	}

	/*
	 * Returns a list of all Items in this order.
	 */
	public ArrayList<ItemImpl> getOrderItems() 
	{
		
		return null;
	}

	/*
	 * Helper method that validates that a given Facility's Cost is not Null.
	 */
	private void validateOrderName(String name)
	{
		
	}
	
	/*
	 * Helper method that validates that a given Facility's Cost is not Null.
	 */
	private void validateOrderStartDay(Integer startDay)
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
