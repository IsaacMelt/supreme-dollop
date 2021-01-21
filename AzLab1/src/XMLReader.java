import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XMLReader {
    public static void main(String[] args){
        try {
            File xmlDoc = new File("Animations.xml");
            DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dbFact.newDocumentBuilder();
            Document doc = dBuild.parse(xmlDoc);

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("program");

            for(int i=0 ; i<nList.getLength();i++){

                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    int Sub_price_year = 0;
                    Element eElement = (Element) nNode;
                    System.out.println("Program ID: " + eElement.getAttribute(("idno")));
                    System.out.println("Program Name: " + eElement.getElementsByTagName(("program_name")).item(0).getTextContent());
                    System.out.println("Language : " + eElement.getElementsByTagName(("language")).item(0).getTextContent());
                    System.out.println("Author: " + eElement.getElementsByTagName(("author")).item(0).getTextContent());
                    System.out.println("Release Year: " + eElement.getElementsByTagName(("release_year")).item(0).getTextContent());
                    System.out.println("Subscription price(Month): " + eElement.getElementsByTagName(("subscription_price")).item(0).getTextContent());
                    Sub_price_year = Integer.parseInt(eElement.getElementsByTagName(("subscription_price")).item(0).getTextContent());
                    System.out.println("Subscription price(Year): " + Sub_price_year * 12);
                }

            }

        }
        catch (Exception e){

        }

    }
}
