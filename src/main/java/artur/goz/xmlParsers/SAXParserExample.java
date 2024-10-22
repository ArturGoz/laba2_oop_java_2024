package artur.goz.xmlParsers;

import artur.goz.generated.Gun;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SAXParserExample extends DefaultHandler {

    private List<Gun> guns = new ArrayList<>();
    private Gun gun;
    private Gun.TTC ttc;
    private StringBuilder data;

    public List<Gun> parseXML(String xmlFilePath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(new File(xmlFilePath), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return guns;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        data = new StringBuilder();
        if (qName.equalsIgnoreCase("Gun")) {
            gun = new Gun();
            gun.setId(attributes.getValue("id"));
        } else if (qName.equalsIgnoreCase("TTC")) {
            ttc = new Gun.TTC();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Model")) {
            gun.setModel(data.toString());
        } else if (qName.equalsIgnoreCase("Handy")) {
            gun.setHandy(data.toString());
        } else if (qName.equalsIgnoreCase("Origin")) {
            gun.setOrigin(data.toString());
        } else if (qName.equalsIgnoreCase("Material")) {
            gun.setMaterial(data.toString());
        } else if (qName.equalsIgnoreCase("Range")) {
            ttc.setRange(data.toString());
        } else if (qName.equalsIgnoreCase("SightingRange")) {
            ttc.setSightingRange(new BigInteger(data.toString()));
        } else if (qName.equalsIgnoreCase("Magazine")) {
            ttc.setMagazine(Boolean.parseBoolean(data.toString()));
        } else if (qName.equalsIgnoreCase("Optics")) {
            ttc.setOptics(Boolean.parseBoolean(data.toString()));
        } else if (qName.equalsIgnoreCase("TTC")) {
            gun.getTTC().add(ttc);
        } else if (qName.equalsIgnoreCase("Gun")) {
            guns.add(gun);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

}

