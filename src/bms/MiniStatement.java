package bms;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class MiniStatement extends JFrame {
    JLabel mini, bank, card, balance;
    MiniStatement(String pinnumber) {
        setLayout(null);
        
        mini = new JLabel();
        mini.setBounds(20, 100, 400, 200);
        add(mini);
        
        bank = new JLabel("TI Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        balance = new JLabel();
        balance.setBounds(20, 350, 300, 20);
        add(balance);
        
        try {
            Connect con = new Connect();
            ResultSet rs = con.s.executeQuery("select * from login where pin_number = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+ rs.getString("card_number").substring(0, 4) + "XXXXXXXX"+ rs.getString("card_number").substring(12));
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Connect con = new Connect();
            int blnc = 0;
            ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br><br><html>");
            if(rs.getString("type").equals("Deposit")){
                blnc += Integer.parseInt(rs.getString("amount"));
            } else {
                blnc -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current balance Rs: "+ blnc);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        setTitle("Mini Statement");
        setSize(400, 500);
        setLocation(20, 20);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

}
