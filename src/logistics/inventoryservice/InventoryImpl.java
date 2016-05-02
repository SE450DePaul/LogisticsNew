package logistics.inventoryservice;

import logistics.utilities.exceptions.IllegalParameterException;

import java.util.HashMap;
import java.util.Set;

/**
 * @author Uchenna F. Okoye and David Olorundare
 */
public class InventoryImpl implements Inventory
{
	private HashMap<String, Integer> inventoryHash;
	private String facilityName;

	public InventoryImpl(String facilityName) throws IllegalParameterException 
	{
		setFacilityName(facilityName);
		inventoryHash = new HashMap<>();
	}

	private void setFacilityName(String nameOfFacility) throws IllegalParameterException 
	{
		validateFacility(nameOfFacility);
		facilityName = nameOfFacility;
	}

	public void updateInventory(String itemId, int quantity) throws IllegalParameterException 
	{
		validateItem(itemId);
		validateQuantity(quantity);
		inventoryHash.put(itemId, quantity);
	}

	public void addInventoryItem(String itemId, int quantity) throws IllegalParameterException 
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

	public String getInventoryOutput() 
	{
		Set<String> items = inventoryHash.keySet();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Active Inventory: ");
		stringBuffer.append("\n");
		stringBuffer.append("\tItem Id\tQuantity");
		for (String item : items)
		{
			int quantity = inventoryHash.get(item);
			stringBuffer.append("\n");
			stringBuffer.append("\t" + item + "\t" + quantity);
		}
		stringBuffer.append("\n\n");
		stringBuffer.append("Depleted (Used-Up) Inventory: None");
		return stringBuffer.toString();
	}

	private void validateFacility(String facilityName) throws IllegalParameterException 
	{
		if (facilityName == null)
		{
			throw new IllegalParameterException();
		}
	}

	private void validateQuantity(int quantity) throws IllegalParameterException 
	{
		if (quantity < 0)
		{
			throw new IllegalParameterException();
		}
	}

	private void validateItem(String itemId) throws IllegalParameterException 
	{
		if (itemId == null)
		{
			throw new IllegalParameterException();
		}
	}
}
