package service;

import org.w3c.dom.NodeList;

import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XmlParser {
    private String getDataFromXml(){
        ArrayList<Integer> List = new ArrayList<Integer>();
        Document doc = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File f = new File("2.xml");
            doc = (Document) db.parse(f);
        } catch (Exception e) {
            System.out.println(e);
        }
        assert doc != null;
        return "";


    }
}
