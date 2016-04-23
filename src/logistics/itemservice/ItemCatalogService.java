package logistics.itemservice;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public final class ItemCatalogService {

    private volatile static ItemCatalogService instance;
//    private Loader loader;

    private ItemCatalogService() {
//           loader = LoaderFactory.build("item", "xml");
//           Item[] items = loader.load(file);
//            ItemDTO itemDTO = new ItemDTO(items);
    }

    public ItemCatalogService getInstance() {
        if (instance == null){
            synchronized (ItemCatalogService.class){
                if (instance == null){
                    instance = new ItemCatalogService();
                }
            }
        }

        return instance;
    }

}
