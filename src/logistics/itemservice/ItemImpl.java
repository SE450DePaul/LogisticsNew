package logistics.itemservice;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class ItemImpl implements Item
{
    private String id;
    private Double price;

    public ItemImpl(String id, Double price){
        setId(id);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
