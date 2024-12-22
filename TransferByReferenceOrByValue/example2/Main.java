package TransferByReferenceOrByValue.example2;

public class Main {
    public static void main(String[] args) {
        BankDetails bankDetails = new BankDetails().setBillNumber("54484880000324");

        Company company = new Company("ПриватБанк", bankDetails);

        BankDetails copy = bankDetails.setBillNumber("123123123123123123");
        Company company1 = new Company("Монобанк", copy);

        System.out.println(company1);
        System.out.println(company);
    }
}
