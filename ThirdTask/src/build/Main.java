package build;

import parser.StAXReader;
import parser.XMLParser;
import validtion.XMLValidator;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Created by Павел on 20-Nov-16.
 */
public class Main {
    public static void main(String... args) throws IOException, XMLStreamException {
        StAXReader stAXReader = new StAXReader();
        XMLValidator xmlValidator = new XMLValidator("ThirdTask/resources/xmls/xsdSheme.xsd");
        XMLParser xmlParser = new XMLParser(stAXReader, xmlValidator);
        xmlParser.parse("ThirdTask/resources/xmls/xmlData.xml");
    }
}

