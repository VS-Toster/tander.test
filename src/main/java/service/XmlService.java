package service;

import com.thoughtworks.xstream.XStream;
import model.Entries;
import model.Entry;

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
            Entry entry = new Entry();
            entry.setField(value);
            entries.getEntries().add(entry);
        }

        return xstream.toXML(entries);
    }
}