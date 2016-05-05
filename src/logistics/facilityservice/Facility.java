package logistics.facilityservice;

/**
 * This class represents a Facility Factory, which handles object creation 
 * of new Facility Implementation classes.
 * 
 * @author David Olorundare
 */

public interface Facility
{
    String getName();
    Integer getRate();
    Double getCost();
    String toString();
}
