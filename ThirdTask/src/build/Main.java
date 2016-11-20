package build;

import domain.Periodical;
import parser.StAXReader;
import validtion.XMLValidator;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

/**
 * Created by Павел on 20-Nov-16.
 */
public class Main {
    public static void main(String...args) throws IOException, XMLStreamException {
        StAXReader readerTest=new StAXReader();
        XMLValidator xmlValidator=new XMLValidator("ThirdTask/resources/xmls/xsdSheme.xsd");
        if (xmlValidator.validate("ThirdTask/resources/xmls/xmlData.xml")) {
            readerTest.read("ThirdTask/resources/xmls/xmlData.xml");
            readerTest.getPredicals().forEach((Periodical elem)->{
                System.out.println(elem.toString()+"\n");
            });
        } else {
            System.out.println("Validation has fallen: \n");
            xmlValidator.getError();
        }
    }
}
