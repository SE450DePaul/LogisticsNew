package logistics.facilityservice;

/**
 * @author David Olorundare
 */
public class FacilityDTO
{
    public String facilityName;
    public Double facilityCost;
    public Integer facilityRate;

    public FacilityDTO(String name, Double cost, Integer rate)
    {
        facilityName = name;
        facilityCost = cost;
        facilityRate = rate;
    }
}
