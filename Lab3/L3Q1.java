/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

/**
 *
 * @author Neuu
 */

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JOptionPane;

public class L3Q1 {
    private JTable table;

    public L3Q1() {
        JFrame frame = new JFrame("Neuu TabbedPanel");

        JTabbedPane pane = new JTabbedPane();
        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel();
        JPanel pn3 = new JPanel();

        pn1.setBackground(Color.red);
        pn2.setBackground(Color.green);
        pn3.setBackground(Color.cyan);

        pane.addTab("Home", pn1);
        pane.addTab("Profile", pn2);
        pane.addTab("Settings", pn3);

        // Adding JTable inside the Profile pane
       Object[][] data = {
            {"Niwesh Waiba", 21, "Male"},
            {"Alone Balami", 22, "Male"},
            {"Abhiyan Khadka", 21, "Male"}
        };
        String[] columnNames = {"Name", "Age", "Gender"};
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        pn2.setLayout(new BorderLayout());
        pn2.add(scrollPane, BorderLayout.CENTER);

        frame.add(pane, BorderLayout.CENTER);

        // Adding toggle button with ActionListener
        JToggleButton loginToggleButton = new JToggleButton("Login");
        loginToggleButton.addActionListener(e -> {
            if (loginToggleButton.isSelected()) {
                // Show JOptionPane dialog boxes
                JOptionPane.showMessageDialog(frame, "Login button pressed!", "Information", JOptionPane.INFORMATION_MESSAGE);

                int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    String input = JOptionPane.showInputDialog(frame, "Please enter your name:", "Input Dialog", JOptionPane.QUESTION_MESSAGE);
                    if (input != null && !input.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Welcome, " + input + "!", "Welcome Dialog", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        frame.add(loginToggleButton, BorderLayout.SOUTH);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new L3Q1();
    }
}
