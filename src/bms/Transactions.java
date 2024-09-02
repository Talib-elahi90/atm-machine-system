package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;

    public Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
//      Display Image   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = i1.getImage().getScaledInstance(750, 780, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(image);
        JLabel atmImage = new JLabel(atmIcon);
        atmImage.setBounds(0, 0, 750, 780);
        add(atmImage);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(150, 240, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        atmImage.add(text);

//      Buttons   
        deposit = new JButton("Deposit");
        deposit.setBounds(130, 310, 130, 30);
        deposit.addActionListener(this);
        atmImage.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(280, 310, 130, 30);
        withdrawl.addActionListener(this);
        atmImage.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(130, 350, 130, 30);
        fastcash.addActionListener(this);
        atmImage.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(280, 350, 130, 30);
        ministatement.addActionListener(this);
        atmImage.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(130, 390, 130, 30);
        pinchange.addActionListener(this);
        atmImage.add(pinchange);
        
        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(280, 390, 130, 30);
        balanceenquiry.addActionListener(this);
        atmImage.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(280, 425, 130, 30);
        exit.addActionListener(this);
        atmImage.add(exit);

//      Frame
        setSize(750, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Transactions("");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if(ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
}
