package model.domain;

import java.security.InvalidParameterException;

public class Obligation {
    private final ObligationType type;
    private int terms;
    private double percents;
    private int property;
    private double riskDegree;
    private int cost;

    public Obligation(ObligationType oType) {
        this.type = oType;
        this.percents = (int) type.PERCENT;
    }

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) throws InvalidParameterException {
        if (property < this.type.MIN_PROPERTY) {
            throw new InvalidParameterException();
        }
        this.property = property;
        this.cost = (int) ((property / 100) * this.percents);
    }

    public double getRiskDegree() {
        return riskDegree;
    }

    public void setRiskDegree(double riskDegree) {
        this.riskDegree = riskDegree;
    }

    public double getPercents() {
        return percents;
    }

    public int getCost() {
        return cost;
    }

    public ObligationType getType() {
        return type;
    }
}
