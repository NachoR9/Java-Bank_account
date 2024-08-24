package dev.nacho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    void testDepositMoney() {
       BankAccount account = new BankAccount(1000F, 12F);
       account.depositMoney(500);
       assertEquals(1500, account.balance);
       assertEquals(1, account.consignments);
    }

    @Test
    void testDepositMoneyNegativeAmount() {
       BankAccount account = new BankAccount(1000F, 12F);
       account.depositMoney(-10);
       assertEquals(1000, account.balance);
       assertEquals(0, account.consignments);

    }

    @Test
    void testMonthlyInterest() {
       BankAccount account = new BankAccount(1000F, 12F);
       account.monthlyInterest();
       assertEquals(1010, account.balance); 
    }

    @Test
    void testMonthlyStatement() {
       BankAccount account = new BankAccount(1000F, 12F);
       account.monthlyStatement();
       assertEquals(1010, account.balance);

    }

    @Test
    void testWithdrawMoney() {
       BankAccount account = new BankAccount(1000F, 12F);
       account.withdrawMoney(200);
       assertEquals(800, account.balance);
    }

    @Test
    void testWithdrawMoneyAmountHigherThanBalance() {
       BankAccount account = new BankAccount(1000F, 12F);
       account.withdrawMoney(1700);
       assertEquals(1000, account.balance);

    }

    @Test
    void testWithdrawMoneyAmountBelowZero() {
       BankAccount account = new BankAccount(1000F, 12F);
        account.withdrawMoney(-555);
        assertEquals(1000, account.balance);
    }
}
