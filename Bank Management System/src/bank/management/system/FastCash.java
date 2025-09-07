package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {

    JButton rs1,rs2,rs3,rs4,rs5,rs6,back;
    String pinnumber;

    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,730,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,730);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220,230,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        rs1 = new JButton("Rs 100");
        rs1.setBounds(160,339,150,23);
        rs1.addActionListener(this);
        image.add(rs1);

        rs2 = new JButton("Rs 500");
        rs2.setBounds(365,339,150,23);
        rs2.addActionListener(this);
        image.add(rs2);

        rs3 = new JButton("Rs 1000");
        rs3.setBounds(160,367,150,23);
        rs3.addActionListener(this);
        image.add(rs3);

        rs4 = new JButton("Rs 2000");
        rs4.setBounds(365,367,150,23);
        rs4.addActionListener(this);
        image.add(rs4);

        rs5 = new JButton("Rs 5000");
        rs5.setBounds(160,395,150,23);
        rs5.addActionListener(this);
        image.add(rs5);

        rs6 = new JButton("Rs 10000");
        rs6.setBounds(365,395,150,23);
        rs6.addActionListener(this);
        image.add(rs6);

        back = new JButton("Back");
        back.setBounds(365,423,150,23);
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
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
