package week6;

public class Employee extends StaffMenber {
    protected String socialSecurityNumber;
    protected double payRate;

    public Employee (String eName, String eAddress,String ePhone,String socialSecNumber, double rate) {
        super(eName, eAddress, ePhone);

        socialSecurityNumber = socialSecNumber;
        payRate = rate;
    }
    public String toString() {
        String result = super.toString();
        result += "\nSocial Security Number: " + socialSecurityNumber;
        return result;
    }
    public double pay(){
        return payRate;
    }
}
