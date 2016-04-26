package logistics.facilityservice.inventory;

/**
 * @author David Olorundare
 */
public class InventoryDTO
{

    public String id;
    public int quantity;

    public InventoryDTO(String id, int quantity)
    {
        this.id = id;
        this.quantity = quantity;
    }
}
