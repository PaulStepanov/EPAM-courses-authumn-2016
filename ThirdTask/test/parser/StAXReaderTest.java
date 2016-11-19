package parser;

import domain.Periodical;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

/**
 * Created by Павел on 19-Nov-16.
 */
public class StAXReaderTest {
    public static void main(String...args) throws FileNotFoundException, XMLStreamException {
        StAXReader readerTest=new StAXReader();
        readerTest.read("E:\\progects\\kek\\EPAM-courses-authumn-2016\\ThirdTask\\resources\\xmls\\xmlData.xml");
        readerTest.getPredicals().forEach((Periodical elem)->{
            System.out.println(elem.toString()+"\n");
        });
    }
}
