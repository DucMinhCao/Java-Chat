package GUI;

import DAO.UserDAO;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame {

    private JFrame jFrame;
    private JLabel usernameLable;
    private JLabel passworldLable;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JButton submitButton;
    private JButton clearButton;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel mainPanel;
    private JPanel bottomPanel;

    public RegisterFrame() {
        InitComponent();
    }

    private void InitComponent() {
        jFrame = new JFrame("Register");
        jFrame.setBounds(100, 100, 500, 230);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLable = new JLabel("Username");
        usernameLable.setPreferredSize(new Dimension(100, 50));
        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(200, 50));

        passworldLable = new JLabel("Password");
        passworldLable.setPreferredSize(new Dimension(200, 20));
        passwordTextField = new JPasswordField();
        passwordTextField.setPreferredSize(new Dimension(200, 20));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 40));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDAO userDAO = new UserDAO();
                String username = usernameTextField.getText();
                String password = new String(passwordTextField.getPassword());
                User user = new User(username, password);
                userDAO.saveUser(user);
            }
        });

        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(100, 40));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameTextField.setText("");
                passwordTextField.setText("");
            }
        });

        leftPanel = new JPanel();
        rightPanel = new JPanel();
        mainPanel = new JPanel();
        bottomPanel = new JPanel();

        leftPanel.setLayout(new GridLayout(2, 1, 5, 5));
        leftPanel.add(usernameLable);
        leftPanel.add(passworldLable);

        rightPanel.setLayout(new GridLayout(2, 1, 0, 10));
        rightPanel.add(usernameTextField);
        rightPanel.add(passwordTextField);

        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        bottomPanel.add(submitButton);
        bottomPanel.add(clearButton);

        jFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        jFrame.getContentPane().add(bottomPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RegisterFrame window = new RegisterFrame();
                window.jFrame.setVisible(true);
            }
        });
    }
}
