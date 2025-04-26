package src.TransferByReferenceOrByValue.example2;

public class Company {
    private final String companyName;
    private final BankDetails bankDetails;

    public Company(String companyName, BankDetails bankDetails) {
        this.companyName = companyName;
        this.bankDetails = bankDetails;
    }

    public String getCompanyName() {
        return companyName;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", bankDetails=" + bankDetails +
                '}';
    }

}
