package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

    Withdrawal(String pinnumber){

        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,730,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,730);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(190,240,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(180,280,320,30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(360,395,150,23);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(360,423,150,23);
        back.addActionListener(this);
        image.add(back);

        setSize(900,730);
        setLocation(200,0);
        setBackground(Color.white);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            if (number == null){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw.");
            }else {
                try {
                    Conn conn = new Conn();
                    String query = " insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully.");
                    setVisible(false);
                    new  Transactions(pinnumber).setVisible(true);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }else if (e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdrawal("");
    }
}

