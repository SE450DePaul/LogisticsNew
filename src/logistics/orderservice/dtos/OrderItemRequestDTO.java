package logistics.orderservice.dtos;

/**
 * This class represents an Order Request DTO
 * which is used to transfer the Order Request
 * with other subsystems of the Logistics application.
 * 
 * @author Uchenna F. Okoye
 */
public class OrderItemRequestDTO {

    public String destination;
    public String itemId;
    public int startTime;
    public int quantityNeeded;


   public OrderItemRequestDTO(String destination, String itemId, int startTime, int quantityNeeded) {
        this.destination = destination;
        this.itemId = itemId;
        this.startTime = startTime;
        this.quantityNeeded = quantityNeeded;
    }
}
