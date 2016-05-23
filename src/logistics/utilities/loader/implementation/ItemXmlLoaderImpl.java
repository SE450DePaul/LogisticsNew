package logistics.utilities.loader.implementation;

/**
* This class represents the implementation of an Item XML Loader
* which loads in XML data, containing details of various Items, into
* the Logistics application.
*
* @author Uchenna F. Okoye
*
*/

import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.itemservice.Item;
import logistics.itemservice.ItemFactory;
import logistics.utilities.loader.interfaces.ItemLoader;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ItemXmlLoaderImpl implements ItemLoader {

    private String filepath;

    /*
	 * Takes as input the filesystem path to the XML data. 
	 */
    public ItemXmlLoaderImpl(String itemFilepath){
        filepath = itemFilepath;
    }

	/*
 	 * Returns a list of Items loaded from the XML data.
 	 */
    public ArrayList<Item> load() throws LoaderFileNotFoundException {

        ArrayList<Item> items = new ArrayList<Item>();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            File xml = new File(filepath);
            if (!xml.exists()) {
                throw new LoaderFileNotFoundException();
            }

            Document doc = db.parse(xml);
            Element documentElement = doc.getDocumentElement();
            documentElement.normalize();

            NodeList itemEntries = documentElement.getChildNodes();
            for (int i = 0; i < itemEntries.getLength(); i++) {
                Node node = itemEntries.item(i);
                if (node.getNodeType() == Node.TEXT_NODE) {
                    continue;
                }

                String entryName = node.getNodeName();
                if (!entryName.equals("item")) {
                    continue;
                }

                NamedNodeMap attributes = node.getAttributes();
                Node namedItem = attributes.getNamedItem("id");
                String id = namedItem.getNodeValue();
                Element element = (Element) itemEntries.item(i);
                NodeList priceNode = element.getElementsByTagName("price");
                Double price = Double.parseDouble(priceNode.item(0).getTextContent());

                Item item = ItemFactory.build(id, price);

             // Must be uncommented if this class is to be run from its main() method.
                 System.out.println("No " + i + ": Item price: " + price + " Item Id: " + id);
                items.add(item);

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullParameterException e) {
            e.printStackTrace();
        }

        return items;
    }

    // Test that the class works.
    public static void main(String[] args){

        ItemXmlLoaderImpl xmlLoader =  new ItemXmlLoaderImpl("data/item_catalog.xml");
        try {
            xmlLoader.load();
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
