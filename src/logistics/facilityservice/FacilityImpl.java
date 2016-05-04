package logistics.facilityservice;

import logistics.utilities.exceptions.NullParameterException;

/**
 * @author David Olorundare and uchenna f. okoye
 */
public class FacilityImpl implements Facility
{
    private String name;
    private Integer rate;
    private Double cost;

    public FacilityImpl(String name, Integer rate, Double cost) throws NullParameterException
    {
        setName(name);
        setRate(rate);
        setCost(cost);
    }

	public String getName() {
		return name;
	}

	public Integer getRate()
	{
		return rate;
	}


	public Double getCost()
	{
		return cost;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(name);
		stringBuffer.append("\n");
		stringBuffer.append("Rate per Day: " + rate);
		stringBuffer.append("\n");
		stringBuffer.append("Cost per day: " + cost);
		stringBuffer.append("\n");
		return stringBuffer.toString();
	}

	private void setName(String facilityName) throws NullParameterException
	{
		validateName(facilityName);
		name = facilityName;
	}

	private void setRate(Integer facilityRate) throws NullParameterException
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

	private void validateRate(Integer rate) throws NullParameterException {
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
