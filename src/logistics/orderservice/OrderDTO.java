package logistics.orderservice;

/**
 * This class represents an Order Data Transfer Object that is 
 * passed, as the return data, to clients who request any of 
 * the Order Manager's services. 
 * 
 * @author David Olorundare
 */

public class OrderDTO
{
    public String name;
    public String destination;
    public String startDay;
    // ArrayList<Item> items;

    public OrderDTO(String orderName, String orderDestination, String orderStartDay)
    {
        name = orderName;
        destination = orderDestination;
        startDay = orderStartDay;
      //items = orderItems;  
    }
}