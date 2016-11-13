package syntaxElements;

import logicElement.SentenseElement;

public abstract class Symbol implements SentenseElement{
     private String value;
    
    public Symbol(String value) {
        this.value = value;
    }  

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
 