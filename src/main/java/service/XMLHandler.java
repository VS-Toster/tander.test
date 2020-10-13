package service;


import model.Entry;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

class XMLHandler extends DefaultHandler {

    private final List<Entry> entryList = new ArrayList<>();

    public List<Entry> getEntryList() {
        return entryList;
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {
        if (qName.equals("entry")) {
            Long field = Long.valueOf(attributes.getValue("field"));
            entryList.add(new Entry(field));
        }
    }
}