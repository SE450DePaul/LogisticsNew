package logistics.inventoryservice;

/**
 * @author David Olorundare
 */
public class InventoryImpl implements Inventory
{
    private String facilityName;
    private String inventoryId;
    private int inventoryQuantity;

    public InventoryImpl(String name, String invenId, int invenQuantity)
    {
        setName(name);
        setItemId(invenId);
        setQuantity(invenQuantity);
    }

  
	public void setName(String name) 
	{
		facilityName = name;
		
	}

	public String getName() 
	{
		return facilityName;
	}

	public void setQuantity(int quantity) 
	{
		inventoryQuantity = quantity;
		
	}

	public int getQuantity() 
	{
		return inventoryQuantity;
	}

	public void setItemId(String itemId) 
	{
		inventoryId = itemId;
		
	}

	public String getItemId() 
	{
		return inventoryId;
	}
}
