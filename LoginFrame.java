import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn, registerBtn;

    public LoginFrame() {
        setTitle("Hotel Login");
        setSize(300, 200);
        setLayout(null);

        userField = new JTextField();
        passField = new JPasswordField();
        loginBtn = new JButton("Login");
        registerBtn = new JButton("Register");

        userField.setBounds(100, 30, 150, 20);
        passField.setBounds(100, 60, 150, 20);
        loginBtn.setBounds(30, 100, 100, 30);
        registerBtn.setBounds(150, 100, 100, 30);

        add(new JLabel("Username:")).setBounds(20, 30, 80, 20);
        add(userField);
        add(new JLabel("Password:")).setBounds(20, 60, 80, 20);
        add(passField);
        add(loginBtn);
        add(registerBtn);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (Database.authenticate(user, pass)) {
                dispose();
                new DashboardFrame(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }
        });

        registerBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            Database.register(user, pass);
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
