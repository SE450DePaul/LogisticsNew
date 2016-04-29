package logistics.facilityservice;

/**
 * @author David Olorundare
 */
public class FacilityDTO
{

    public String name;
    public Double cost;
    public Double rate;

    public FacilityDTO(String facilityName, Double facilityCost, Double facilityRate)
    {
        name = facilityName;
        cost = facilityCost;
        rate = facilityRate;
    }


}
