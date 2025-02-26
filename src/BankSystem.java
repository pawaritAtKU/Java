import javax.swing.*;
import java.awt.*;
import java.util.Random;

class BankSystem {
    public BankSystem() {
        showMainMenu();
    }

    private void showMainMenu() {
        JFrame frame = new JFrame("Bank System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 1, 10, 10));
        frame.getContentPane().setBackground(new Color(200, 255, 200));

        JButton createAccountButton = new JButton("Create Account");
        JButton loginButton = new JButton("Login");
        JButton exitButton = new JButton("Exit");

        Color buttonColor = new Color(50, 150, 50);
        createAccountButton.setBackground(buttonColor);
        createAccountButton.setForeground(Color.WHITE);
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(Color.WHITE);
        exitButton.setBackground(buttonColor);
        exitButton.setForeground(Color.WHITE);

        createAccountButton.addActionListener(e -> {
            frame.dispose();
            showCreateAccount();
        });

        loginButton.addActionListener(e -> {
            frame.dispose();
            showLogin();
        });

        exitButton.addActionListener(e -> System.exit(0));

        frame.add(createAccountButton);
        frame.add(loginButton);
        frame.add(exitButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showCreateAccount() {
        JFrame frame = new JFrame("Create Account");
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(11, 2, 5, 5));
        frame.getContentPane().setBackground(new Color(200, 255, 200));

        JTextField nameField = new JTextField();
        JTextField pinField = new JTextField();
        JTextField birthdateField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField districtField = new JTextField();
        JTextField provinceField = new JTextField();
        JTextField postalCodeField = new JTextField();
        JTextField depositField = new JTextField();
        JButton submitButton = new JButton("Create Account");
        JButton backButton = new JButton("Back");

        submitButton.setBackground(new Color(50, 150, 50));
        submitButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(150, 50, 50));
        backButton.setForeground(Color.WHITE);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String pin = pinField.getText();
            String birthdate = birthdateField.getText();
            String gender = genderField.getText();
            String address = addressField.getText();
            String district = districtField.getText();
            String province = provinceField.getText();
            String postalCode = postalCodeField.getText();
            double balance = Double.parseDouble(depositField.getText());

            String cardNumber = DatabaseManager.generateUniqueCardNumber();
            DatabaseManager.insertUser(name, pin, birthdate, gender, address, district, province, postalCode, cardNumber, balance);
            JOptionPane.showMessageDialog(frame, "Account created successfully!\n  Card Number: " + cardNumber);
            frame.dispose();
            showMainMenu();
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showMainMenu();
        });

        frame.add(new JLabel("Name"));
        frame.add(nameField);
        frame.add(new JLabel("6-digit PIN"));
        frame.add(pinField);
        frame.add(new JLabel("Birthdate (DD/MM/YYYY)"));
        frame.add(birthdateField);
        frame.add(new JLabel("Gender"));
        frame.add(genderField);
        frame.add(new JLabel("Address"));
        frame.add(addressField);
        frame.add(new JLabel("District"));
        frame.add(districtField);
        frame.add(new JLabel("Province"));
        frame.add(provinceField);
        frame.add(new JLabel("Postal Code"));
        frame.add(postalCodeField);
        frame.add(new JLabel("Initial Deposit"));
        frame.add(depositField);
        frame.add(submitButton);
        frame.add(backButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showLogin() {
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2, 5, 5));
        frame.getContentPane().setBackground(new Color(200, 255, 200));

        JTextField cardNumberField = new JTextField();
        JPasswordField pinField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton backButton = new JButton("Back");

        loginButton.setBackground(new Color(50, 150, 50));
        loginButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(150, 50, 50));
        backButton.setForeground(Color.WHITE);

        loginButton.addActionListener(e -> {
            String cardNumber = cardNumberField.getText();
            String pin = new String(pinField.getPassword());

            // ✅ ดึงข้อมูลจากฐานข้อมูล SQLite
            User user = DatabaseManager.getUserByCardNumber(cardNumber);

            if (user != null && user.validatePin(pin)) {
                frame.dispose();
                showDashboard(user);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid card number or PIN", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showMainMenu();
        });

        frame.add(new JLabel("Card Number:"));
        frame.add(cardNumberField);
        frame.add(new JLabel("PIN:"));
        frame.add(pinField);
        frame.add(loginButton);
        frame.add(backButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showDashboard(User user) {
        JFrame frame = new JFrame("Dashboard");
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(5, 1, 5, 5));
        frame.getContentPane().setBackground(new Color(200, 255, 200));

        JButton balanceButton = new JButton("View Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton profileButton = new JButton("View Profile");
        JButton logoutButton = new JButton("Logout");

        balanceButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Balance: " + user.getAccount().getBalance()));
        depositButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter deposit amount:");
            if (input != null) user.getAccount().deposit(Double.parseDouble(input));
        });
        withdrawButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                if (amount > user.getAccount().getBalance()) {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                } else {
                    user.getAccount().withdraw(amount);
                }
            }
        });
        profileButton.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Name: " + user.getName() + "\nBirthdate: " + user.getBirthdate() + "\nGender: " + user.getGender() + "\nAddress: " + user.getAddress() + "\nCard Number: " + user.getCardNumber()));
        logoutButton.addActionListener(e -> {
            frame.dispose();
            showMainMenu();
        });

        frame.add(balanceButton);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(profileButton);
        frame.add(logoutButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
