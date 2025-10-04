package entities;

public abstract class TaxPayer {
    private String name;
    private Double anualIncome;

    public TaxPayer(){}

    public TaxPayer(Double anualIncome, String name) {
        this.anualIncome = anualIncome;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnualIncome() {
        return anualIncome;
    }

    public void setAnualIncome(Double anualIncome) {
        this.anualIncome = anualIncome;
    }

    public abstract Double tax();
}
