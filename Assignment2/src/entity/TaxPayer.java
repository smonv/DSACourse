package entity;

public class TaxPayer implements Comparable<TaxPayer> {

    private String code, name;
    private double income, deduct, tax;

    public TaxPayer(String code) {
        this.code = code;
    }

    public TaxPayer(String code, String name, double income, double deduct, double tax) {
        this.code = code;
        this.name = name;
        this.income = income;
        this.deduct = deduct;
        this.tax = tax;
    }

    @Override
    public String toString() {
        return String.format(
                "Code: " + code + "\n"
                + "Name: " + name + "\n"
                + "Income: " + income + "\n"
                + "Deduct: " + deduct + "\n"
                + "Tax: " + tax + "\n"
                + "------------------------"
        );
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

    @Override
    public int compareTo(TaxPayer o) {
        return this.getCode().compareTo(o.getCode());
    }
}
