package bms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JRadioButton;

public class SignupTwo extends JFrame implements ActionListener {

    JComboBox religionCombo, categoryCombo, incomeCombo, educationCombo, occupatoinCombo;
    JTextField passField, cnicField;
    JRadioButton male, feMale, yesCitizen, noCitizen, yesExisting, noExisting;
    JButton nextButton;
    ButtonGroup citizenGroup, existiongGroup;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

//      Heading
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(280, 80, 400, 30);
        add(additionalDetails);

//      Religion Name
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

//      Name Combo Box  
        String[] valReligion = {"Muslim", "Hindu", "Christian", "Sikh"};
        religionCombo = new JComboBox(valReligion);
        religionCombo.setBounds(300, 140, 400, 30);
        religionCombo.setBackground(Color.WHITE);
        add(religionCombo);

//      Categoty
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100, 190, 300, 30);
        add(category);

//      Categoty Combo Field  
        String categoryValue[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryCombo = new JComboBox(categoryValue);
        categoryCombo.setBounds(300, 190, 400, 30);
        categoryCombo.setBackground(Color.WHITE);
        add(categoryCombo);

//      Income
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 240, 300, 30);
        add(income);

//      Income Combo  
        String incomeValue[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeCombo = new JComboBox(incomeValue);
        incomeCombo.setBounds(300, 240, 400, 30);
        incomeCombo.setBackground(Color.WHITE);
        add(incomeCombo);

//      Education / Qualification
        JLabel education = new JLabel("Educational");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100, 290, 300, 30);
        add(education);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 22));
        qualification.setBounds(100, 315, 300, 30);
        add(qualification);

//      Educational Combo Box
        String educationalValue[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educationCombo = new JComboBox(educationalValue);
        educationCombo.setBounds(300, 315, 400, 30);
        educationCombo.setBackground(Color.WHITE);
        add(educationCombo);

//      Occupation Status
        JLabel maritalStatus = new JLabel("Occupation: ");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 22));
        maritalStatus.setBounds(100, 390, 300, 30);
        add(maritalStatus);

//      Occupation Combo Box
        String occupatoinValue[] = {"Private Job", "Government Employee", "Self-Employeed", "Business", "Student", "Retired", "Others"};
        occupatoinCombo = new JComboBox(occupatoinValue);
        occupatoinCombo.setBounds(300, 390, 400, 30);
        occupatoinCombo.setBackground(Color.WHITE);
        add(occupatoinCombo);

//      Passport Number
        JLabel passNumber = new JLabel("Passport No: ");
        passNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        passNumber.setBounds(100, 440, 300, 30);
        add(passNumber);

//      Passport Text Field  
        passField = new JTextField();
        passField.setFont(new Font("Arial", Font.BOLD, 14));
        passField.setBounds(300, 440, 400, 30);
        add(passField);

//      CNIC
        JLabel cnic = new JLabel("CNIC: ");
        cnic.setFont(new Font("Raleway", Font.BOLD, 22));
        cnic.setBounds(100, 490, 300, 30);
        add(cnic);

//      CNIC Text Field  
        cnicField = new JTextField();
        cnicField.setFont(new Font("Arial", Font.BOLD, 14));
        cnicField.setBounds(300, 490, 400, 30);
        add(cnicField);

//      Senior Citizen
        JLabel citizen = new JLabel("Senior Citizen: ");
        citizen.setFont(new Font("Raleway", Font.BOLD, 22));
        citizen.setBounds(100, 540, 300, 30);
        add(citizen);

//      Citizen Radio Field
        yesCitizen = new JRadioButton("Yes");
        yesCitizen.setBounds(300, 540, 100, 30);
        yesCitizen.setBackground(Color.WHITE);
        add(yesCitizen);

        noCitizen = new JRadioButton("No");
        noCitizen.setBounds(400, 540, 100, 30);
        noCitizen.setBackground(Color.WHITE);
        add(noCitizen);

        citizenGroup = new ButtonGroup();
        citizenGroup.add(yesCitizen);
        citizenGroup.add(noCitizen);

//      Existing Code
        JLabel existingAccount = new JLabel("Existing Account: ");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 22));
        existingAccount.setBounds(100, 590, 300, 30);
        add(existingAccount);

        yesExisting = new JRadioButton("Yes");
        yesExisting.setBounds(300, 590, 100, 30);
        yesExisting.setBackground(Color.WHITE);
        add(yesExisting);

        noExisting = new JRadioButton("No");
        noExisting.setBounds(400, 590, 100, 30);
        noExisting.setBackground(Color.WHITE);
        add(noExisting);

        existiongGroup = new ButtonGroup();
        existiongGroup.add(yesExisting);
        existiongGroup.add(noExisting);

//      Next
        nextButton = new JButton("Next");
        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Raleway", Font.BOLD, 14));
        nextButton.setBounds(600, 650, 100, 30);
        nextButton.addActionListener(this);
        add(nextButton);

//      Set Frame
        setTitle("APPLICATION FORM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(300, 10);
        setSize(800, 800);
    }

    public void actionPerformed(ActionEvent ae) {
        String relig = (String) religionCombo.getSelectedItem();
        String categ = (String) categoryCombo.getSelectedItem();
        String incomeString = (String) incomeCombo.getSelectedItem();
        String educationString = (String) educationCombo.getSelectedItem();
        String occupatoinString = (String) occupatoinCombo.getSelectedItem();
        String seniorcitizen = null;
        if (yesCitizen.isSelected()) {
            seniorcitizen = "Yes";
        } else if (noCitizen.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (yesExisting.isSelected()) {
            existingaccount = "Yes";
        } else if (yesExisting.isSelected()) {
            existingaccount = "No";
        }

        String passport = passField.getText();
        String cnic = cnicField.getText();

        try {
            Connect conn = new Connect();
            String query = "insert into signuptwo values ('" + formno + "', '" + relig + "', '" + categ + "', '" + incomeString + 
                    "', '" + educationString + "', '" + occupatoinString + "', '" + passport + "', '" + cnic + "', '"+ existingaccount +"', '" + seniorcitizen +"')";
            conn.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
