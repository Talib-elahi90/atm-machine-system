package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
    JLabel welName, cardno, pin;
    JTextField cardnameField;
    JPasswordField pinField;
    JButton loginButton, clearButton, signupButton;
    Login(){
        setLayout(null);
//      Set Icon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image setIconImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(setIconImage);
        JLabel iconLabel = new JLabel(icon2);
        iconLabel.setBounds(70, 10, 100, 100);
        add(iconLabel);

//      WelCome Name        
        welName = new JLabel("WELCOME TO ATM");
        welName.setFont(new Font("Osward", Font.BOLD, 38));
        welName.setBounds(200,40,450,40);
        add(welName);
        
//      Card Number  
        cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(125,150,375,30);
        add(cardno);

//      Card Number Text Field  
        cardnameField = new JTextField();
        cardnameField.setBounds(300,150,230,30);
        cardnameField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardnameField);
        
//      Pin  
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125,220,375,30);
        add(pin);
        
//      Pin Text Field
        pinField = new JPasswordField(15);
        pinField.setFont(new Font("Arial", Font.BOLD, 14));
        pinField.setBounds(300,220,230,30);
        add(pinField);
        
//      Sign-in Button         
        loginButton = new JButton("SIGN IN");
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBounds(300,300,100,30);
        loginButton.addActionListener(this);
        add(loginButton);
        
//      Clear Button  
        clearButton = new JButton("CLEAR");
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setBounds(430,300,100,30);
        add(clearButton);
        
//      Sign-up Button   
        signupButton = new JButton("SIGN UP");
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);        
        signupButton.setFont(new Font("Arial", Font.BOLD, 14));
        signupButton.setBounds(300,350,230,30);
        add(signupButton);
        
//      Add Action Listner  
        signupButton.addActionListener(this);
        clearButton.addActionListener(this);
        
//      Set Frame
        setTitle("ATM Machine");
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 500);
        setLocation(300, 100);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clearButton){
            cardnameField.setText("");
            pinField.setText("");
            
        }else if(ae.getSource() == loginButton){
            Connect con = new Connect();
            String cardnumber = cardnameField.getText();
            String pinnumber = pinField.getText();
            
            String query = "select * from login where card_number = '"+cardnumber+"' and pin_number ='"+pinnumber+"'";
            
            try {
                ResultSet rs = con.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == signupButton){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

}
