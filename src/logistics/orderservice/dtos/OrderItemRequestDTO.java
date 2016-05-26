package logistics.orderservice.dtos;

import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

/**
 * This class represents an Order Request DTO
 * which is used to transfer the Order Request
 * with other subsystems of the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */
public class OrderItemRequestDTO
{

    public String destination;
	public String itemId;
    public int startTime;
    public int quantityNeeded;

  /*
   * Creates a new Order Item Request DTO given an order destination, item ID, starting time, and quantity of items needed.
   */
   public OrderItemRequestDTO(String destination, String itemId, int startTime, int quantityNeeded) throws NullParameterException, NegativeOrZeroParameterException
   {
        setDestination(destination); 
        setItemId(itemId);
        setStartTime(startTime); 
        setQuantityNeeded(quantityNeeded);
    }
   
   /*
    * Helper method that sets the order destination.
    */
	public void setDestination(String orderDestination) throws NullParameterException
	{
		validateDestination(destination);
		orderDestination = destination;
	}

	/*
	 * Helper method that sets the order item ID.
	 */
	public void setItemId(String orderItemId) throws NullParameterException
	{
		validateItemId(itemId);
		orderItemId = itemId;
	}

	/*
	 * Helper method that sets the order start time given a day.
	 */
	public void setStartTime(int orderStartTime) throws NullParameterException, NegativeOrZeroParameterException
	{
		validateStartTime(startTime);
		orderStartTime = startTime;
	}

	/*
	 * Helper method that sets the Order quantity needed given an amount.
	 */
	public void setQuantityNeeded(int orderQuantityNeeded) throws NullParameterException, NegativeOrZeroParameterException
	{
		validateQuantityNeeded(orderQuantityNeeded);
		orderQuantityNeeded = quantityNeeded;
	}

	/*
	 * Returns the needed item Quantity of the Order.
	 */
	public int getQuantityNeeded()
	{
		return quantityNeeded;
	}
	
	/*
	 * Returns the Order's Start Time.
	 */
	public int getStartTime() 
	{
		return startTime;
	}

	/*
	 * Returns the Order's Item ID
	 */
	public String getItemId() 
	{
		return itemId;
	}
	
	/*
	 * Returns the Order Destination.
	 */
	public String getDestination() 
	{
		return destination;
	}
	
  /*
   * Helper method that validates that an order's destination is not null or empty.
   */
   private void validateDestination(String destination) throws NullParameterException 
   {
	   if (destination == null || destination.isEmpty())
			throw new NullParameterException("Destination cannot be Null or Empty");
   }
		
   /*
    * Helper method that validates that an order Item's name is not Empty or Null.
    */		
  private void validateItemId(String itemId) throws NullParameterException 
  {
	  if (itemId == null || itemId.isEmpty())
			throw new NullParameterException("Item ID cannot be Null or Empty");
  }
  
  /*
   * Helper method that validates an order's start time is not zero or negative.
   */
  private void validateStartTime(int startTime) throws NullParameterException, NegativeOrZeroParameterException 
  {
	  if (startTime == 0)
			throw new NullParameterException("Start Time cannot be Zero");
	  if (startTime < 0)
			throw new NegativeOrZeroParameterException("Start Time cannot be a Negative value");
  }
  
  /*
   * Helper method that validates that the quantity needed by an order is not zero or negative.
   */
  private void validateQuantityNeeded(int quantityNeeded) throws NullParameterException, NegativeOrZeroParameterException 
  {
	  if (quantityNeeded == 0)
			throw new NullParameterException("Quantity Needed cannot be Zero");
	  if (quantityNeeded < 0)
			throw new NegativeOrZeroParameterException("Quantity Needed cannot be a Negative value");
  }
  
}

