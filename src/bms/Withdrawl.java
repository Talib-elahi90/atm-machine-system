package bms;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {

    JButton withdraw, back;
    JTextField amount;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
//      Image Icon  
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = i1.getImage().getScaledInstance(800, 780, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(image);
        JLabel atmImage = new JLabel(atmIcon);
        atmImage.setBounds(0, 0, 800, 780);
        add(atmImage);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(150, 240, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        atmImage.add(text);

//      Buttons  
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(340, 410, 110, 30);
        withdraw.addActionListener(this);
        atmImage.add(withdraw);

        back = new JButton("Back");
        back.setBounds(340, 445, 110, 30);
        back.addActionListener(this);
        atmImage.add(back);

//      TextField 
        amount = new JTextField();
        amount.setBounds(150, 280, 300, 25);
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        add(amount);

//      Frame
        setSize(800, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw) {
            String dpst = amount.getText();
            Date date = new Date();
            if (dpst.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            } else {
                try {
                    Connect conn = new Connect();
                    String query = "insert into bank values ('" + pinnumber + "', '" + date + "', 'Withdrawl', '" + dpst + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs, "+dpst+" Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }

    }
}
