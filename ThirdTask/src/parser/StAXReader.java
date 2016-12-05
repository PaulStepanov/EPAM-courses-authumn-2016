package parser;

import model.domain.Periodical;
import model.domain.PeriodicalChars;
import model.domain.PeriodicalType;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Павел on 19-Nov-16.
 */
public class StAXReader implements XMLReader {
    private ArrayList<Periodical> periodicals;

    public void read(String fileName) throws FileNotFoundException, XMLStreamException {
        periodicals = new ArrayList<Periodical>();
        Periodical periodical = null;
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(fileName));
        PeriodicalChars periodicalChars = null;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if (tagName.equals("periodical")) {
                        periodical = new Periodical();
                    } else if (tagName.equals("title")) {
                        periodical.setTitle(reader.getElementText().trim());
                    } else if (tagName.equals("type")) {
                        PeriodicalType pType = PeriodicalType.valueOf(reader.getElementText().trim().toUpperCase());
                        periodical.setType(pType);
                    } else if (tagName.equals("monthly")) {
                        periodical.setMonthly(Boolean.valueOf(reader.getAttributeValue(null, "value").trim()));
                    } else if (tagName.equals("chars")) {
                        periodicalChars = new PeriodicalChars();
                    } else if (tagName.equals("colored")) {
                        periodicalChars.setColored(Boolean.valueOf(reader.getAttributeValue(null, "value").trim()));
                    } else if (tagName.equals("size")) {
                        periodicalChars.setSize(Integer.valueOf(reader.getElementText().trim()));
                    } else if (tagName.equals("gloss")) {
                        periodicalChars.setGloss(Boolean.valueOf(reader.getAttributeValue(null, "value").trim()));
                    } else if (tagName.equals("hasIndex")) {
                        periodicalChars.setHasIndex(Boolean.valueOf(reader.getAttributeValue(null, "value").trim()));
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String tagName = reader.getLocalName();
                    if (tagName.equals("periodical")) {
                        periodicals.add(periodical);
                        periodical = null;
                    } else if (tagName.equals("chars")) {
                        periodical.setPeriodicalChars(periodicalChars);
                        periodicalChars = null;
                    }
                    break;
                }
            }
        }


    }

    public List<Periodical> getPredicals() {
        return periodicals;
    }
}
