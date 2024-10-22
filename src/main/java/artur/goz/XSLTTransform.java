package artur.goz;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTTransform {
    public static void main(String[] args) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(new File("src/main/resources/guns_transform.xslt")));
        transformer.transform(new StreamSource(new File("src/main/resources/gunsToParse.xml")), new StreamResult(new File("src/main/resources/transformed_guns.xml")));
        System.out.println("Transformation completed.");
    }
}
