package logistics.inventoryservice.inventoryitem;

/**
 * @author David Olorundare
 */
public class InventoryItemDTO
{
    public String id;
    public int quantity;

    public InventoryItemDTO(String id, int quantity)
    {
        this.id = id;
        this.quantity = quantity;
    }
}
