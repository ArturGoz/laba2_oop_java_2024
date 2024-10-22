package artur.goz;

import artur.goz.generated.Gun;

import java.util.List;

import static artur.goz.xmlParsers.DOMParser.parseGuns;

public class Main {
    public static void main(String[] args) {
        List<Gun> guns = parseGuns("src/main/resources/gunsToParse.xml");
        guns.forEach(m -> System.out.println(m.getModel()));
        guns.forEach(m -> m.getTTC().getRange());
    }
}