package logicElements;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import constants.RegExpConst;

public class Sentense {
    private String fullVal;
    private final HashMap<Integer, SentenseElement> elements = new HashMap<>();

    public Sentense(String fullVal) {
        this.fullVal = fullVal;
        splitOnElements();
    }

    private void splitOnElements() {
        Pattern pattern = Pattern.compile(RegExpConst.SENTENSE_SPLIT);
        Matcher matcher = pattern.matcher(fullVal);
        while (matcher.find()) {
            elements.put(matcher.start(), SentenceElementCreator.createElem(matcher.group()));
        }
    }

    public void deleteMaxSubstring(String symbol) {
        Pattern pattern = Pattern.compile("(" + symbol + ".+" + symbol + ")");
        Matcher matcher = pattern.matcher(fullVal);
        fullVal = matcher.replaceAll("");
        System.out.println(matcher.replaceAll("") + "symbol:" + symbol);
        splitOnElements();
    }

    public HashMap<Integer, SentenseElement> getElements() {
        return elements;
    }

    public String toString() {
        return fullVal;
    }
}
