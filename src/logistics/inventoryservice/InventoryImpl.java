package logistics.inventoryservice;

import logistics.itemservice.Item;
import logistics.utilities.exceptions.IllegalParameterException;

import java.util.HashMap;

/**
 * @author uchenna f. okoye and David Olorundare
 */
public class InventoryImpl implements Inventory
{

	private HashMap<String, Integer> inventoryHash;
	private String facilityName;

	public InventoryImpl(String facilityName) throws IllegalParameterException {
		setFacilityName(facilityName);
		inventoryHash = new HashMap<>();
	}

	private void setFacilityName(String nameOfFacility) throws IllegalParameterException {
		validateFacility(nameOfFacility);
		facilityName = nameOfFacility;
	}

	@Override
	public void updateInventory(String itemId, int quantity) throws IllegalParameterException {
		validateItem(itemId);
		validateQuantity(quantity);
		inventoryHash.put(itemId, quantity);
	}

	@Override
	public void addInventoryItem(String itemId, int quantity) throws IllegalParameterException {
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

	private void validateFacility(String facilityName) throws IllegalParameterException {
		if (facilityName == null){
			throw new IllegalParameterException();
		}
	}

	private void validateQuantity(int quantity) throws IllegalParameterException {
		if (quantity < 0){
			throw new IllegalParameterException();
		}
	}

	private void validateItem(String itemId) throws IllegalParameterException {
		if (itemId == null){
			throw new IllegalParameterException();
		}
	}
}
