package logistics.inventoryservice;

import logistics.utilities.exceptions.NullParameterException;

import java.util.HashMap;
import java.util.Set;

/**
 * @author uchenna f. okoye
 */
public class InventoryImpl implements Inventory
{

	private HashMap<String, Integer> activeItemHash;
	private HashMap<String, Integer> depletedItemHash;
	private String facilityName;

	public InventoryImpl(String facilityName) throws NullParameterException {
		setFacilityName(facilityName);
		activeItemHash = new HashMap<>();
		depletedItemHash = new HashMap<>();
	}

	private void setFacilityName(String nameOfFacility) throws NullParameterException {
		validateFacility(nameOfFacility);
		facilityName = nameOfFacility;
	}

	@Override
	public void updateInventory(String itemId, int quantity) throws NullParameterException {
		validateItem(itemId);
		validateQuantity(quantity);
		updateInventoryHelper(itemId, quantity);
	}

	@Override
	public void addInventoryItem(String itemId, int quantity) throws NullParameterException {
		validateItem(itemId);
		validateQuantity(quantity);
		updateInventoryHelper(itemId, quantity);
	}

	@Override
	public Integer getQuantity(String itemId) {
		return activeItemHash.get(itemId);
	}

	public String getFacilityName() {
		return facilityName;
	}

	@Override
	public String getInventoryOutput() {

		Set<String> activeItems = activeItemHash.keySet();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\n");
		stringBuffer.append("Active Inventory: ");
		stringBuffer.append("\n");
		stringBuffer.append("\tItem Id\t\tQuantity");

		if (activeItems.isEmpty()){
			stringBuffer.append("None");
		}

		for (String item : activeItems){
			int quantity = activeItemHash.get(item);
			stringBuffer.append("\n");
			stringBuffer.append("\t" + item + "\t\t" + quantity);
		}

		stringBuffer.append("\n\n");
		stringBuffer.append("Depleted (Used-Up) Inventory: ");

		Set<String> depletedItems = depletedItemHash.keySet();
		if (depletedItems.isEmpty()){
			stringBuffer.append("None");
		}

		for (String item : depletedItems){
			stringBuffer.append("\n");
			stringBuffer.append("\t" + item);
		}


		return stringBuffer.toString();
	}

	private void updateInventoryHelper(String itemId, int quantity) {
		if (quantity == 0) {
			activeItemHash.remove(itemId);
			depletedItemHash.put(itemId, quantity);
		} else {
			activeItemHash.put(itemId, quantity);
			depletedItemHash.remove(itemId);
		}
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
