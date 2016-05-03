package logistics.facilityservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * @author David Olorundare and uchenna f. okoye
 */
public class FacilityImpl implements Facility
{
    private String name;
    private Double rate;
    private Double cost;

    public FacilityImpl(String name, Double rate, Double cost) throws NullParameterException
    {
        setName(name);
        setRate(rate);
        setCost(cost);
    }

	public String getName() {
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

	private void setName(String facilityName) throws NullParameterException
	{
		validateName(facilityName);
		name = facilityName;
	}

	private void setRate(Double facilityRate) throws NullParameterException
	{
		validateRate(facilityRate);
		rate = facilityRate;
	}

	private void setCost(Double facilityCost) throws NullParameterException
	{
		validateCost(facilityCost);
		cost = facilityCost;
	}

	private void validateName(String name) throws NullParameterException {
		if (name == null){
			throw new NullParameterException();
		}
	}

	private void validateRate(Double rate) throws NullParameterException {
		if (rate == null){
			throw new NullParameterException();
		}
	}

	private void validateCost(Double cost) throws NullParameterException {
		if (cost == null){
			throw new NullParameterException();
		}
	}




}
