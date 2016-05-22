package logistics.orderservice.dtos;

import java.util.Collection;

/**
 * This class represents an Order Request DTO
 * which is used to transfer the Order Request
 * with other subsystems of the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */
public class OrderRequestDTO {

    public String orderId;
    public String destination;
    public int startTime;
    public Collection<OrderItemRequestDTO> orderItemRequestDTOs;


   public OrderRequestDTO(String orderId, String destination, int startTime, Collection<OrderItemRequestDTO> itemRequestDTOS) {
        this.orderId = orderId;
        this.destination = destination;
        this.startTime = startTime;
        this.orderItemRequestDTOs = itemRequestDTOS;
    }
}
