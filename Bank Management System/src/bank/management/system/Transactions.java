package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawal,fastcash,miniStatement,enquiry,exit,pinchange;
    String pinnumber;

   Transactions(String pinnumber){
       this.pinnumber = pinnumber;
       setLayout(null);

       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,730,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,730);
       add(image);

       JLabel text = new JLabel("Please select your Transaction");
       text.setBounds(220,230,700,35);
       text.setForeground(Color.white);
       text.setFont(new Font("System",Font.BOLD,16));
       image.add(text);

       deposit = new JButton("Deposit");
       deposit.setBounds(160,339,150,23);
       deposit.addActionListener(this);
       image.add(deposit);

       withdrawal = new JButton("Cash Withdrawal");
       withdrawal.setBounds(365,339,150,23);
       withdrawal.addActionListener(this);
       image.add(withdrawal);

       fastcash = new JButton("Fast Cash");
       fastcash.setBounds(160,367,150,23);
       fastcash.addActionListener(this);
       image.add(fastcash);

       miniStatement = new JButton("Mini Statement");
       miniStatement.setBounds(365,367,150,23);
       miniStatement.addActionListener(this);
       image.add(miniStatement);

       pinchange = new JButton("Pin Change");
       pinchange.setBounds(160,395,150,23);
       pinchange.addActionListener(this);
       image.add(pinchange);

       enquiry = new JButton("Balance Enquiry");
       enquiry.setBounds(365,395,150,23);
       enquiry.addActionListener(this);
       image.add(enquiry);

       exit = new JButton("Exit");
       exit.setBounds(365,423,150,23);
       exit.addActionListener(this);
       image.add(exit);

       setSize(900,730);
       setLocation(200,0);
       setBackground(Color.white);
       setUndecorated(true);
       setVisible(true);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == exit){
           System.exit(0);
       } else if (e.getSource() == deposit) {
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
       }else if (e.getSource() == withdrawal){
           setVisible(false);
           new Withdrawal(pinnumber).setVisible(true);
       }else if (e.getSource() == fastcash){
           setVisible(false);
           new FastCash(pinnumber).setVisible(true);
       } else if (e.getSource() == pinchange) {
           setVisible(false);
           new PinChange(pinnumber).setVisible(true);
       }else if (e.getSource() == enquiry) {
           setVisible(false);
           new BalanceEnquiry(pinnumber).setVisible(true);
       }else if (e.getSource() == miniStatement) {
           new MiniStatement(pinnumber).setVisible(true);
       }
    }
}
