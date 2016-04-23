package logistics.itemservice;

/**
 * Created by uchennafokoye on 4/23/16.
 */
public class ItemFactory {

    public static Item build(String id, Double price){
        return new ItemImpl(id, price);
    }
}
