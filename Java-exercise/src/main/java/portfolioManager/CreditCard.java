package portfolioManager;

import java.math.BigDecimal;

public class CreditCard implements Valuable {
    private String name;
    private String accountNumber;
    private BigDecimal balance;

    public CreditCard(String name, String accountNumber, BigDecimal balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void charge(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            balance = balance.add(amount);
        }
    }

    public void pay(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0 && amount.compareTo(balance) <= 0) {
            balance = balance.subtract(amount);
        }
    }


    @Override
    public BigDecimal getValue() {
        return balance.negate();
    }
}
