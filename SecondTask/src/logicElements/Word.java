package logicElements;

public class Word implements SentenseElement {
    private String value;

    public Word(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

}
