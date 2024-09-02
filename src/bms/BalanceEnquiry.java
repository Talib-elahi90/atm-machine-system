package bms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    public BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i1 = icon.getImage().getScaledInstance(750, 780, Image.SCALE_DEFAULT);
        ImageIcon atmicon = new ImageIcon(i1);
        JLabel atmImage = new JLabel(atmicon);
        atmImage.setBounds(0, 0, 750, 780);
        add(atmImage);

        back = new JButton("BACK");
        back.setBounds(290, 440, 130, 30);
        back.addActionListener(this);
        atmImage.add(back);

        Connect con = new Connect();
        int balance = 0;
        try {
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your current account balance is: "+balance);
        text.setBounds(150, 250, 400, 30);
        text.setForeground(Color.WHITE);
        atmImage.add(text);
//      Frame
        setSize(750, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

}
