package artur.goz.xmlParsers;

import artur.goz.generated.Gun;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StAXParserExample {

    public static List<Gun> parseXML(String xmlFilePath) {
        List<Gun> guns = new ArrayList<>();
        Gun gun = null;
        Gun.TTC ttc = null;
        String content = null;

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream(xmlFilePath));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    switch (event.asStartElement().getName().getLocalPart()) {
                        case "Gun":
                            gun = new Gun();
                            gun.setId(event.asStartElement().getAttributeByName(new javax.xml.namespace.QName("id")).getValue());
                            break;
                        case "TTC":
                            ttc = new Gun.TTC();
                            break;
                    }
                } else if (event.isCharacters()) {
                    content = event.asCharacters().getData().trim();
                } else if (event.isEndElement()) {
                    switch (event.asEndElement().getName().getLocalPart()) {
                        case "Model":
                            gun.setModel(content);
                            break;
                        case "Handy":
                            gun.setHandy(content);
                            break;
                        case "Origin":
                            gun.setOrigin(content);
                            break;
                        case "Material":
                            gun.setMaterial(content);
                            break;
                        case "Range":
                            ttc.setRange(content);
                            break;
                        case "SightingRange":
                            ttc.setSightingRange(new BigInteger(content));
                            break;
                        case "Magazine":
                            ttc.setMagazine(Boolean.parseBoolean(content));
                            break;
                        case "Optics":
                            ttc.setOptics(Boolean.parseBoolean(content));
                            break;
                        case "TTC":
                            gun.getTTC().add(ttc);
                            break;
                        case "Gun":
                            guns.add(gun);
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return guns;
    }
}

