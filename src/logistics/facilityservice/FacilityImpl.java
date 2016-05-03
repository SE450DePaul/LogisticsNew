package logistics.facilityservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * @authors David Olorundare and Uchenna F. Okoye
 */
public class FacilityImpl implements Facility
{
    private String facilityName;
    private Integer facilityRate;
    private Double facilityCost;

    public FacilityImpl(String name, Integer rate, Double cost) throws NullParameterException
    {
        setFacilityName(name);
        setFacilityRate(rate);
        setFacilityCost(cost);
    }

	public String getFacilityName() 
	{
		return facilityName;
	}

	public Integer getFacilityRate() 
	{
		return facilityRate;
	}

	public Double getFacilityCost()
	{
		return facilityCost;
	}

	private void setFacilityName(String name) throws NullParameterException
	{
		validateFacilityName(name);
		facilityName = name;
	}

	private void setFacilityRate(Integer rate) throws NullParameterException
	{
		validateFacilityRate(rate);
		facilityRate = rate;
	}

	private void setFacilityCost(Double cost) throws NullParameterException
	{
		validateFacilityCost(cost);
		facilityCost = cost;
	}

	private void validateFacilityName(String name) throws NullParameterException 
	{
		if (name == null)
		{
			throw new NullParameterException("Facility Name cannot be null");
		}
	}

	private void validateFacilityRate(Integer rate) throws NullParameterException 
	{
		if (rate == null)
		{
			throw new NullParameterException("Facility Rate cannot be null");
		}
	}

	private void validateFacilityCost(Double cost) throws NullParameterException 
	{
		if (cost == null)
		{
			throw new NullParameterException("Facility Cost cannot be null");
		}
	}
}
