package dev.nacho;

public class SavingsAccount extends BankAccount {

    private boolean active;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);

        active = balance >= 10000;

    }

    @Override
    public void depositMoney(float amount) {
        if (active) {
            super.depositMoney(amount);
        }
    }

    @Override
    public void withdrawMoney(float amount) {
        if (active) {
            super.withdrawMoney(amount);
        }
    }

    @Override
    public void monthlyStatement() {
        if (withdrawal > 4) {
            int additionalWithdrawals = withdrawal - 4;
            monthlyCommission = additionalWithdrawals * 1000;
        }
        super.monthlyStatement();
        active = balance >= 10000;

    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("balance: ").append(balance).append(", ");
        sb.append("monthlyCommission: ").append(monthlyCommission).append(", ");
        sb.append("transactions: ").append(consignments + withdrawal).append(", ");
        return sb.toString();
    }
}
