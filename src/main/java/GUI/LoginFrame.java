package GUI;

import DAO.UserDAO;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame {

    private UserDAO userDAO = new UserDAO();
    private JFrame jFrame;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel userNameLable;
    private JLabel passwordLable;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;

    public void InitComponent() {
        jFrame = new JFrame("Login");
        jFrame.setBounds(100, 100, 500, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton = new JButton("Login");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.decode("#2db1ff"));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordTextField.getPassword());
                User user = userDAO.getUserByUsername(username);
                if (!password.equals(user.getPassWord())) {
                    JOptionPane.showMessageDialog(null, "Wrong Password");
                } else {
                    JOptionPane.showMessageDialog(null, "Login successful");
                }
            }
        });

        registerButton = new JButton("Register");
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(Color.RED);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        userNameLable = new JLabel("Username");
        usernameTextField = new JTextField();

        passwordLable = new JLabel("Password");
        passwordTextField = new JPasswordField();

        userNameLable.setBounds(80, 70, 200, 30);
        passwordLable.setBounds(80, 110, 200, 30);
        usernameTextField.setBounds(150, 70, 250, 30);
        passwordTextField.setBounds(150, 110, 250, 30);
        loginButton.setBounds(150, 150, 100, 50);
        registerButton.setBounds(300, 150, 100, 50);

        jFrame.getContentPane().add(userNameLable);
        jFrame.getContentPane().add(usernameTextField);
        jFrame.getContentPane().add(passwordLable);
        jFrame.getContentPane().add(passwordTextField);
        jFrame.getContentPane().add(loginButton);
        jFrame.getContentPane().add(registerButton);

        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    public LoginFrame() {
        InitComponent();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginFrame login = new LoginFrame();
                login.jFrame.setVisible(true);
            }
        });
    }
}
