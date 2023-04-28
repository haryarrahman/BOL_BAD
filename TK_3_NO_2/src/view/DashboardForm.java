package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardForm {
    private JLabel labelName;
    private JButton keluarButton;
    private JPanel dashboardPanel;
    private static JFrame frame = new JFrame("Dashboard");

    public DashboardForm(String name) {
        labelName.setText("Haloo " + name + " Apa Kabar ^_^ ?");

        frame.setContentPane(dashboardPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 100);

        keluarButton.addActionListener(e -> {
            frame.setVisible(false);
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
        });
    }

    public void setVisible(boolean isVisible) {
        frame.setVisible(isVisible);
    }
}
