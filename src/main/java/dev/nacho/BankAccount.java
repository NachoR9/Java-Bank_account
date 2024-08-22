package dev.nacho;

public class BankAccount {
    protected float balance;
    protected int consignments = 0;
    protected int withdrawal = 0;
    protected float annualRate;
    protected float monthlyCommission = 0;
    
    public BankAccount(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public void depositMoney(float amount) {
        if (amount<=0) {
            return;
        }
        balance += amount;
            consignments++;
    }

    public void withdrawMoney(float amount) {
        if (amount>balance || amount<0) {
            return;
        }
        balance -= amount;
    }

    public void monthlyInterest() {
        float monthlyRate = annualRate / 12 / 100;
        float monthlyInterest = balance * monthlyRate;
        balance += monthlyInterest;
        
    }

    public void monthlyStatement() {
        balance -= monthlyCommission;
        monthlyInterest();
        
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("balance: ").append(balance).append(", ");
        sb.append("consignments: ").append(consignments).append(", ");
        sb.append("withdrawal: ").append(withdrawal).append(", ");
        sb.append("annualRate: ").append(annualRate).append(", ");
        sb.append("monthlyCommission: ").append(monthlyCommission).append(", ");
        return sb.toString();
    }
}
