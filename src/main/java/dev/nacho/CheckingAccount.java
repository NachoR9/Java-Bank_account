package dev.nacho;

public class CheckingAccount extends BankAccount {

    private float overdraft = 0;

    public CheckingAccount(float balance, float annualRate) {
        super(balance, annualRate);
    }

    @Override
    public void withdrawMoney(float amount) {
        if (amount > balance) {
            overdraft = amount - balance;

        }
        balance -= amount;

    }

    @Override
    public void depositMoney(float amount) {
        super.depositMoney(amount);
        if (overdraft > 0) {
            overdraft = Math.max(overdraft - amount, 0);
        }
    }

    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public void monthlyStatement() {
        super.monthlyStatement();
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("balance: ").append(balance).append(", ");
        sb.append("monthlyCommission: ").append(monthlyCommission).append(", ");
        sb.append("transactions: ").append(consignments + withdrawal).append(", ");
        sb.append("overdraft: ").append(overdraft).append(", ");
        return sb.toString();

    }
}
