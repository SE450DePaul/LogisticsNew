package logistics.orderservice.order;

import logistics.orderservice.dtos.OrderItemRequestDTO;
import logistics.orderservice.dtos.OrderRequestDTO;
import logistics.orderservice.order.orderitem.OrderItem;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Uchenna F. Okoye
 */
public class OrderImpl implements Order
{

    private String orderId;
    private int orderTime;
    private String orderDestination;
    private Collection<OrderItem> orderItems;

    /*
     * Creates a new Order Implementation object given an OrderRequestDTO.
     */
    public OrderImpl(OrderRequestDTO orderRequestDTO) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
    {
        setOrderId(orderRequestDTO.getOrderId());
        setOrderTime(orderRequestDTO.getStartTime());
    	setOrderDestination(orderRequestDTO.getDestination());
    }

    /*
	* Helper method that sets the order ID.
	*/
	public void setOrderId(String id) throws NullParameterException, IllegalParameterException
	{
		validateOrderId(id);
		orderId = id;
	}

   /*
	* Helper method that sets the order time.
	*/
	public void setOrderTime(int time) throws NullParameterException, NegativeOrZeroParameterException
	{
		validateOrderTime(time);
		orderTime = time;
	}

   /*
	* Helper method that sets the order destination.
	*/
	public void setOrderDestination(String destination) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
	{
		validateOrderDestination(destination);
		orderDestination = destination;
	}
	
	/*
	* Helper method that sets the order items.
	*/
	public void setOrderItems(Collection<OrderItem> items) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException
	{
		validateOrderItems(items);
		orderItems = items;
	}
	
   /*
	* Returns the Order Time.
	*/
	public int getOrderTime() 
	{
		return orderTime;
	}

   /*
	* Returns the Order's ID
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
		return orderDestination;
	}

    /*
     * Returns a list of Order Items
     */
    public Iterator<OrderItem> getOrderItems() 
    {
		/// Need to write this code (^_^)
    }
    
    /*
     * Helper method that validates that an order's destination is not null or empty.
     */
     private void validateOrderDestination(String orderDestination) throws NullParameterException, IllegalParameterException 
     {
  	   if (orderDestination == null)
  			throw new NullParameterException("Order Destination cannot be Null");
  	   if (orderDestination.isEmpty())
  		    throw new IllegalParameterException("The Order Destination cannot be Empty");
     }
  		
   /*
    * Helper method that validates that an order time is not Empty or Null.
    */		
    private void validateOrderTime(int orderTime) throws NullParameterException, NegativeOrZeroParameterException 
    {
    	if (orderTime == 0)
			throw new NullParameterException("Order Time cannot be Zero");
	   if (orderTime < 0)
			throw new NegativeOrZeroParameterException("Order Time cannot be a Negative value");
    }
    
    /*
     * Helper method that validates that an order ID is not Null or Empty.
     */		
     private void validateOrderId(String orderId) throws NullParameterException, IllegalParameterException 
     {
   	  if (orderId == null)
   			throw new NullParameterException("Order ID cannot be Null");
   	  if (orderId.isEmpty())
   		    throw new IllegalParameterException("The Order ID cannot be Empty");
     }
     
     /*
      * Helper method that validates that an order's item ID and quantity are not Null, Empty, or Zero.
      */
      private void validateOrderItems(Collection<OrderItem> items) throws NullParameterException, NegativeOrZeroParameterException, IllegalParameterException 
      {
    	  for (OrderItem orderItems : items)
    	  {
              if (orderItems == null)
            	  throw new NullParameterException("Order's Item cannot be Null");
             
              if (orderItems.getItemId() == null)
            	  throw new NullParameterException("The Order's Item ID cannot be Null");
              if (orderItems.getItemId().isEmpty())
            	  throw new IllegalParameterException("The Order Item's ID cannot be Empty");
              
              if (orderItems.getQuantity() == 0)
            	  throw new NullParameterException("The Order's Item Quantity cannot be zero");
              if (orderItems.getQuantity() < 0)  
            	  throw new NegativeOrZeroParameterException("The Order's ID cannot be a negative value");
          }
      }
}
