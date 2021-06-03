package com.fedevela.dom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * http://examples.javacodegeeks.com/core-java/xml/parsers/documentbuilderfactory/read-xml-file-in-java-using-dom-parser-example/
 */

public class ReadXMLFileUsingDom2 {

    public static final String xmlFilePath = "src/main/java/com/fedevela/dom/testFile.xml";

    public static void main(String[] args) {

        try {

            File xmlFile = new File(xmlFilePath);
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            System.out.println("Root element :"+ document.getDocumentElement().getNodeName());
            System.out.println("===============================");
            if (document.hasChildNodes()) {
                printNodeList(document.getChildNodes());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void printNodeList(NodeList nodeList) {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node elemNode = nodeList.item(count);
            if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node name and value
                System.out.println("\nNode Name =" + elemNode.getNodeName()
                        + " [OPEN]");
                System.out.println("Node Content =" + elemNode.getTextContent());

                if (elemNode.hasAttributes()) {

                    NamedNodeMap nodeMap = elemNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : "
                                + node.getNodeValue());

                    }

                }

                if (elemNode.hasChildNodes()) {
                    //recursive call if the node has child nodes
                    printNodeList(elemNode.getChildNodes());

                }

                System.out.println("Node Name =" + elemNode.getNodeName()
                        + " [CLOSE]");

            }

        }

    }

}