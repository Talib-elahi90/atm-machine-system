package bms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JLabel text, newpin, repin;
    JPasswordField newPinField, rePinField;
    JButton change, back;
    String pinnumber;

    public PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
//      Display Image   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = i1.getImage().getScaledInstance(750, 780, Image.SCALE_DEFAULT);
        ImageIcon atmIcon = new ImageIcon(image);
        JLabel atmImage = new JLabel(atmIcon);
        atmImage.setBounds(0, 0, 750, 780);
        add(atmImage);

        text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(200, 250, 200, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        atmImage.add(text);

        newpin = new JLabel("New PIN");
        newpin.setBounds(140, 300, 150, 25);
        newpin.setFont(new Font("System", Font.BOLD, 16));
        newpin.setForeground(Color.WHITE);
        atmImage.add(newpin);

        newPinField = new JPasswordField();
        newPinField.setFont(new Font("Raleway", Font.BOLD, 16));
        newPinField.setBounds(270, 300, 150, 25);
        add(newPinField);

        repin = new JLabel("Re-Enter PIN");
        repin.setBounds(140, 340, 150, 25);
        repin.setFont(new Font("System", Font.BOLD, 16));
        repin.setForeground(Color.WHITE);
        atmImage.add(repin);

        rePinField = new JPasswordField();
        rePinField.setFont(new Font("Raleway", Font.BOLD, 16));
        rePinField.setBounds(270, 340, 150, 25);
        add(rePinField);

        change = new JButton("CHANGE");
        change.setBounds(290, 400, 130, 30);
        change.addActionListener(this);
        atmImage.add(change);

        back = new JButton("BACK");
        back.setBounds(290, 440, 130, 30);
        back.addActionListener(this);
        atmImage.add(back);

//      Frame
        setSize(750, 780);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 0);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = newPinField.getText();
                String rpin = rePinField.getText();
                
                if(!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null,  "Enter pin does not match");
                    return;
                }
                
                if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null,  "Please Enter New Pin");
                    return;
                }
                
                if(rpin.equals("")) {
                    JOptionPane.showMessageDialog(null,  "Please re-enter Pin");
                    return;
                }
                
                Connect con = new Connect();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin_number = '"+rpin+"' where pin_number = '"+pinnumber+"'";
                String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";
                
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                con.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null,  "Pin change successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

}
