package src.TransferByReferenceOrByValue.example2;

public class BankDetails {
    private final String billNumber;
    private final String correspondenceBill;
    private final String bikNumber;
    private final String bankName;
    private final String city;

    public BankDetails(String billNumber, String correspondenceBill, String bikNumber, String bankName, String city) {
        this.billNumber = billNumber;
        this.correspondenceBill = correspondenceBill;
        this.bikNumber = bikNumber;
        this.bankName = bankName;
        this.city = city;
    }

    public BankDetails() {
        billNumber = "N/A";
        correspondenceBill = "N/A";
        bikNumber = "N/A";
        bankName = "N/A";
        city = "N/A";
    }

    public String getBillNumber() {
        return billNumber;
    }

    public String getCorrespondenceBill() {
        return correspondenceBill;
    }

    public String getCity() {
        return city;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBikNumber() {
        return bikNumber;
    }

    public BankDetails setBillNumber(String billNumber) {
        return new BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }


    public BankDetails setBikNumber(String bikNumber) {
        return new BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    public BankDetails setCorrespondenceBill(String correspondenceBill) {
        return new BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    public BankDetails setBankName(String bankName) {
        return new BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    public BankDetails setCity(String city) {
        return new BankDetails(billNumber, correspondenceBill, bikNumber, bankName, city);
    }

    @Override
    public String toString() {
        return "BankDetails{" +
                "billNumber='" + billNumber + '\'' +
                ", correspondenceBill='" + correspondenceBill + '\'' +
                ", bikNumber='" + bikNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
