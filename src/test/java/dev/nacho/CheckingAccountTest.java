package dev.nacho;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    @Test
    void testDepositMoney() {
        CheckingAccount checkingAccount = new CheckingAccount(9000F, 12F);
        checkingAccount.depositMoney(200);
        assertEquals(9200, checkingAccount.balance);
    }

    @Test
    void testDepositMoneyWithOverdraft() {
        CheckingAccount checkingAccount = new CheckingAccount(9000F, 12F);
        checkingAccount.withdrawMoney(11000);
        checkingAccount.depositMoney(1000);
        assertEquals(-1000, checkingAccount.balance);
        assertEquals(1000, checkingAccount.getOverdraft());
        checkingAccount.depositMoney(2000);
        assertEquals(0, checkingAccount.getOverdraft());

    }

    @Test
    void testMonthlyStatement() {
        CheckingAccount checkingAccount = new CheckingAccount(15000F, 12F);
        checkingAccount.monthlyStatement();
        assertEquals(15150, checkingAccount.balance);
        
    }

    @Test
    void testWithdrawMoney() {
        CheckingAccount checkingAccount = new CheckingAccount(15000F, 12F);
        checkingAccount.withdrawMoney(2000);
        assertEquals(13000, checkingAccount.balance);

    }

    @Test
    void testWithdrawMoneyWithOverdraft() {
        CheckingAccount checkingAccount = new CheckingAccount(15000F, 12F);
        checkingAccount.withdrawMoney(18000);
        assertEquals(3000, checkingAccount.getOverdraft());
        assertEquals(-3000, checkingAccount.balance);

    }

    @Test
    void testPrint() {
        CheckingAccount checkingAccount = new CheckingAccount(15000F, 12F);
        assertEquals("balance: 15000.0, monthlyCommission: 0.0, transactions: 0, overdraft: 0.0, ", checkingAccount.print());

    }
}
