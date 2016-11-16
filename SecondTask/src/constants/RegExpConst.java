package constants;

public interface RegExpConst {
    
    String PARAGRAPH_SPLIT="([\"']?[A-Z][^.?!]+((?![.?!]['\"]?\\s[\"']?[A-Z][^.?!]).)+[.?!'\"]+)|(\\b((?!=|\\\\.).)+(.)\\b)";
    
    String SENTENSE_SPLIT="([^\\s]+\\w)|([^\\s]\\W)";
    
    String TEXT_SPLIT="(\\n|^).*?(?=\\n|$)";
    
    String SPACES_AND_TABS_REPLACE="[\\s\\t]+";

}
