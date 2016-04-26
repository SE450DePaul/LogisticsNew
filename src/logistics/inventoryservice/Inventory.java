package logistics.inventoryservice;

/**
 * @author David Olorundare
 */
public interface Inventory
{

    void setName(String name);
    String getName();
    void setItemId(String itemId);
    String getItemId();
    void setQuantity(int quantity);
    int getQuantity();

}
