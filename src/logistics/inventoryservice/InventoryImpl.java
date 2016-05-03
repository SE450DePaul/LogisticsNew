package logistics.inventoryservice;

import logistics.utilities.exceptions.NullParameterException;

import java.util.HashMap;
import java.util.Set;

/**
 * @author uchenna f. okoye
 */
public class InventoryImpl implements Inventory
{

	private HashMap<String, Integer> inventoryHash;
	private String facilityName;

	public InventoryImpl(String facilityName) throws NullParameterException {
		setFacilityName(facilityName);
		inventoryHash = new HashMap<>();
	}

	private void setFacilityName(String nameOfFacility) throws NullParameterException {
		validateFacility(nameOfFacility);
		facilityName = nameOfFacility;
	}

	@Override
	public void updateInventory(String itemId, int quantity) throws NullParameterException {
		validateItem(itemId);
		validateQuantity(quantity);
		inventoryHash.put(itemId, quantity);
	}

	@Override
	public void addInventoryItem(String itemId, int quantity) throws NullParameterException {
		validateItem(itemId);
		validateQuantity(quantity);
		inventoryHash.put(itemId, quantity);
	}

	@Override
	public Integer getQuantity(String itemId) {
		return inventoryHash.get(itemId);
	}

	public String getFacilityName() {
		return facilityName;
	}

	@Override
	public String getInventoryOutput() {

		Set<String> items = inventoryHash.keySet();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Active Inventory: ");
		stringBuffer.append("\n");
		stringBuffer.append("\tItem Id\tQuantity");
		for (String item : items){
			int quantity = inventoryHash.get(item);
			stringBuffer.append("\n");
			stringBuffer.append("\t" + item + "\t" + quantity);
		}
		stringBuffer.append("\n\n");
		stringBuffer.append("Depleted (Used-Up) Inventory: None");
		return stringBuffer.toString();
	}

	private void validateFacility(String facilityName) throws NullParameterException {
		if (facilityName == null){
			throw new NullParameterException();
		}
	}

	private void validateQuantity(int quantity) throws NullParameterException {
		if (quantity < 0){
			throw new NullParameterException();
		}
	}

	private void validateItem(String itemId) throws NullParameterException {
		if (itemId == null){
			throw new NullParameterException();
		}
	}
}
