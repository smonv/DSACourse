package entity;

public class ModifiedTaxPayer {

    private TaxPayer tp;
    private boolean status;

    public ModifiedTaxPayer(TaxPayer tp, boolean status) {
        this.tp = tp;
        this.status = status;
    }

    public TaxPayer getTp() {
        return tp;
    }

    public void setTp(TaxPayer tp) {
        this.tp = tp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
