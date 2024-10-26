package artur.goz.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {
    private static final Logger logger = LoggerFactory.getLogger(XMLValidator.class);

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            logger.info("Початок валідації");
            // Ініціалізуємо фабрику схем
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Завантажуємо XSD-схему
            Schema schema = factory.newSchema(new File(xsdPath));

            // Створюємо валідатор на основі схеми
            Validator validator = schema.newValidator();

            // Виконуємо валідацію XML-документа
            validator.validate(new StreamSource(new File(xmlPath)));
            logger.info("XML є валідним");
            return true;
        } catch (Exception e) {
            logger.error("XML не валідний: {}", e.getMessage());
            return false;
        }
    }

}

