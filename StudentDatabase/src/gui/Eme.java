package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Eme {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Student Information");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 400);
    
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(4, 2));
    leftPanel.add(new JLabel("Name: "));
    JTextField nameField = new JTextField();
    leftPanel.add(nameField);
    leftPanel.add(new JLabel("Age: "));
    JTextField ageField = new JTextField();
    leftPanel.add(ageField);
    leftPanel.add(new JLabel("Gender: "));
    JTextField genderField = new JTextField();
    leftPanel.add(genderField);
    leftPanel.add(new JLabel("Address: "));
    JTextField addressField = new JTextField();
    leftPanel.add(addressField);
    
    JButton addButton = new JButton("Add");
    leftPanel.add(addButton);
    
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Name");
    model.addColumn("Age");
    model.addColumn("Gender");
    model.addColumn("Address");
    
    JTable table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = genderField.getText();
        String address = addressField.getText();
        model.addRow(new Object[] {name, age, gender, address});
      }
    });
    
    frame.getContentPane().add(leftPanel, BorderLayout.WEST);
    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
    frame.setVisible(true);
  }
}
