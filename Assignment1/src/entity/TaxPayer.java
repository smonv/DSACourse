package entity;

public class TaxPayer {
    private String code, name;
    private double income, deduct, tax;

    public TaxPayer(String code, String name, double income, double deduct, double tax) {
        this.code = code;
        this.name = name;
        this.income = income;
        this.deduct = deduct;
        this.tax = tax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getDeduct() {
        return deduct;
    }

    public void setDeduct(double deduct) {
        this.deduct = deduct;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
