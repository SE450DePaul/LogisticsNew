package logistics.itemservice;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public interface Item
{

    void setId(String id);
    String getId();
    // made a change here
    void setPrice(Double price);
    Double getPrice();

}
