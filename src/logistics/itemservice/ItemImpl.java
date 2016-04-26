package logistics.itemservice;

import logistics.utilities.exceptions.IllegalParameterException;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class ItemImpl implements Item
{
    private String id;
    private Double price;

    public ItemImpl(String id, Double price) throws IllegalParameterException {
        setId(id);
        setPrice(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalParameterException{
        if (id == null){
            throw new IllegalParameterException();
        }
        this.id = id;
    }

    public void setPrice(Double price) throws IllegalParameterException{
        if (price == null){
            throw new IllegalParameterException("Price cannot be null");
        }
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
