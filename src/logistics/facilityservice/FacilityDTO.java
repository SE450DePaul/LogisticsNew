package logistics.facilityservice;

/**
 * @author David Olorundare
 */
public class FacilityDTO
{

    public String name;
    public Double cost;
    public Integer rate;

    public FacilityDTO(String facilityName, Double facilityCost, Integer facilityRate)
    {
        name = facilityName;
        cost = facilityCost;
        rate = facilityRate;
    }


}
