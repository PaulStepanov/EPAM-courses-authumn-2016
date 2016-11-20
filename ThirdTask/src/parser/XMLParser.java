package parser;

import domain.Periodical;
import validtion.XMLValidator;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Created by Павел on 20-Nov-16.
 */
public class XMLParser {
    private XMLReader reader;
    private XMLValidator xmlValidator;

    public XMLParser(XMLReader reader, XMLValidator xmlValidator) {
        this.reader = reader;
        this.xmlValidator = xmlValidator;
    }

    public void parse(String fileName) throws IOException, XMLStreamException {
        if (xmlValidator.validate(fileName)) {
            reader.read(fileName);
            reader.getPredicals().forEach((Periodical elem) -> {
                System.out.println(elem.toString() + "\n");
            });
        } else {
            System.out.println("Validation has fallen: \n");
            xmlValidator.getError();
        }
    }
}
