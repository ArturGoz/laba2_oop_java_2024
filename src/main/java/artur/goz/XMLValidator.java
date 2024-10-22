package artur.goz;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            // Ініціалізуємо фабрику схем
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Завантажуємо XSD-схему
            Schema schema = factory.newSchema(new File(xsdPath));

            // Створюємо валідатор на основі схеми
            Validator validator = schema.newValidator();

            // Виконуємо валідацію XML-документа
            validator.validate(new StreamSource(new File(xmlPath)));

            System.out.println("XML є валідним проти XSD.");
            return true;
        } catch (Exception e) {
            System.out.println("XML не валідний проти XSD: " + e.getMessage());
            return false;
        }
    }

}

