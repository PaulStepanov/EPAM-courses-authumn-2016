package logicElements;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import constants.RegExpConst;

public class Paragraph {

    private final ArrayList<Sentense> sentences = new ArrayList<>();
    private String paragraph;

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
        preParse();
        splitOnSentences();
    }

    public String toString() {
        updateText();
        return paragraph;
    }

    /*Split paragraph on sentences
     * */
    private void splitOnSentences() {
        Pattern pattern = Pattern.compile(RegExpConst.PARAGRAPH_SPLIT);
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            sentences.add(new Sentense(matcher.group()));
        }
    }

    /*Updates paragraphText from sentences ArrayList */
    public void updateText() {
        StringBuilder text = new StringBuilder();
        sentences.forEach((sent) -> {
            text.append(sent.toString()).append(" ");
        });
        paragraph = text.toString();
    }

    public ArrayList<Sentense> getSentences() {
        return sentences;
    }

    public String getParagraph() {
        return paragraph;
    }

    /*Replacing spaces and tabs to one space 
     * */
    private void preParse() {
        Pattern pattern = Pattern.compile(RegExpConst.SPACES_AND_TABS_REPLACE);
        Matcher matcher = pattern.matcher(paragraph);
        paragraph = matcher.replaceAll(" ");
        paragraph = matcher.replaceAll(" ");
        System.out.println(paragraph);
    }
}
