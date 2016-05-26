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
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

public class OrderRequestDTO 
{
    private String orderId;
    private String destination;
    private int startTime;
    private Collection<OrderItemRequestDTO> orderItemRequestDTOs;

   /*
    * Creates a new Order Request DTO given an order destination, item ID, starting time, and a collection of item request DTOs.
    */
   public OrderRequestDTO(String orderId, String destination, int startTime, Collection<OrderItemRequestDTO> itemRequestDTOS) throws NullParameterException, NegativeOrZeroParameterException
   {
	   setDestination(destination); 
       setOrderId(orderId);
       setStartTime(startTime); 
       setOrderItemRequest(itemRequestDTOS);
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
	public void setOrderId(String orderItemId) throws NullParameterException
	{
		validateOrderId(orderItemId);
		orderItemId = orderId;
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
	* Helper method that sets the Order Item DTOs given a collection of Item request DTOs
	*/
	public void setOrderItemRequest(Collection<OrderItemRequestDTO> orderItemDto) throws NullParameterException, NegativeOrZeroParameterException
	{
		validateOrderItemRequest(orderItemDto);
		orderItemDto = orderItemRequestDTOs;
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
   private void validateDestination(String destination) throws NullParameterException 
   {
	   if (destination == null || destination.isEmpty())
			throw new NullParameterException("Destination cannot be Null or Empty");
   }
		
 /*
  * Helper method that validates that an order Item's name is not Empty or Null.
  */		
  private void validateOrderId(String orderId) throws NullParameterException 
  {
	  if (orderId == null || orderId.isEmpty())
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
  * Helper method that validates that the Order Items are not Null.
  */
  private void validateOrderItemRequest(Collection<OrderItemRequestDTO> itemRequest) throws NullParameterException, NegativeOrZeroParameterException 
  {
	  // might need to compact the checks to remove the dangling-if problem
	  for (OrderItemRequestDTO orderItems : itemRequest){
          if (orderItems == null)
        	  throw new NullParameterException("Order Item Request cannot be Null");
          
          if (orderItems.destination.isEmpty() || orderItems.destination == null)
        	  throw new NullParameterException("The Order Item's Destination cannot be Null or Empty");
          if (orderItems.itemId.isEmpty() || orderItems.itemId == null)
        	  throw new NullParameterException("The Order Item's ID cannot be Null or Empty");
          
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
