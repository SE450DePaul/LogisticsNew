package logistics.utilities.loader.implementation;


import logistics.orderservice.dtos.OrderItemRequestDTO;
import logistics.orderservice.dtos.OrderRequestDTO;
import logistics.utilities.exceptions.IllegalParameterException;
import logistics.utilities.exceptions.LoaderFileNotFoundException;
import logistics.utilities.exceptions.NegativeOrZeroParameterException;
import logistics.utilities.exceptions.NullParameterException;
import logistics.utilities.loader.interfaces.OrderLoader;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by uchennafokoye on 4/22/16.
 */
public class OrderXmlLoaderImpl implements OrderLoader {

    private String filepath;

    public OrderXmlLoaderImpl(String itemFilepath){
        filepath = itemFilepath;
    }

    public ArrayList<OrderRequestDTO> load() throws LoaderFileNotFoundException {

        ArrayList<OrderRequestDTO> orderRequests = new ArrayList<>();

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
                if (!entryName.equals("order")) {
                    continue;
                }

                NamedNodeMap attributes = node.getAttributes();
                Node namedItem = attributes.getNamedItem("id");
                String orderId = namedItem.getNodeValue();
                Element element = (Element) itemEntries.item(i);
                String destination = element.getElementsByTagName("destination").item(0).getTextContent();
                String orderDayString = element.getElementsByTagName("day").item(0).getTextContent();
                int orderDay = Integer.parseInt(orderDayString);

                NodeList itemNodes = element.getElementsByTagName("item");
                ArrayList<OrderItemRequestDTO> collection = new ArrayList<>();

                for (int j = 0; j < itemNodes.getLength(); j++){

                    node = itemNodes.item(j);
                    if (node.getNodeType() == Node.TEXT_NODE){
                        continue;
                    }

                    entryName = node.getNodeName();
                    if (!entryName.equals("item")){
                        continue;
                    }

                    element = (Element) itemNodes.item(j);
                    String itemId = element.getElementsByTagName("id").item(0).getTextContent();
                    String quantityString = element.getElementsByTagName("quantity").item(0).getTextContent();
                    int quantity = Integer.parseInt(quantityString);
                    collection.add(new OrderItemRequestDTO(destination, itemId, orderDay, quantity));

                    
                    /*FOR TESTING ONLY:
                    System.out.println("Order Destination: " + destination + " Item ID: " + itemId + " Order Day: " + orderDay + " Quantity: " + quantity);
                    for (OrderItemRequestDTO thingy : collection)
                    {
                    	System.out.println(thingy.getDestination() + " " + thingy.getItemId() + " " + thingy.getStartTime() + " " + thingy.getQuantityNeeded() + " \n");
                    }*/
                }

                
                OrderRequestDTO orderRequestDTO = new OrderRequestDTO(orderId, destination, orderDay, collection);
                orderRequests.add(orderRequestDTO);
            }



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullParameterException e)
        {
        	e.printStackTrace();
        }
        catch (IllegalParameterException e)
        {
        	e.printStackTrace();
        }
       


        return orderRequests;
    }



    public static void main(String[] args){

        OrderXmlLoaderImpl xmlLoader =  new OrderXmlLoaderImpl("data/orders.xml");
        try {
            xmlLoader.load();
        } catch (LoaderFileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
