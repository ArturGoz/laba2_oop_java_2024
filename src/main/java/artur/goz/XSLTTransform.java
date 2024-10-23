package artur.goz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTTransform {
    private static final Logger logger = LoggerFactory.getLogger(XSLTTransform.class);
    public static void transformXML()  {
        try {
            logger.info("Початок трансформації");
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(new File("src/main/resources/guns_transform.xslt")));
            transformer.transform(new StreamSource(new File("src/main/resources/gunsToParse.xml")), new StreamResult(new File("src/main/resources/transformed_guns.xml")));
            logger.info("Закінчення трансформації. Результат збережено в transformed_guns.xml.");
        } catch (Exception e) {
            logger.error("Виникла помилка під час трансформації: {}", e.getMessage());
        }
    }
}
