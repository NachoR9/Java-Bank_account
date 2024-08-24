package dev.nacho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    void testDepositMoney() {
        SavingsAccount savingsAccount = new SavingsAccount(15000F, 12F);
        savingsAccount.depositMoney(500);
        assertEquals(15500, savingsAccount.balance);

    }

    @Test
    void testDepositMoneyAccountInactive() {
        SavingsAccount savingsAccount = new SavingsAccount(8000F, 12F);
        savingsAccount.depositMoney(500);
        assertEquals(8000, savingsAccount.balance);

    }

    @Test
    void testMonthlyStatement() {
        SavingsAccount savingsAccount = new SavingsAccount(15000F, 12F);
        savingsAccount.monthlyStatement();
        assertEquals(15150, savingsAccount.balance);
    }

    @Test
    void testMonthlyStatementMoreThanFourWitdrawals() {
        SavingsAccount savingsAccount = new SavingsAccount(15000F, 12F);
        savingsAccount.withdrawMoney(1000);
        savingsAccount.withdrawMoney(1000);
        savingsAccount.withdrawMoney(1000);
        savingsAccount.withdrawMoney(1000);
        savingsAccount.withdrawMoney(1000);
        savingsAccount.monthlyStatement();
        assertEquals(9090, savingsAccount.balance);
        assertFalse(savingsAccount.isActive());

    }

    @Test
    void testWithdrawMoney() {
       SavingsAccount savingsAccount = new SavingsAccount(15000F, 12F);
       savingsAccount.withdrawMoney(1500);
       assertEquals(13500, savingsAccount.balance);
    }

    @Test
    void testWithdrawMoneyInactive() {
       SavingsAccount savingsAccount = new SavingsAccount(9000F, 12F);
       savingsAccount.withdrawMoney(2000);
       assertEquals(9000, savingsAccount.balance);

    }
}
