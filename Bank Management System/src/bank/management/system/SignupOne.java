package bank.management.system;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupOne extends JFrame implements ActionListener {
    long ran;
    JTextField nameTextField,fnameTextField,emailTextField,addTextField,cityTextField,stateTextField,pcTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        Random random = new Random();
        ran = Math.abs((random.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + ran);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,70,600,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,125,100,20);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,125,400,20);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,170,200,20);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,170,400,20);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,215,200,20);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,215,400,20);
        dateChooser.setForeground(Color.black);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,260,200,20);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,260,100,20);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,260,100,20);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(600,260,100,20);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,305,200,20);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,305,400,20);
        add(emailTextField);

        JLabel ms = new JLabel("Marital Status:");
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        ms.setBounds(100,350,200,20);
        add(ms);

        married = new JRadioButton("Married");
        married.setBounds(300,350,100,20);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,350,100,20);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600,350,100,20);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);

        JLabel addr = new JLabel("Address:");
        addr.setFont(new Font("Raleway",Font.BOLD,20));
        addr.setBounds(100,395,200,20);
        add(addr);

        addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addTextField.setBounds(300,395,400,20);
        add(addTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,440,200,20);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,440,400,20);
        add(cityTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,485,200,20);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,485,400,20);
        add(stateTextField);

        JLabel pc = new JLabel("Pin Code:");
        pc.setFont(new Font("Raleway",Font.BOLD,20));
        pc.setBounds(100,530,200,20);
        add(pc);

        pcTextField = new JTextField();
        pcTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pcTextField.setBounds(300,530,400,20);
        add(pcTextField);

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
        String formno = "" + ran;//long
        String name = nameTextField.getText();//setText
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }else if (other.isSelected()){
            marital = "Other";
        }
        String address = addTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pcTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father's Name is required");
            }if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"DOB is required");
            }if(gender.equals(null)){
                JOptionPane.showMessageDialog(null,"Gender is required");
            }if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Email is required");
            }if(marital.equals(null)){
                JOptionPane.showMessageDialog(null,"Marital Status is required");
            }if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Address is required");
            }if(city.equals("")){
                JOptionPane.showMessageDialog(null,"City is required");
            }if(state.equals("")){
                JOptionPane.showMessageDialog(null,"State is required");
            }if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Pin Code is required");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+state+"','"+city+"','"+pin+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
