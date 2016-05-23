package logistics.orderservice;

import java.util.ArrayList;

import logistics.itemservice.ItemImpl;

/**
 * This class represents the implementation of an Order.
 * 
 * The class provides methods to 
 * 
 * @author David Olorundare
 */

import logistics.utilities.exceptions.NullParameterException;


public class OrderImpl implements Order
{	

	private String orderDestination;
	private Integer orderStartDay;
	private ArrayList<ItemImpl> orderItems;
	private String orderName;
	
	
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
	
	
	public String getName() 
	{
	
		return null;
	}

	
	public Integer getStartDay() 
	{
	
		return null;
	}

	
	public String getDestination() 
	{
	
		return null;
	}

	
	public ArrayList<ItemImpl> getOrderItems() 
	{
		
		return null;
	}

	private void validateOrderName(String name)
	{
		
	}
	
	private void validateOrderStartDay(Integer startDay)
	{
		
	}
	
	private void validateOrderDestination(String dest)
	{
		
	}
	
	private void validateOrderItem(String orderItem)
	{
		
	}	
}
