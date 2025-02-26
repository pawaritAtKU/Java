package Project;

class User {
    private String name, pin, birthdate, gender, address, district, province, postalCode, cardNumber;
    private Account account;

    public User(String name, String pin, String birthdate, String gender, String address, String district, String province, String postalCode, String cardNumber, Account account) {
        this.name = name;
        this.pin = pin;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.district = district;
        this.province = province;
        this.postalCode = postalCode;
        this.cardNumber = cardNumber;
        this.account = account;
    }

    public String getCardNumber() { return cardNumber; }
    public boolean validatePin(String inputPin) { return this.pin.equals(inputPin); }

    public String getName() { return name; }
    public String getBirthdate() { return birthdate; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public String getDistrict() { return district; }
    public String getProvince() { return province; }
    public String getPostalCode() { return postalCode; }
    public Account getAccount() { return account; }
}
