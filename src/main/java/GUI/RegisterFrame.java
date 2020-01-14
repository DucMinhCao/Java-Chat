package GUI;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame {

    private JFrame jFrame;
    private JLabel usernameLable;
    private JLabel passworldLable;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
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
        jFrame.setBounds(100, 100, 300, 130);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLable = new JLabel("Username");
        usernameLable.setPreferredSize(new Dimension(100, 20));
        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(100, 20));

        passworldLable = new JLabel("Password");
        passworldLable.setPreferredSize(new Dimension(100, 20));
        passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(100, 20));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 20));

        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(100, 20));

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
