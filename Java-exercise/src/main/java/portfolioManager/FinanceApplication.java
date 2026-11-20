package portfolioManager;

import java.math.BigDecimal;



public class FinanceApplication {
    static void main(String[] args) {
        BankAccount account1 = new BankAccount("sel", "123", new BigDecimal("1000"));
        Valuable account2 = new BankAccount("dijon", "1234", new BigDecimal("1500"));

        account1.deposit(new BigDecimal("100"));


        System.out.println("Sel: $ " + account1.getValue());
        System.out.println("dijon: $" + account2.getValue());

        if (account2 instanceof BankAccount) {
            BankAccount bankAccount = (BankAccount) account2;
            bankAccount.deposit(new BigDecimal("100"));
        }



    }
}
