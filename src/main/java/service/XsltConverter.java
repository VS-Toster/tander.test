package service;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XsltConverter {
    public String convertToXslt(File fileToConvert) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(fileToConvert);
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File("article1.xml"));
        transformer.transform(xml, new StreamResult(new File("output.xml")));
        return "";

    }
}
