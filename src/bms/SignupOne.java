package bms;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupOne extends JFrame implements ActionListener{
    Long random;
    JTextField nameField, fnameField, mailField, addressField, cityField, stateField, pinField;
    JDateChooser date;
    JRadioButton male, feMale, married, unMarried, others;
    JButton nextButton;
    
    SignupOne(){        
        setLayout(null);
        
//      Form Number
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 900L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO: "+ random);
        formno.setFont(new Font("Raleway", Font.BOLD, 34));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
//      Personal Details
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(280, 80, 400, 30);
        add(personalDetails);
        
//      Name
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
//      Name Text Field  
        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        nameField.setBounds(300, 140, 400, 30);
        add(nameField);
        
//      Father Name
        JLabel fname = new JLabel("Father Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 300, 30);
        add(fname);
        
//      Father Name Text Field  
        fnameField = new JTextField();
        fnameField.setFont(new Font("Arial", Font.BOLD, 14));
        fnameField.setBounds(300, 190, 400, 30);
        add(fnameField);
        
//      DOB
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 300, 30);
        add(dob);
    
//        Date And Time
        date = new JDateChooser();
        date.setBounds(300, 240, 400, 30);
        date.setForeground(Color.BLACK);
        add(date);
        
//      Gender
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 300, 30);
        add(gender);
        
//      Radio Button for male and Female
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        feMale = new JRadioButton("Female");
        feMale.setBounds(430, 290, 100, 30);
        feMale.setBackground(Color.WHITE);
        add(feMale);
        
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(feMale);
        
//      E-mail
        JLabel email = new JLabel("E-mail: ");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 300, 30);
        add(email);
        
//      Mail Text Field  
        mailField = new JTextField();
        mailField.setFont(new Font("Arial", Font.BOLD, 14));
        mailField.setBounds(300, 340, 400, 30);
        add(mailField);        
        
//      Marital Status
        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 22));
        maritalStatus.setBounds(100, 390, 300, 30);
        add(maritalStatus);
        
//      Radio Button for Matital Status
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unMarried = new JRadioButton("Unmarried");
        unMarried.setBounds(430, 390, 100, 30);
        unMarried.setBackground(Color.WHITE);
        add(unMarried);
        
        others = new JRadioButton("Others");
        others.setBounds(600, 390, 150, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup marriedGroup = new ButtonGroup();
        marriedGroup.add(married);
        marriedGroup.add(unMarried);
        marriedGroup.add(others);
        
//      Address
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 300, 30);
        add(address);
        
//      Address Text Field  
        addressField = new JTextField();
        addressField.setFont(new Font("Arial", Font.BOLD, 14));
        addressField.setBounds(300, 440, 400, 30);
        add(addressField); 
        
//      City
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 300, 30);
        add(city);
        
//      City Text Field  
        cityField = new JTextField();
        cityField.setFont(new Font("Arial", Font.BOLD, 14));
        cityField.setBounds(300, 490, 400, 30);
        add(cityField); 
        
//      State
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 300, 30);
        add(state);
        
//      State Text Field  
        stateField = new JTextField();
        stateField.setFont(new Font("Arial", Font.BOLD, 14));
        stateField.setBounds(300, 540, 400, 30);
        add(stateField); 
        
//      Pin Code
        JLabel pin = new JLabel("Pin Code: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 590, 300, 30);
        add(pin);
        
//      Pin Text Field  
        pinField = new JTextField();
        pinField.setFont(new Font("Arial", Font.BOLD, 14));
        pinField.setBounds(300, 590, 400, 30);
        add(pinField); 
        
//      Next
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Raleway", Font.BOLD, 14));
        nextButton.setBounds(600, 650, 100, 30);
        nextButton.addActionListener(this);
        add(nextButton);
        
//      Set Frame
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300,10);
        setSize(800, 800);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(feMale.isSelected()){
            gender = "Female";
        }
        
        String mail = mailField.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        }
        else if(unMarried.isSelected()){
            maritalStatus = "Unmarried";
        }
        else if(others.isSelected()){
            maritalStatus = "Other";
        }
        
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pin = pinField.getText();
        
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father Name is required");
                
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter Date of Birth");
            }
            else if(gender.equals("")){
                JOptionPane.showMessageDialog(null, "Select Gender");
            }
            else if(mail.equals("")){
                JOptionPane.showMessageDialog(null, "Enter E-mail");
            }
            else if(maritalStatus.equals("")){
                JOptionPane.showMessageDialog(null, "Select Marital Status");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Enter home address");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "Enter City");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "Enter State");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Pin");
            }
            else {
                Connect conn = new Connect();
                String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+mail+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                conn.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new SignupOne();
    }
}
