package logistics.facilityservice.inventory;

/**
 * @author David Olorundare
 */
public interface Inventory
{
   void setItemId(String itemId);
    String getItemId();
    void setQuantity(int quantity);
    int getQuantity();

}
