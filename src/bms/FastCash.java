package bms;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {
    
    JButton fivehun, thousand, twentyfive, fivetho, sevenfive, tentho, back;
    String pinnumber;

    public FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
//      Display Image   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = i1.getImage().getScaledInstance(750, 780, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(image);
        JLabel atmImage = new JLabel(atmIcon);
        atmImage.setBounds(0, 0, 750, 780);
        add(atmImage);
        
        JLabel text = new JLabel("Select Withdrawl Amount:");
        text.setBounds(150, 240, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        atmImage.add(text);
//  fivehun, thousand, twentyfive, fivetho, sevenfive, tentho, back
//      Buttons   
        fivehun = new JButton("Rs 500");
        fivehun.setBounds(130, 310, 130, 30);
        fivehun.addActionListener(this);
        atmImage.add(fivehun);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(280, 310, 130, 30);
        thousand.addActionListener(this);
        atmImage.add(thousand);
        
        twentyfive = new JButton("Rs 2500");
        twentyfive.setBounds(130, 350, 130, 30);
        twentyfive.addActionListener(this);
        atmImage.add(twentyfive);
        
        fivetho = new JButton("Rs 5000");
        fivetho.setBounds(280, 350, 130, 30);
        fivetho.addActionListener(this);
        atmImage.add(fivetho);
        
        sevenfive = new JButton("Rs 7500");
        sevenfive.setBounds(130, 390, 130, 30);
        sevenfive.addActionListener(this);
        atmImage.add(sevenfive);
        
        tentho = new JButton("Rs 10000");
        tentho.setBounds(280, 390, 130, 30);
        tentho.addActionListener(this);
        atmImage.add(tentho);
        
        back = new JButton("Back");
        back.setBounds(280, 430, 130, 30);
        back.addActionListener(this);
        atmImage.add(back);
        
//      Frame
        setSize(750, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FastCash("");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Connect con = new Connect();
            try {
                ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    
                    if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    
                    Date date = new Date();
                    String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                    con.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Rs: "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
        }
    }
}
