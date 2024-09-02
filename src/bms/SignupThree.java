package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;
import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton saving, current, fixed, recurring;
    ButtonGroup groupAccount;
    JCheckBox atmcard, internetbanking, mobilebanking, smsalert, chequebook, estatement, declaration;
    JButton submit, cancel;
    String formno;
    
    public SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel label1 = new JLabel("Page 3: Account Detail");
        label1.setBounds(240, 30, 400, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label1);

        JLabel type = new JLabel("Account Type");
        type.setBounds(100, 110, 200, 30);
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway", Font.BOLD, 14));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100, 150, 150, 20);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway", Font.BOLD, 14));
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(350, 150, 250, 20);
        add(fixed);

        current = new JRadioButton("Current");
        current.setFont(new Font("Raleway", Font.BOLD, 14));
        current.setBackground(Color.WHITE);
        current.setBounds(100, 190, 150, 20);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 14));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(350, 190, 250, 20);
        add(recurring);

        groupAccount = new ButtonGroup();
        groupAccount.add(saving);
        groupAccount.add(fixed);
        groupAccount.add(current);
        groupAccount.add(recurring);

        JLabel card = new JLabel("Card Number");
        card.setBounds(100, 250, 200, 30);
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-0000");
        number.setBounds(330, 250, 400, 30);
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        add(number);

        JLabel message = new JLabel("Your 16 Digits Card Number");
        message.setBounds(100, 280, 400, 20);
        message.setFont(new Font("Raleway", Font.BOLD, 12));
        add(message);

        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100, 310, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);

        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setBounds(330, 310, 400, 30);
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pinnumber);

        JLabel pinmessage = new JLabel("Your 4 Digit pin Number");
        pinmessage.setBounds(100, 340, 400, 20);
        pinmessage.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pinmessage);

        JLabel services = new JLabel("Services Required:");
        services.setBounds(100, 400, 400, 20);
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        add(services);

        atmcard = new JCheckBox("ATM CARD");
        atmcard.setBounds(100, 450, 200, 30);
        atmcard.setFont(new Font("Raleway", Font.BOLD, 16));
        atmcard.setBackground(Color.WHITE);
        add(atmcard);

        internetbanking = new JCheckBox("Internet Banking");
        internetbanking.setBounds(350, 450, 200, 30);
        internetbanking.setFont(new Font("Raleway", Font.BOLD, 16));
        internetbanking.setBackground(Color.WHITE);
        add(internetbanking);

        mobilebanking = new JCheckBox("Mobile Banking");
        mobilebanking.setBounds(100, 500, 200, 30);
        mobilebanking.setFont(new Font("Raleway", Font.BOLD, 16));
        mobilebanking.setBackground(Color.WHITE);
        add(mobilebanking);

        smsalert = new JCheckBox("E-Mail & SMS Alert");
        smsalert.setBounds(350, 500, 200, 30);
        smsalert.setFont(new Font("Raleway", Font.BOLD, 16));
        smsalert.setBackground(Color.WHITE);
        add(smsalert);

        chequebook = new JCheckBox("Cheque Book");
        chequebook.setBounds(100, 550, 200, 30);
        chequebook.setFont(new Font("Raleway", Font.BOLD, 16));
        chequebook.setBackground(Color.WHITE);
        add(chequebook);

        estatement = new JCheckBox("E-Statement");
        estatement.setBounds(350, 550, 200, 30);
        estatement.setFont(new Font("Raleway", Font.BOLD, 16));
        estatement.setBackground(Color.WHITE);
        add(estatement);

        declaration = new JCheckBox("I Hereby declare entered details are correct");
        declaration.setBounds(100, 600, 600, 30);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBackground(Color.WHITE);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBounds(220, 650, 100, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 12));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(370, 650, 100, 30);
        cancel.setFont(new Font("Raleway", Font.BOLD, 12));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setLocation(300, 0);
        setSize(800, 750);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == submit) {
            String accountType = null;
            
            if (saving.isSelected()) {
                accountType = "Saving Account";
            } else if (fixed.isSelected()) {
                accountType = "Faxid Deposit Account";
            } else if (current.isSelected()) {
                accountType = "CurrentAccount";
            } else if (recurring.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 509427000000000L);

            String pinno = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

//      atmcard, internetbanking, smsalert, chequebook, estatement, declaration
            String facility = "";

            if (atmcard.isSelected()) {
                facility = facility + " ATM Card";
            } else if (internetbanking.isSelected()) {
                facility = facility + " Internet Banking";
            } else if (smsalert.isSelected()) {
                facility = facility + " E-mail & SMS Alert";
            } else if (chequebook.isSelected()) {
                facility = facility + " Cheque Book";
            } else if (estatement.isSelected()) {
                facility = facility + " E-Statement";
            } else if (mobilebanking.isSelected()) {
                facility = facility + " Mobile Banking";
            } 
            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else {
                    Connect connect = new Connect();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardno+"', '"+pinno+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardno+"', '"+pinno+"')";
                    connect.s.executeUpdate(query1);
                    connect.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Your card Number is: "+cardno+"\n Pin: "+pinno);
                    
                    setVisible(false);
                    new Deposit(pinno).setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
