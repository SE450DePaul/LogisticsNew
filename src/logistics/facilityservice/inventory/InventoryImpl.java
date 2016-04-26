package logistics.facilityservice.inventory;

/**
 * @author David Olorundare
 */
public class InventoryImpl implements Inventory
{
    private String itemId;
    private int quantity;

    public InventoryImpl(String itemId, int quantity)
    {
        setItemId(itemId);
        setQuantity(quantity);
    }


	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
		
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setItemId(String itemId) 
	{
		this.itemId = itemId;
		
	}

	public String getItemId() 
	{
		return itemId;
	}
}
