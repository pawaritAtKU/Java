import java.sql.*;
import java.util.Random;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:bank_system.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to SQLite database!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    // ตรวจสอบว่ามี card_number นี้แล้วหรือยัง
    public static boolean isCardNumberExists(String cardNumber) {
        String sql = "SELECT COUNT(*) FROM users WHERE card_number = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cardNumber);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            System.out.println("Error checking card number: " + e.getMessage());
        }
        return false;
    }

    // เพิ่มข้อมูลผู้ใช้
    public static void insertUser(String name, String pin, String birthdate, String gender, String address, String district, String province, String postalCode, String cardNumber, double balance) {
        if (isCardNumberExists(cardNumber)) {
            System.out.println("Error: Card number " + cardNumber + " already exists!");
            return;
        }

        String sql = "INSERT INTO users (name, pin, birthdate, gender, address, district, province, postal_code, card_number, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, pin);
            pstmt.setString(3, birthdate);
            pstmt.setString(4, gender);
            pstmt.setString(5, address);
            pstmt.setString(6, district);
            pstmt.setString(7, province);
            pstmt.setString(8, postalCode);
            pstmt.setString(9, cardNumber);
            pstmt.setDouble(10, balance);
            pstmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + e.getMessage());
        }
    }

    // ดึงข้อมูลผู้ใช้จากฐานข้อมูลด้วยหมายเลขบัตร
    public static User getUserByCardNumber(String cardNumber) {
        String sql = "SELECT * FROM users WHERE card_number = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cardNumber);
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
            System.out.println("Error fetching user: " + e.getMessage());
        }
        return null;
    }

    // สุ่มหมายเลขบัตรที่ไม่ซ้ำ
    public static String generateUniqueCardNumber() {
        Random rand = new Random();
        String cardNumber;
        do {
            cardNumber = String.format("%05d", rand.nextInt(100000));
        } while (isCardNumberExists(cardNumber));
        return cardNumber;
    }

    // แสดงข้อมูลผู้ใช้ทั้งหมด
    public static void fetchUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Card Number: " + rs.getString("card_number"));
                System.out.println("Balance: " + rs.getDouble("balance"));
                System.out.println("----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching users: " + e.getMessage());
        }
    }

    // ล้างข้อมูลทั้งหมดในฐานข้อมูล
    public static void clearDatabase() {
        String sql = "DELETE FROM users";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("All data deleted from database!");
        } catch (SQLException e) {
            System.out.println("Error clearing database: " + e.getMessage());
        }
    }
}
