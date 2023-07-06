/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3;

/**
 *
 * @author Neuu
 */

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class L3Q3 extends JFrame implements ActionListener {

    
    
    JTextField dis;
    JButton[] btnArray = new JButton[16];
    String val1 = "";
    String val2 = "";
    int flag = 0;
    int num1 = 0, num2 = 0;

    public L3Q3() {
        setTitle("Neuu Casio");
        dis = new JTextField("0");
        dis.setBounds(10, 30, 280, 60);
        dis.setEditable(false);
        dis.setHorizontalAlignment(JTextField.RIGHT); 
        Font font = new Font("Arial", Font.BOLD, 20);
        dis.setFont(font);
        add(dis);

        JPanel key = new JPanel();
        key.setBounds(10, 90, 280, 200);
        key.setLayout(new GridLayout(4, 4));

        Character key_val[] = {'7', '8', '9', 'C', '4', '5', '6', '+', '1', '2', '3', '-', '*', '0', '/', '='};
        for (int i = 0; i < 16; i++) {
            String a = key_val[i].toString();
            btnArray[i] = new JButton(a);
            Font font1 = new Font("Arial", Font.PLAIN, 18);
            btnArray[i].setFont(font1);
            key.add(btnArray[i]);
            btnArray[i].addActionListener(this);
        }

        add(key);
        setLayout(null);
        setSize(320, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new L3Q3();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object clk = e.getSource();

        if (clk == btnArray[0]) {
            val2 += "7";
            val1 += "7";
            dis.setText(val2);
        }
        if (clk == btnArray[1]) {
            val2 += "8";
            val1 += "8";
            dis.setText(val2);
        }
        if (clk == btnArray[2]) {
            val2 += "9";
            val1 += "9";
            dis.setText(val2);
        }
        if (clk == btnArray[4]) {
            val2 += "4";
            val1 += "4";
            dis.setText(val2);
        }
        if (clk == btnArray[5]) {
            val2 += "5";
            val1 += "5";
            dis.setText(val2);
        }
        if (clk == btnArray[6]) {
            val2 += "6";
            val1 += "6";
            dis.setText(val2);
        }
        if (clk == btnArray[8]) {
            val2 += "1";
            val1 += "1";
            dis.setText(val2);
        }
        if (clk == btnArray[9]) {
            val2 += "2";
            val1 += "2";
            dis.setText(val2);
        }
        if (clk == btnArray[10]) {
            val2 += "3";
            val1 += "3";
            dis.setText(val2);
        }
        if (clk == btnArray[13]) {
            val2 += "0";
            val1 += "0";
            dis.setText(val2);
        }
        
        if (clk == btnArray[3]) {
            dis.setText("0");
            val2 = "";
            val1 = "";
            num1 = 0;
            num2 = 0;
            flag = 0;
        }
        if (clk == btnArray[7]) {
            num1 = Integer.parseInt(val1);
            val2 += "+";
            val1 = "";
            flag = 1;
            dis.setText(val2);
        }
        if (clk == btnArray[11]) {
            num1 = Integer.parseInt(val1);

            val2 += "-";
            val1 = "";
            flag = 2;
            dis.setText(val2);
        }
        if (clk == btnArray[12]) {
            num1 = Integer.parseInt(val1);
            val2 += "*";
            val1 = "";
            flag = 3;
            dis.setText(val2);            
        }
        
        if (clk == btnArray[14]) {
            num1 = Integer.parseInt(val1);

            val2 += "/";
            val1 = "";
            flag = 4;
            dis.setText(val2);
        }
        if (clk == btnArray[15]) {
            Integer result = 0;
            num2 = Integer.parseInt(val1);
            switch (flag) {
                case 1 -> result = num1 + num2;
                case 2 -> result = num1 - num2;
                case 3 -> result = num1 * num2;
                case 4 -> result = num1 / num2;
                default -> dis.setText("SIN ERROR");
            }
            dis.setText(result.toString());
            val1 = result.toString();
            val2 = result.toString();
        }
    }
}