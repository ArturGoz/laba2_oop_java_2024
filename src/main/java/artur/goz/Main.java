package artur.goz;

import artur.goz.generated.Gun;

import java.util.List;

import static artur.goz.xmlParsers.StAXParserExample.parseXML;

public class Main {

    public static void main(String[] args) {
/*          List<Gun> guns = parseGuns("src/main/resources/gunsToParse.xml");
        guns.forEach(m -> System.out.println(m.getModel()));*/

/*            SAXParserExample parser = new SAXParserExample();
            List<Gun> guns = parser.parseXML("src/main/resources/gunsToParse.xml");
             guns.forEach(m -> System.out.println(m.getModel()));*/
        List<Gun> guns = parseXML("src/main/resources/gunsToParse.xml");
        guns.forEach(m -> System.out.println(m.getModel()));
        guns.forEach(m -> System.out.println(m.getTTC().getFirst().getRange()));
    }
}