package model.domain;

/**
 * Created by Павел on 19-Nov-16.
 */
public class Periodical {
    private String title;
    private PeriodicalType type;
    private Boolean monthly;
    private PeriodicalChars periodicalChars;

    public Periodical() {
    }

    public Periodical(String title, PeriodicalType type, Boolean monthly, PeriodicalChars periodicalChars) {
        this.title = title;
        this.type = type;
        this.monthly = monthly;
        this.periodicalChars = periodicalChars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PeriodicalType getType() {
        return type;
    }

    public void setType(PeriodicalType type) {
        this.type = type;
    }

    public Boolean getMonthly() {
        return monthly;
    }

    public void setMonthly(Boolean monthly) {
        this.monthly = monthly;
    }

    public PeriodicalChars getPeriodicalChars() {
        return periodicalChars;
    }

    public void setPeriodicalChars(PeriodicalChars periodicalChars) {
        this.periodicalChars = periodicalChars;
    }

    @Override
    public String toString() {
        return "Periodical" + "\n" +
                "title='" + title + '\'' + "\n" +
                "type=" + type + "\n" +
                "monthly=" + monthly + "\n" +
                "periodicalChars:" + periodicalChars.toString() + "\n";
    }
}

