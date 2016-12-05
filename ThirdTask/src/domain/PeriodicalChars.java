package model.domain;

/**
 * Created by Павел on 19-Nov-16.
 */
public class PeriodicalChars {
    private Boolean colored;
    private Integer size;
    private Boolean gloss;
    private Boolean hasIndex;

    public PeriodicalChars() {
    }

    public PeriodicalChars(Boolean colored, Integer size, Boolean gloss, Boolean hasIndex) {
        this.colored = colored;
        this.size = size;
        this.gloss = gloss;
        this.hasIndex = hasIndex;
    }

    public Boolean getColored() {
        return colored;
    }

    public void setColored(Boolean colored) {
        this.colored = colored;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getGloss() {
        return gloss;
    }

    public void setGloss(Boolean gloss) {
        this.gloss = gloss;
    }

    public Boolean getHasIndex() {
        return hasIndex;
    }

    public void setHasIndex(Boolean hasIndex) {
        this.hasIndex = hasIndex;
    }

    @Override
    public String toString() {
        return
                "colored=" + colored + "\n" +
                        "size=" + size + "\n" +
                        "gloss=" + gloss + "\n" +
                        "hasIndex=" + hasIndex + "\n";
    }
}
