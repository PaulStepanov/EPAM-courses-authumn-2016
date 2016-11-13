package domain;

public enum ObligationType {
    PERSONAL(5.0, 10000), 
    BUISENESS_RISK(10.0, 30000), 
    CONTRACT_LABILITY(7.0, 5000), 
    HARM_CAUSING(3.0,2000), 
    PROPERTY(4.0, 80000);

    public final double PERCENT;
    public final int MIN_PROPERTY;

    private ObligationType(double percent, int minProperty) {
        this.PERCENT = percent;
        this.MIN_PROPERTY = minProperty;
    }
}
