/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

/**
 *
 * @author Neuu
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class L3Q2 implements ActionListener {

    JTextField fn, ln, ad, en;
    JRadioButton m, fe;
    ButtonGroup gen;
    JComboBox<String> bg;

    public L3Q2() {
        JFrame f = new JFrame("Neuu Medic");
        f.setSize(400, 400);
        f.setLayout(null);

        JLabel lb1 = new JLabel("First Name:");
        lb1.setBounds(20, 20, 80, 20);
        fn = new JTextField();
        fn.setBounds(100, 20, 160, 20);
        f.add(fn);
        f.add(lb1);

        JLabel lb2 = new JLabel("Last Name:");
        lb2.setBounds(20, 40, 80, 20);
        ln = new JTextField();
        ln.setBounds(100, 40, 160, 20);
        f.add(ln);
        f.add(lb2);

        JLabel lb3 = new JLabel("Address:");
        lb3.setBounds(20, 60, 80, 20);
        ad = new JTextField();
        ad.setBounds(100, 60, 160, 20);
        f.add(ad);
        f.add(lb3);

        JLabel lb4 = new JLabel("Gender:");
        lb4.setBounds(20, 80, 80, 20);

        m = new JRadioButton("Male");
        m.setBounds(100, 80, 80, 20);
        f.add(m);

        fe = new JRadioButton("Female");
        fe.setBounds(190, 80, 80, 20);
        f.add(fe);

       

        gen = new ButtonGroup();
        gen.add(m);
        gen.add(fe);
       
        f.add(lb4);

        JLabel lb5 = new JLabel("Email:");
        lb5.setBounds(20, 100, 80, 20);
        en = new JTextField();
        en.setBounds(100, 100, 160, 20);
        f.add(en);
        f.add(lb5);

        JLabel lb6 = new JLabel("Blood Group:");
        lb6.setBounds(20, 120, 80, 20);
        String[] bg_list = {"Select your blood group", "A+", "B+", "A-", "B-", "AB+", "O+", "O-", "AB-"};
        bg = new JComboBox<>(bg_list);
        bg.setBounds(100, 120, 160, 20);
        f.add(bg);
        f.add(lb6);

        JButton submit = new JButton("Submit");
        submit.setBounds(60, 140, 80, 20);
        submit.addActionListener(this);
        f.add(submit);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        new L3Q2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fname = fn.getText();
        String lname = ln.getText();
        String address = ad.getText();
        String email = en.getText();
        String blood = bg.getSelectedItem().toString();
        String gender = "";
        if (m.isSelected()) {
            gender = m.getText();
        }
        if (fe.isSelected()) {
            gender = fe.getText();
        }
       
        if (fname.isEmpty() || lname.isEmpty() || address.isEmpty() || email.isEmpty() || blood.equals("Select your blood group") || gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Form Validated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
