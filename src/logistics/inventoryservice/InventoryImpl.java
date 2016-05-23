package logistics.inventoryservice;

import logistics.utilities.exceptions.NegativeOrZeroParameterException;

/**
 * This class represents the implementation of an Inventory of a given Facility.
 * 
 * The class provides methods for creating an inventory for a given
 * Facility, adding new items to the inventory, updating pre-existing
 * items in an old inventory, and listing all inventories held by the
 * Facility. 
 * 
 * @author Uchenna F. Okoye
 */

import logistics.utilities.exceptions.NullParameterException;
import java.util.HashMap;
import java.util.Set;


public class InventoryImpl implements Inventory
{

	private HashMap<String, Integer> activeItemHash;
	private HashMap<String, Integer> depletedItemHash;
	private String facilityName;

	/*
     * Creates a new Inventory for a given Facility.
     */
	public InventoryImpl(String facilityName) throws NullParameterException {
		setFacilityName(facilityName);
		activeItemHash = new HashMap<>();
		depletedItemHash = new HashMap<>();
	}

	/*
	 * Helper method that sets a Facility's Name.
	 */
	private void setFacilityName(String nameOfFacility) throws NullParameterException {
		validateFacility(nameOfFacility);
		facilityName = nameOfFacility;
	}

	/*
	 * Updates a Facility's Inventory with a new Item and its quantity.
	 * 
	 */
	public void updateInventory(String itemId, int quantity) throws NullParameterException, NegativeOrZeroParameterException {
		validateItem(itemId);
		validateQuantity(quantity);
		updateInventoryHelper(itemId, quantity);
	}

	/*
	 * Adds a new Item to a Facility's Inventory given
	 * an item ID and quantity.
	 */
	public void addInventoryItem(String itemId, int quantity) throws NullParameterException, NegativeOrZeroParameterException {
		validateItem(itemId);
		validateQuantity(quantity);
		updateInventoryHelper(itemId, quantity);
	}

	/*
	 * Helper method that returns a Facility Inventory's item quantity
	 * given an item ID.
	 */
	public Integer getQuantity(String itemId) {
		return activeItemHash.get(itemId);
	}

	/*
	 * Helper method that returns a Facility's Name.
	 */
	public String getFacilityName() {
		return facilityName;
	}

	/*
	 * Displays the Active Inventory details of a Facility,
	 * showing the Items currently present in the inventory, 
	 * its Quantity, as well as the total quantity of Items
	 *  that have already been used up.
	 */
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

	/*
	 * Updates the Active Inventory of a Facility with a given Item and its Quantity.
	 */
	private void updateInventoryHelper(String itemId, int quantity) {
		if (quantity == 0) {
			activeItemHash.remove(itemId);
			depletedItemHash.put(itemId, quantity);
		} else {
			activeItemHash.put(itemId, quantity);
			depletedItemHash.remove(itemId);
		}
	}

	/*
	 * Validates that a Facility's name is not Null.
	 */
	private void validateFacility(String facilityName) throws NullParameterException {
		if (facilityName == null){
			throw new NullParameterException("Facility Name cannot be Null");
		}
	}

	/*
	 * Validates that a Facility's inventory quantity is not less than zero.
	 */
	private void validateQuantity(int quantity) throws NegativeOrZeroParameterException {
		if (quantity < 0){
			throw new NegativeOrZeroParameterException("Quantity cannot be Negative");
		}
	}

	/*
	 * Validates that a Facility's inventory-item name is not Null.
	 */
	private void validateItem(String itemId) throws NullParameterException {
		if (itemId == null){
			throw new NullParameterException("Item ID cannot be Null");
		}
	}
}
