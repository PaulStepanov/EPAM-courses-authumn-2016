package logicElements;

import syntaxElements.Comma;
import syntaxElements.Dot;
import syntaxElements.QuestMark;
import syntaxElements.Semicolon;

public class SentenceElementCreator {
    public static SentenseElement createElem(String str) {
        str = str.trim();
        if (str.equals(".")) {
            return new Dot();
        }
        if (str.equals(",")) {
            return new Comma();
        }

        if (str.equals("?")) {
            return new QuestMark();
        }

        if (str.equals(";")) {
            return new Semicolon();
        }

        return new Word(str);
    }

}
