package artur.goz.xmlParsers;

import artur.goz.generated.Gun;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static artur.goz.xmlParsers.StAXParserExample.parseXML;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTests {
    List<Gun> guns;
    String path = "src/main/resources/gunsToParse.xml";
    List<String> list;

    public void fillListWithGuns(){
        list = new ArrayList<>();
        guns.forEach(gun -> list.add(gun.getModel()));
    }

    @Test
    public void domParserTest(){
        guns = DOMParserExample.parseXML(path);
        fillListWithGuns();
        assertEquals(Arrays.asList("AK-47","M16","Glock 17"),list);
    }
    @Test
    public void saxParserTest(){
        SAXParserExample saxParserExample = new SAXParserExample();
        guns = saxParserExample.parseXML(path);
        fillListWithGuns();
        assertEquals(Arrays.asList("AK-47","M16","Glock 17"),list);
    }
    @Test
    public void staxParserTest(){
        guns = StAXParserExample.parseXML(path);
        fillListWithGuns();
        assertEquals(Arrays.asList("AK-47","M16","Glock 17"),list);
    }
}