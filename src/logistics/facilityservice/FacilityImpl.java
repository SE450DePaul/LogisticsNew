package logistics.facilityservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * @author David Olorundare and Uchenna F. Okoye
 */
public class FacilityImpl implements Facility
{
    private String name;
    private Double rate;
    private Double cost;

    public FacilityImpl(String name, Double rate, Double cost) throws IllegalParameterException
    {
        setName(name);
        setRate(rate);
        setCost(cost);
    }

	public String getName() 
	{
		return name;
	}

	public Double getRate() 
	{
		return rate;
	}


	public Double getCost()
	{
		return cost;
	}

	private void setName(String facilityName) throws IllegalParameterException
	{
		validateName(facilityName);
		name = facilityName;
	}

	private void setRate(Double facilityRate) throws IllegalParameterException
	{
		validateRate(facilityRate);
		rate = facilityRate;
	}

	private void setCost(Double facilityCost) throws IllegalParameterException
	{
		validateCost(facilityCost);
		cost = facilityCost;
	}

	private void validateName(String name) throws IllegalParameterException 
	{
		if (name == null)
		{
			throw new IllegalParameterException();
		}
	}

	private void validateRate(Double rate) throws IllegalParameterException 
	{
		if (rate == null)
		{
			throw new IllegalParameterException();
		}
	}

	private void validateCost(Double cost) throws IllegalParameterException 
	{
		if (cost == null)
		{
			throw new IllegalParameterException();
		}
	}




}
