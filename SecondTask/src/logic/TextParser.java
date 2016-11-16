package logic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import constants.RegExpConst;
import logicElements.Paragraph;
import logicElements.Sentense;
import textReader.InputReader;

class TextParser {
    private final ArrayList<Paragraph> paragraphs = new ArrayList<>();
    private StringBuilder fullText = new StringBuilder();

    public TextParser(InputReader inputReader) {
        while (inputReader.hasNext()) {
            fullText.append(inputReader.nextLine()).append("\n");
        }
        splitOnParagraphes();
    }

    private void splitOnParagraphes() {
        Pattern pattern = Pattern.compile(RegExpConst.TEXT_SPLIT);
        Matcher matcher = pattern.matcher(fullText);
        while (matcher.find()) {
            paragraphs.add(new Paragraph(matcher.group()));
        }
    }

    public void deleteSubstrings(String substring) {
        paragraphs.forEach((Paragraph elem) -> {
            elem.getSentences().forEach((Sentense sentense) -> {
                sentense.deleteMaxSubstring(substring);
            });
        });
    }

    public void writeToFile(String destination) throws IOException {
        FileWriter fWriter = new FileWriter(destination);
        fWriter.write(fullText.toString());
        fWriter.flush();

    }
    
    public void updateParagraphText(){
        StringBuilder text=new StringBuilder();
        paragraphs.forEach((paragraph)->{
            paragraph.updateText();
            text.append(paragraph.toString()).append("\n");
        });
       fullText=text;
        
    }

}
