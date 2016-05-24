package logistics.orderservice.order;

/**
 * This class represents a Facility Factory, which handles object creation 
 * of new Facility Implementation classes.
 * 
 * @author Uchenna F.okoye
 */

import logistics.orderservice.dtos.OrderRequestDTO;

public class OrderFactory {
    public static Order build(OrderRequestDTO orderRequestDTO) {
        return new OrderImpl(orderRequestDTO);
    }
}
