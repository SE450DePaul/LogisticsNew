package logistics.reportservice;

import logistics.itemservice.ItemCatalogService;


public class ItemCatalogReporter implements Reporter {


    private volatile static ItemCatalogReporter instance;
    ItemCatalogService itemCatalogService;


    private ItemCatalogReporter() {

        itemCatalogService = itemCatalogService.getInstance();
    }

    public static ItemCatalogReporter getInstance()
    {
        if (instance == null)
        {
            synchronized (ItemCatalogReporter.class)
            {
                if (instance == null)
                {
                    instance = new ItemCatalogReporter();
                }
            }
        }
        return instance;
    }


    public void printOutput() {
    	itemCatalogService.getOutput();
    }




}
