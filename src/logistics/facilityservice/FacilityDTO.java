package logistics.facilityservice;

/**
 * @author David Olorundare
 */
public class FacilityDTO
{
    public String facilityName;
    public Double facilityCost;
    public Double facilityRate;

    public FacilityDTO(String name, Double cost, Double rate)
    {
        facilityName = name;
        facilityCost = cost;
        facilityRate = rate;
    }
}
