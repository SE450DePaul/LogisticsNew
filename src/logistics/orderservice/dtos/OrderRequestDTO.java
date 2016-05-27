package logistics.orderservice.dtos;

/**
 * This class represents an Order Request DTO
 * which is used to transfer the Order Request
 * with other subsystems of the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */

import java.util.Collection;

import logistics.orderservice.ordersolution.OrderSolutionLeaf;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

public class OrderRequestDTO 
{
    private String orderId;
    private String destination;
    private int startTime;
    public Collection<OrderItemRequestDTO> orderItemRequestDTOs;

   /*
    * Creates a new Order Request DTO given an order destination, item ID, starting time, and a collection of item request DTOs.
    */
   public OrderRequestDTO(String oId, String oDestination, int oStartTime, Collection<OrderItemRequestDTO> itemRequestDTOS) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
   {
	   setDestination(oDestination); 
       setOrderId(oId);
       setStartTime(oStartTime); 
       setOrderItemRequest(itemRequestDTOS);
    }
   
   /*
    * Helper method that sets the order destination.
    */
	public void setDestination(String orderDestination) throws NullParameterException, IllegalParameterException
	{
		validateDestination(orderDestination);
		destination = orderDestination;
	}

   /*
	* Helper method that sets the order item ID.
	*/
	public void setOrderId(String orderItemId) throws NullParameterException, IllegalParameterException
	{
		validateOrderId(orderItemId);
		orderId = orderItemId;
	}

   /*
	* Helper method that sets the order start time given a day.
	*/
	public void setStartTime(int orderStartTime) throws NullParameterException, NegativeOrZeroParameterException
	{
		validateStartTime(orderStartTime);
		startTime = orderStartTime;
	}

   /*
	* Helper method that sets the Order Item DTOs given a collection of Item request DTOs
	*/
	public void setOrderItemRequest(Collection<OrderItemRequestDTO> orderItemDto) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
	{
		validateOrderItemRequest(orderItemDto);
		orderItemRequestDTOs = orderItemDto;
	}

   /*
	* Returns a list of the order item DTOs
	*/
	public void getOrderItem()
	{
		for (OrderItemRequestDTO orderItems : orderItemRequestDTOs)
		{
            System.out.println("Item ID: " + orderItems.itemId + " Destination: " + orderItems.destination + " Start Time: " + orderItems.startTime + " Quantity Needed: " + orderItems.quantityNeeded );
        }
	}
	
	/*
	* Returns a collection of the order item DTOs
	*/
	public Collection<OrderItemRequestDTO> getOrderItems()
	{
		return orderItemRequestDTOs;
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
	public String getOrderId() 
	{
		return orderId;
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
   public void validateDestination(String destination) throws NullParameterException, IllegalParameterException 
   {
	   if (destination == null)
			throw new NullParameterException("Destination cannot be Null");
	   if (destination.isEmpty())
     	  throw new IllegalParameterException("Destination cannot be Empty");
   }
		
 /*
  * Helper method that validates that an order Item's name is not Empty or Null.
  */		
  public void validateOrderId(String orderId) throws NullParameterException, IllegalParameterException 
  {
	  if (orderId == null)
			throw new NullParameterException("Item ID cannot be Null");
	  if (orderId.isEmpty())
    	  throw new IllegalParameterException("Item ID cannot be Empty");
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
  * Helper method that validates that the Order Items are not Null.
  */
  private void validateOrderItemRequest(Collection<OrderItemRequestDTO> itemRequest) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException 
  {
	  // might need to compact the checks to remove the dangling-if problem
	  for (OrderItemRequestDTO orderItems : itemRequest){
          if (orderItems == null)
        	  throw new NullParameterException("Order Item Request cannot be Null");
          
          if (orderItems.destination == null)
        	  throw new NullParameterException("The Order Item's Destination cannot be Null");
          if (orderItems.destination.isEmpty())
        	  throw new IllegalParameterException("The Order Item's ID cannot be Empty");
          
          if (orderItems.itemId == null)
        	  throw new NullParameterException("The Order Item's ID cannot be Null");
          if (orderItems.itemId.isEmpty())
        	  throw new IllegalParameterException("The Order Item's ID cannot be Empty");
          
          if (orderItems.startTime == 0)
        	  throw new NullParameterException("The Order's Starting time cannot be zero");
          if (orderItems.startTime < 0)
        	  throw new NegativeOrZeroParameterException("The Order's Starting time cannot be Negative");
          
          if (orderItems.quantityNeeded == 0)
        	  throw new NullParameterException("The quantity needed for the order cannot be zero");
          if (orderItems.quantityNeeded < 0)
        	  throw new NegativeOrZeroParameterException("The quantity needed for the order cannot be Negative");
      }
  }
}
