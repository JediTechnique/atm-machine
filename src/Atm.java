public class Atm {
    private final BankDb db;
    public Atm() {
        db = new BankDb("accounts.txt");
    }
    public Customer requestLogIn(String cardName) {
        return db.getCustomer(cardName);
    }

    public void requestUpdate() {
        db.updateDb("accounts.txt");
    }

}
