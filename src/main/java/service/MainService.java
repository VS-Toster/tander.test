package service;

import dboperation.SqlOperations;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class MainService {
    public void start(long n) {
        try {
            SqlOperations sqlOperations = new SqlOperations();
            XmlService xmlService = new XmlService();
            FileResources xsltConverter = new FileResources();
            if (sqlOperations.existingData("test")) {
                sqlOperations.truncateTable("test");
            }
            for (long i = 1; i <= n; i++) {
                sqlOperations.insertData("test", i);
            }
            String xml = xmlService.createStringXml(sqlOperations.getData("test"));
            File file = new File("1.xml");
            BufferedWriter outXml = new BufferedWriter(new FileWriter(file));
            outXml.write(xml);
            outXml.close();

            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File("template.xsl"));
            Transformer transformer = factory.newTransformer(xslt);
            Source xls = new StreamSource(new File("1.xml"));
            transformer.transform(xls, new StreamResult(new File("2.xml")));
            BufferedWriter outXls = new BufferedWriter(new FileWriter(file));
            outXls.write(xml);
            outXls.close();


        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
