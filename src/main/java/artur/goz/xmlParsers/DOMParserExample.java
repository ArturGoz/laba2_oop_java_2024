package artur.goz.xmlParsers;

import artur.goz.generated.Gun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class DOMParserExample {
    private static final Logger logger = LoggerFactory.getLogger(DOMParserExample.class);

    public static List<Gun> parseXML(String xmlFilePath) {
        List<Gun> guns = new ArrayList<>();
        try {
            logger.info("DOM парсинг розпочався");
            // Ініціалізуємо DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Читаємо XML
            Document document = builder.parse(new File(xmlFilePath));

            // Отримуємо список елементів "Gun"
            NodeList nodeList = document.getElementsByTagName("Gun");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element gunElement = (Element) node;
                    Gun gun = new Gun();
                    gun.setId(gunElement.getAttribute("id"));
                    gun.setModel(gunElement.getElementsByTagName("Model").item(0).getTextContent());
                    gun.setHandy(gunElement.getElementsByTagName("Handy").item(0).getTextContent());
                    gun.setOrigin(gunElement.getElementsByTagName("Origin").item(0).getTextContent());
                    gun.setMaterial(gunElement.getElementsByTagName("Material").item(0).getTextContent());

                    NodeList ttcNodes = gunElement.getElementsByTagName("TTC");
                    for (int j = 0; j < ttcNodes.getLength(); j++) {
                        Element ttcElement = (Element) ttcNodes.item(j);
                        Gun.TTC ttc = new Gun.TTC();
                        ttc.setRange(ttcElement.getElementsByTagName("Range").item(0).getTextContent());
                        ttc.setSightingRange(new BigInteger(ttcElement.getElementsByTagName("SightingRange").item(0).getTextContent()));
                        ttc.setMagazine(Boolean.parseBoolean(ttcElement.getElementsByTagName("Magazine").item(0).getTextContent()));
                        ttc.setOptics(Boolean.parseBoolean(ttcElement.getElementsByTagName("Optics").item(0).getTextContent()));

                        gun.getTTC().add(ttc);
                    }
                    guns.add(gun);
                }
            }
            logger.info("DOM парсинг закінчився успішно");
        } catch (Exception e) {
            logger.error("DOM парсинг закінчився з помилкою: {}", e.getMessage());
        }
        return guns;
    }
}

