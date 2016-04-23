package logistics.itemservice;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.Loader;
import logistics.utilities.loader.factory.LoaderFactory;

import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class ItemCatalogService {

    private volatile static ItemCatalogService instance;
    private Loader loader;
    private ArrayList<Item> items = new ArrayList<>();

    private ItemCatalogService() {
            LoaderFactory loaderFactory = LoaderFactory.getLoaderFactory("item");
            loader = loaderFactory.createLoader("xml", "data/item_catalog.xml");

            try {
                items = loader.load();
            } catch (LoaderFileNotFoundException e) {
                e.printStackTrace();
            }

//         For debugging:
//            int i = 1;
//            for (Item item : items) {
//                System.out.println("No " + i + " Item id: " + item.getId() + " Item price: " + item.getPrice());
//                i++;
//            }
    }

    public static ItemCatalogService getInstance() {
        if (instance == null){
            synchronized (ItemCatalogService.class){
                if (instance == null){
                    instance = new ItemCatalogService();
                }
            }
        }

        return instance;
    }


    public ItemDTO getItem(int i){
        Item item = items.get(i);
        if (item == null) return null;
        return new ItemDTO(item.getId(), item.getPrice());
    }

    public static void main(String[] args){

        ItemCatalogService itemCatalogService = ItemCatalogService.getInstance();
        ItemDTO itemDTO = itemCatalogService.getItem(0);
        System.out.println("Please get first item");
        System.out.println(" Item id: " + itemDTO.id + " Item price: " + itemDTO.price);

    }

}
