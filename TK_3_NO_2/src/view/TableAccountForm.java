package view;

import entity.Users;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableAccountForm {
    private JPanel tablePanel;
    private JTable tableAccount;
    private JButton backLogin;
    private static JFrame frame = new JFrame("Record Akun");

    public TableAccountForm(List<Users> tableData) {
        UserTableModel userTableModel = new UserTableModel(tableData);
        tableAccount.setModel(userTableModel);
        tableAccount.setAutoCreateRowSorter(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(tablePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);

        backLogin.addActionListener(e -> {
            frame.setVisible(false);
            MainForm mainForm = new MainForm();
            mainForm.setVisible(true);
        });
    }

    public void setVisible(boolean isVisible) {
        frame.setVisible(isVisible);
    }

    private static class UserTableModel extends AbstractTableModel {

        private final String[] COLUMNS = {"USERNAME", "PASSWORD"};
        private List<Users> users;

        private UserTableModel(List<Users> users) {
            this.users = users;
        }

        @Override
        public int getRowCount() {
            return users.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMNS.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (users.size() > 0) {
                return switch (columnIndex) {
                    case 0 -> users.get(rowIndex).getName();
                    case 1 -> users.get(rowIndex).getPass();
                    default -> "-";
                };
            } else {
                return  null;
            }
        }

        @Override
        public String getColumnName(int column) {
            return COLUMNS[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (getValueAt(0, columnIndex) != null) {
                return getValueAt(0, columnIndex).getClass();
            }else {
                return Object.class;
            }
        }
    }
}
