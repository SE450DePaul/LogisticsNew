package logistics.facilityservice;

import logistics.facilityservice.inventory.Inventory;
import logistics.itemservice.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author David Olorundare
 */
public class FacilityImpl implements Facility
{
    private String facilityName;
    private Double facilityRate;
    private Double facilityCost;
	private HashMap<String, Inventory> inventories;

    public FacilityImpl(String name, Double rate, Double cost, ArrayList<Inventory> inventory_list)
    {
        setName(name);
        setRate(rate);
        setCost(cost);
		inventories = new HashMap<>();
		setInventories(inventory_list);
    }

	public void setName(String name) 
	{
		facilityName = name;
	}

	public String getName() 
	{
		return facilityName;
	}

	public void setRate(Double rate) 
	{
		facilityRate = rate;
	}

	public Double getRate() 
	{
		return facilityRate;
	}
	
	public void setCost(Double cost) 
	{
		facilityCost = cost;
	}

	public Double getCost()
	{
		return facilityCost;
	}

	public void setInventories(ArrayList<Inventory> inventory_list){
		for (Inventory i : inventory_list){

			inventories.put(i.getItemId(), i);

		}
	}

	public int getQuantity(String itemId){
		Inventory inventory = inventories.get(itemId);
		if (inventory == null) {
			return -1;
		} else {
			return inventory.getQuantity();
		}
	}



}
