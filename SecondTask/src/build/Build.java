package build;

import logic.TextParser;
import logicElements.Sentense;
import textReader.TxtReader;

import java.io.IOException;

/**
 * Created by Павел on 19-Nov-16.
 */
public class Build {
    public static void main(String... args) throws IOException {
        TxtReader txtReader = new TxtReader("resources/text.txt");
        TextParser tParser = new TextParser(txtReader);
        tParser.deleteSubstrings("l");
        ;
        tParser.updateParagraphText();
        tParser.writeToFile("resources/text.txt");
        Sentense sentense = new Sentense("lorem de input la ma");
        sentense.deleteMaxSubstring("l");
        System.out.println(sentense);
    }

}
