package artur.goz;

import org.junit.Test;

import static artur.goz.XMLValidator.validateXMLSchema;
import static org.junit.jupiter.api.Assertions.*;

public class XMLValidatorTest {
    @Test
    public void exampleValidationTest(){
        String xsdPath = "src/main/resources/gun.xsd"; // шлях до вашого XSD-файлу
        String xmlPath = "src/main/resources/gunExample.xml"; // шлях до вашого XML-файлу

        assertTrue(validateXMLSchema(xsdPath, xmlPath));
    }
}