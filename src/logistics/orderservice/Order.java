package logistics.orderservice;

/**
* This is an Order Interface which provides common behaviors 
* every Order implementation should be able to perform.
* 
* @author David Olorundare
*/

import java.util.ArrayList;
import logistics.itemservice.ItemImpl;

public interface Order
{
    String getName();
    Integer getStartDay();
    String getDestination();
    ArrayList<ItemImpl> getOrderItems();
    String toString();
}