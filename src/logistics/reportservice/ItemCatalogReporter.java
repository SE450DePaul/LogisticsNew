package logistics.reportservice;

/**
 * This class represents a ItemCatalog implementation which
 * prints out the current status of the Item Catalog .
 * 
 * @author Uchenna F. Okoye
 */

import logistics.itemservice.ItemCatalogService;

public class ItemCatalogReporter implements Reporter {


    private volatile static ItemCatalogReporter instance;
    ItemCatalogService itemCatalogService;

    private ItemCatalogReporter() {

        itemCatalogService = ItemCatalogService.getInstance();
    }

    /*
     * Returns an instance of the ItemCatalog Reporter.
     */
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

    /*
     * Returns the status of the Item Catalog.
     */
    public void printOutput() {
        System.out.println(itemCatalogService.getOutput());
    }
}
