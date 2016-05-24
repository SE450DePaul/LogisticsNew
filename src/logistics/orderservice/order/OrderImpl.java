package logistics.orderservice.order;

import logistics.orderservice.dtos.OrderRequestDTO;
import logistics.orderservice.order.orderitem.OrderItem;

import java.util.Iterator;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public class OrderImpl implements Order{

    public OrderImpl(OrderRequestDTO orderRequestDTO){

    }

    @Override
    public String geId() {
        return null;
    }

    @Override
    public int getOrderTime() {
        return 0;
    }

    @Override
    public String getDestination() {
        return null;
    }

    @Override
    public Iterator<OrderItem> getOrderItems() {
        return null;
    }


}
