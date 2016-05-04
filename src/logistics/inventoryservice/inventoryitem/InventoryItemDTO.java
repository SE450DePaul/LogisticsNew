package logistics.inventoryservice.inventoryitem;

/**
 * @author David Olorundare
 */
public class InventoryItemDTO
{

    public String id;
    public int quantity;

    public InventoryItemDTO(String itemId, int itemQuantity)
    {
        id = itemId;
        quantity = itemQuantity;
    }
}
