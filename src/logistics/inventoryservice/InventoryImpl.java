package logistics.inventoryservice;

import logistics.utilities.exceptions.NullParameterException;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Uchenna F. Okoye
 */
public class InventoryImpl implements Inventory
{
	private HashMap<String, Integer> inventoryHash;
	private String facilityName;

	public InventoryImpl(String facilityName) throws NullParameterException 
	{
		setFacilityName(facilityName);
		inventoryHash = new HashMap<>();
	}

	private void setFacilityName(String nameOfFacility) throws NullParameterException 
	{
		validateFacility(nameOfFacility);
		facilityName = nameOfFacility;
	}

	public void updateInventory(String itemId, int quantity) throws NullParameterException 
	{
		validateItem(itemId);
		validateQuantity(quantity);
		inventoryHash.put(itemId, quantity);
	}

	public void addInventoryItem(String itemId, int quantity) throws NullParameterException 
	{
		validateItem(itemId);
		validateQuantity(quantity);
		inventoryHash.put(itemId, quantity);
	}

	public Integer getQuantity(String itemId) 
	{
		return inventoryHash.get(itemId);
	}

	public String getFacilityName() 
	{
		return facilityName;
	}

	// schedule service needs to calculate amount depleted
	public String getInventoryOutput() 
	{
		Set<String> items = inventoryHash.keySet();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\nActive Inventory: ");
		stringBuffer.append("\n");
		stringBuffer.append("\tItem Id\tQuantity");
		for (String item : items)
		{
			int quantity = inventoryHash.get(item);
			stringBuffer.append("\n");
			stringBuffer.append("\t" + item + "\t" + quantity);
		}
		stringBuffer.append("\n\n");
		stringBuffer.append("Depleted (Used-Up) Inventory: None\n");
		return stringBuffer.toString();
	}

	private void validateFacility(String facilityName) throws NullParameterException 
	{
		if (facilityName == null)
		{
			throw new NullParameterException("Facility Name cannot be null");
		}
	}

	private void validateQuantity(int quantity) throws NullParameterException 
	{
		if (quantity < 0)
		{
			throw new NullParameterException("Quantity cannot be null");
		}
	}

	private void validateItem(String itemId) throws NullParameterException 
	{
		if (itemId == null)
		{
			throw new NullParameterException("Item ID cannot be null");
		}
	}
}
