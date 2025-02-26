package Workweek6;

public class Executive extends Employee {
    private double bonus;

    public Executive(String eName, String eAddress, String ePhone, String socialSecNumber, double rate) {
        super(eName, eAddress, ePhone, socialSecNumber, rate);
        bonus = 0;
    }

    public void awardBonus (double execBonus) {
        bonus = execBonus;
    }

    public double pay() {
        double payment = super.pay();
        bonus = 0;
        return payment;
    }
}