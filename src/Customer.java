import java.util.Objects;

public class Customer {
    private final String name;
    private final String cardNumber;
    private final String pin;
    private int balance;

    public Customer(String name, String cardNumber, String pin, int balance) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public Boolean validate(String enteredPin) {
        return Objects.equals(enteredPin, pin);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getPin() { return pin; }

    public int getBalance() {
        return balance;
    }

    public void addFunds(int amount) {
        this.balance += amount;
    }

    public void withdrawFunds(int amount) {
        this.balance -= amount;
    }
}
