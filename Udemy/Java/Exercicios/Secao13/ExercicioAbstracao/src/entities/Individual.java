package entities;

public final class Individual extends TaxPayer{
    private Double healthExpenditures;

    public Individual() {
        super();
    }

    public Individual(Double anualIncome, String name, Double healthExpenditures) {
        super(anualIncome, name);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        double tax;
        if (getAnualIncome() < 20000.0) {
            tax = getAnualIncome() * 0.15;
        } else {
            tax = getAnualIncome() * 0.25;
        }

        if (healthExpenditures > 0.0) {
            tax -= healthExpenditures * 0.5;
        }

        return tax;
    }
}
