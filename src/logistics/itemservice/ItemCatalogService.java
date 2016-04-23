package logistics.itemservice;

import logistics.exceptions.LoaderFileNotFoundException;
import logistics.utilities.loader.ItemLoaderFactory;
import logistics.utilities.loader.Loader;
import logistics.utilities.loader.LoaderFactory;

import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class ItemCatalogService {

    private volatile static ItemCatalogService instance;
    private Loader loader;

    private ItemCatalogService(LoaderFactory loaderFactory) {
            loader = loaderFactory.createLoader("xml", "data/item_catalog.xml");
            ArrayList<Item> items = new ArrayList<Item>();
            try {
                items = loader.load();
            } catch (LoaderFileNotFoundException e) {
                e.printStackTrace();
            }

            int i = 1;
            for (Item item : items) {
                System.out.println("No " + i + " Item id: " + item.getId() + " Item price: " + item.getPrice());
                i++;
            }

//            ItemDTO itemDTO = new ItemDTO(items);
    }

    public static ItemCatalogService getInstance() {
        if (instance == null){
            synchronized (ItemCatalogService.class){
                if (instance == null){
                    instance = new ItemCatalogService(new ItemLoaderFactory());
                }
            }
        }

        return instance;
    }


    public static void main(String[] args){

        ItemCatalogService itemCatalogService = ItemCatalogService.getInstance();

    }

}
