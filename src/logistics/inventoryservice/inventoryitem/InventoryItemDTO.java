package logistics.inventoryservice.inventoryitem;

/**
 * @author David Olorundare
 */
public class InventoryItemDTO
{
    public String inventoryId;
    public int inventoryQuantity;

    public InventoryItemDTO(String id, int quantity)
    {
        inventoryId = id;
        inventoryQuantity = quantity;
    }
}
