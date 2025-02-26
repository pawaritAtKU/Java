package Project;

import java.sql.*;

public class Database {

    public static Connection connect() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:bank_system.db");  // เชื่อมต่อกับฐานข้อมูล SQLite
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    // ฟังก์ชันสำหรับบันทึกข้อมูลผู้ใช้ลงในฐานข้อมูล
    public static void saveUserToDatabase(String name, String pin, String birthdate, String gender, String address,
                                          String district, String province, String postalCode, double balance, String cardNumber) {
        String insertSQL = "INSERT INTO users (name, pin, birthdate, gender, address, district, province, postal_code, balance, card_number) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setString(2, pin);
            pstmt.setString(3, birthdate);
            pstmt.setString(4, gender);
            pstmt.setString(5, address);
            pstmt.setString(6, district);
            pstmt.setString(7, province);
            pstmt.setString(8, postalCode);
            pstmt.setDouble(9, balance);
            pstmt.setString(10, cardNumber);  // บันทึกหมายเลขบัตร
            pstmt.executeUpdate();
            System.out.println("User data saved successfully!");
        } catch (SQLException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    // ฟังก์ชันสำหรับอัปเดตยอดเงินในฐานข้อมูล
    public static void updateBalanceInDatabase(String cardNumber, double newBalance) {
        String updateSQL = "UPDATE users SET balance = ? WHERE card_number = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setDouble(1, newBalance);
            pstmt.setString(2, cardNumber);
            pstmt.executeUpdate();
            System.out.println("Balance updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating balance: " + e.getMessage());
        }
    }

    // ฟังก์ชันสำหรับตรวจสอบการเข้าสู่ระบบ
    public static User getUserByCardNumberAndPin(String cardNumber, String pin) {
        String selectSQL = "SELECT * FROM users WHERE card_number = ? AND pin = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setString(1, cardNumber);
            pstmt.setString(2, pin);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("name"),
                        rs.getString("pin"),
                        rs.getString("birthdate"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getString("district"),
                        rs.getString("province"),
                        rs.getString("postal_code"),
                        rs.getString("card_number"),
                        new Account(rs.getDouble("balance"))
                );
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving user: " + e.getMessage());
        }
        return null;  // ไม่พบผู้ใช้
    }
}
