package model.domain;

/**
 * Created by Павел on 19-Nov-16.
 */
public enum PeriodicalType {
    MAGAZINE("magazine"),
    BOOKLET("booklet"),
    NEWSPAPER("newspaper");

    private String value;

    private PeriodicalType(String value) {
        this.value = value;
    }


}
