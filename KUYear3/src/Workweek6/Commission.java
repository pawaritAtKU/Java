package Workweek6;

public class Commission extends Hourly {
    private double totalSales;
    private double commissionRate;

    public Commission(String eName, String eAddress, String ePhone, String socialSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socialSecNumber, rate);
        this.totalSales = 0.0;
        this.commissionRate = commissionRate;
    }
    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }
    @Override
    public double pay() {
        double basePay = super.pay();
        double commissionPay = totalSales * commissionRate;
        totalSales = 0.0;
        return basePay + commissionPay;
    }
    @Override
    public String toString() {
        return super.toString() + "\nTotal Sales: " + totalSales;
    }
}