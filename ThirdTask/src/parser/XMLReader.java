package parser;

import model.domain.Periodical;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Павел on 19-Nov-16.
 */
public interface XMLReader {
    public void read(String fileName) throws FileNotFoundException, XMLStreamException;

    public List<Periodical> getPredicals();
}
