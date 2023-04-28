package view;

import entity.Users;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainForm {
    private JTextField userField;
    private JButton registrasiButton;
    private JButton masukButton;
    private JPasswordField passwordField;
    private JCheckBox tampilPass;
    JPanel rootPanel;
    private JButton lihatAkunButton;
    private static JFrame frame = new JFrame("Login Form");
    public MainForm() {
        List<Users> users = new ArrayList<>();

        tampilPass.addActionListener(e -> {
            char echoChar = passwordField.getEchoChar();
            if (tampilPass.isSelected() && echoChar != 0) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });

        masukButton.addActionListener(e -> {
            boolean isSuccess = false, found = false;
            for (Users user : users) {
                if (user.getName().contains(userField.getText())) {
                    found = true;

                    if (user.getName().contains(userField.getText()) && user.getPass().contains(new String(passwordField.getPassword()))) {
                        isSuccess = true;
                    }

                    break;
                }
            }

            if (found) {
                if (isSuccess) {
                    frame.setVisible(false);
                    DashboardForm dashboardForm = new DashboardForm(userField.getText());
                    dashboardForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(rootPanel,
                            "Password Anda Salah",
                            "Login Gagal",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } else {
                JOptionPane.showMessageDialog(rootPanel,
                        "Akun tidak ada, harap Registrasi dahulu",
                        "Login Gagal", JOptionPane.ERROR_MESSAGE
                );
            }
        });

        registrasiButton.addActionListener(e -> {
            boolean isExists = false;
            for (Users user : users) {
                if (user.getName().contains(userField.getText())) {
                    isExists = true;
                }
            }

            if (!isExists) {
                Users user = new Users();
                user.setName(userField.getText());
                user.setPass(new String(passwordField.getPassword()));
                users.add(user);

                JOptionPane.showMessageDialog(rootPanel, "Akun berhasil Registrasi", "Berhasil Registrasi", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPanel, "Akun sudah terdaftar", "Gagal Registrasi", JOptionPane.ERROR_MESSAGE);
            }

        });

        lihatAkunButton.addActionListener(e -> {
            frame.setVisible(false);
            TableAccountForm table = new TableAccountForm(users);
            table.setVisible(true);
        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new MainForm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void setVisible(boolean isVisible) {
        frame.setVisible(isVisible);
    }


}
