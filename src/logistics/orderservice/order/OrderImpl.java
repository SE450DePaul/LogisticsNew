package logistics.orderservice.order;

import logistics.orderservice.dtos.OrderRequestDTO;
import logistics.orderservice.order.orderitem.OrderItem;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by uchennafokoye on 5/21/16.
 */
public class OrderImpl implements Order{

    private String id;
    private int orderTime;
    private String destination;
    private Collection<OrderItem> orderItems;

    public OrderImpl(OrderRequestDTO orderRequestDTO){
        this.id = orderRequestDTO.orderId;
        this.orderTime = orderRequestDTO.startTime;
        this.destination = orderRequestDTO.destination;
    }



    @Override
    public String geId() {
        return id;
    }

    @Override
    public int getOrderTime() {
        return orderTime;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public Iterator<OrderItem> getOrderItems() {
        return null;
    }


}
