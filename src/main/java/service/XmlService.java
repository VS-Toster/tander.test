package service;

import com.thoughtworks.xstream.XStream;
import model.Entries;
import model.Entry;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlService {

    public String createStringXml(List<Long> values) {

        XStream xstream = new XStream();
        xstream.alias("entry", Entry.class);
        xstream.alias("entries", Entries.class);
        xstream.addImplicitCollection(Entries.class, "entries");

        Entries entries = new Entries();
        entries.setEntries(new ArrayList<Entry>());
        for (Long value : values) {
            entries.getEntries().add(new Entry(value));
        }

        return xstream.toXML(entries);
    }

    public void transformXML(File fileToTransform, File transformedFile) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("template.xsl"));
        Transformer transformer = factory.newTransformer(xslt);
        Source streamSource = new StreamSource(fileToTransform);
        transformer.transform(streamSource, new StreamResult(transformedFile));
    }

    public void parseXML(File file, XMLHandler xmlHandler) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        parser.parse(file, xmlHandler);
    }
}