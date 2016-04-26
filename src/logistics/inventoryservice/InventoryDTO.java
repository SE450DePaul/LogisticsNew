package logistics.inventoryservice;

/**
 * @author David Olorundare
 */
public class InventoryDTO
{

    public String id;
    public Double price;

    public InventoryDTO(String id, Double price)
    {
        this.id = id;
        this.price = price;
    }
}
