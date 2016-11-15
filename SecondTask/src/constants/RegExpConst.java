package constants;

public interface RegExpConst {
    
    public final String PARAGRAPH_SPLIT="([\"']?[A-Z][^.?!]+((?![.?!]['\"]?\\s[\"']?[A-Z][^.?!]).)+[.?!'\"]+)|(\\b((?!=|\\\\.).)+(.)\\b)";
    
    public final String SENTENSE_SPLIT="([^\\s]+\\w)|([^\\s]\\W)";
    
    public final String TEXT_SPLIT="(\\n|^).*?(?=\\n|$)"; 
    
    public final String SPACES_AND_TABS_REPLACE="[\\s\\t]+";

}
