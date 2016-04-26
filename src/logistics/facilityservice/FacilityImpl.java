package logistics.facilityservice;

import logistics.facilityservice.inventory.Inventory;
import logistics.utilities.exceptions.IllegalParameterException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author David Olorundare
 */
public class FacilityImpl implements Facility
{
    private String name;
    private Double facilityRate;
    private Double facilityCost;
	private HashMap<String, Inventory> inventories;

    public FacilityImpl(String name, Double rate, Double cost, ArrayList<Inventory> inventory_list) throws IllegalParameterException
    {
        setName(name);
        setRate(rate);
        setCost(cost);
		inventories = new HashMap<>();
		setInventories(inventory_list);
    }

	public void setName(String name) throws IllegalParameterException
	{
		if (name == null){
			throw new IllegalParameterException();
		}
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}

	public void setRate(Double rate) throws IllegalParameterException
	{
		if (rate == null){
			throw new IllegalParameterException();
		}
		facilityRate = rate;
	}

	public Double getRate() 
	{
		return facilityRate;
	}
	
	public void setCost(Double cost) throws IllegalParameterException
	{
		if (cost == null){
			throw new IllegalParameterException();
		}
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
