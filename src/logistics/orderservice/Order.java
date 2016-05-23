package logistics.orderservice;

/**
* This is an Order Interface which provides common behaviors 
* every Order implementation should be able to perform.
* 
* @author David Olorundare
*/

public interface Order
{
    String getId();
    String getStartDay();
    String getDestination();
    void getOrderItems();
    //String toString();
}