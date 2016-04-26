package logistics.facilityservice;

/**
 * @author David Olorundare
 */
public interface Facility
{

    void setName(String name);
    String getName();
    void setRate(Double rate);
    Double getRate();
    void setCost(Double cost);
    Double getCost();
    int getQuantity(String itemId);

}
