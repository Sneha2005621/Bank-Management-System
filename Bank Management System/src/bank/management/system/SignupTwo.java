package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class SignupTwo extends JFrame implements ActionListener {
        JTextField panTextField,aadharTextField;
        JButton next;
        JRadioButton syes,sno,eyes,eno;
        JComboBox religionbox,categorybox,incomebox,qualbox,occubox;
        String formno;

        SignupTwo(String formno){
            this.formno=formno;
            setLayout(null);

            setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

            JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
            additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
            additionalDetails.setBounds(290,70,600,30);
            add(additionalDetails);

            JLabel religion = new JLabel("Religion:");
            religion.setFont(new Font("Raleway",Font.BOLD,20));
            religion.setBounds(100,120,100,25);
            add(religion);

            String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
            religionbox = new JComboBox(valReligion);
            religionbox.setBounds(300,120,400,25);
            religionbox.setBackground(Color.white);
            add(religionbox);

            JLabel category = new JLabel("Category:");
            category.setFont(new Font("Raleway",Font.BOLD,20));
            category.setBounds(100,170,200,25);
            add(category);

            String valCategory[] = {"General","OBC","SC","ST","Other"};
            categorybox = new JComboBox(valCategory);
            categorybox.setBounds(300,170,400,25);
            categorybox.setBackground(Color.white);
            add(categorybox);

            JLabel income = new JLabel("Income:");
            income.setFont(new Font("Raleway",Font.BOLD,20));
            income.setBounds(100,220,200,25);
            add(income);

            String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
            incomebox = new JComboBox(valIncome);
            incomebox.setBounds(300,220,400,25);
            incomebox.setBackground(Color.white);
            add(incomebox);

            JLabel qualification = new JLabel("<html>Educational<br>Qualification:</html>");
            qualification.setFont(new Font("Raleway",Font.BOLD,20));
            qualification.setBounds(100,270,200,50);
            add(qualification);

            String valqual[] = {"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
            qualbox = new JComboBox(valqual);
            qualbox.setBounds(300,290,400,25);
            qualbox.setBackground(Color.white);
            add(qualbox);

            JLabel occu = new JLabel("Occupation:");
            occu.setFont(new Font("Raleway",Font.BOLD,20));
            occu.setBounds(100,340,200,25);
            add(occu);

            String valoccu[] = {"Salaried","Self-Employed","Business","Student","Retired","Others"};
            occubox = new JComboBox(valoccu);
            occubox.setBounds(300,340,400,25);
            occubox.setBackground(Color.white);
            add(occubox);

            JLabel pan = new JLabel("PAN Number:");
            pan.setFont(new Font("Raleway",Font.BOLD,20));
            pan.setBounds(100,390,200,25);
            add(pan);

            panTextField = new JTextField();
            panTextField.setFont(new Font("Raleway",Font.BOLD,14));
            panTextField.setBounds(300,390,400,25);
            add(panTextField);

            JLabel aadhar = new JLabel("Aadhar Number:");
            aadhar.setFont(new Font("Raleway",Font.BOLD,20));
            aadhar.setBounds(100,440,200,25);
            add(aadhar);

            aadharTextField = new JTextField();
            aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
            aadharTextField.setBounds(300,440,400,25);
            add(aadharTextField);

            JLabel seniorCitizen = new JLabel("Senior Citizen:");
            seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
            seniorCitizen.setBounds(100,490,200,25);
            add(seniorCitizen);

            syes = new JRadioButton("Yes");
            syes.setBounds(300,490,200,25);
            syes.setBackground(Color.white);
            add(syes);

            sno = new JRadioButton("No");
            sno.setBounds(500,490,200,25);
            sno.setBackground(Color.white);
            add(sno);

            ButtonGroup senior = new ButtonGroup();
            senior.add(syes);
            senior.add(sno);

            JLabel exist = new JLabel("Existing Account:");
            exist.setFont(new Font("Raleway",Font.BOLD,20));
            exist.setBounds(100,540,200,25);
            add(exist);

            eyes = new JRadioButton("Yes");
            eyes.setBounds(300,540,200,25);
            eyes.setBackground(Color.white);
            add(eyes);

            eno = new JRadioButton("No");
            eno.setBounds(500,540,200,25);
            eno.setBackground(Color.white);
            add(eno);

            ButtonGroup existA = new ButtonGroup();
            existA.add(eyes);
            existA.add(eno);

            next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.white);
            next.setFont(new Font("Raleway",Font.BOLD,14));
            next.setBounds(620,570,80,30);
            next.addActionListener(this);
            add(next);

            getContentPane().setBackground(Color.white);
            setSize(850,665);
            setLocation(250,10);
            setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String religion = (String) religionbox.getSelectedItem();//setText
            String category = (String) categorybox.getSelectedItem();
            String income = (String) incomebox.getSelectedItem();
            String qual = (String) qualbox.getSelectedItem();
            String occ = (String) occubox.getSelectedItem();
            String panN = panTextField.getText();
            String aadhar = aadharTextField.getText();
            String seniorC = null;
            if (syes.isSelected()){
                seniorC = "Yes";
            } else if (sno.isSelected()) {
                seniorC = "No";
            }
            String exista = null;
            if (eyes.isSelected()){
                exista = "Yes";
            }else if (eno.isSelected()){
                exista = "No";
            }
            try {
            Conn c = new Conn();
            String query = "insert into signupTwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qual+"','"+occ+"','"+panN+"','"+aadhar+"','"+seniorC+"','"+exista+"')";
            c.s.executeUpdate(query);

            //Signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }
    catch (Exception ey) {
            System.out.println(ey);
        }
        }
        public static void main(String[] args) {
            new bank.management.system.SignupTwo("");
        }


    }