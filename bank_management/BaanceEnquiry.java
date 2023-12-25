package bank_management;

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

public class BaanceEnquiry extends JFrame implements ActionListener{

	JButton back;
	String pinnumber;
	
	BaanceEnquiry(String pinnumber){
		setLayout(null);
		this.pinnumber = pinnumber;
		
        setTitle("Balance Check");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/plain.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0,900,400);
		add(label);
		
		back = new JButton("Back");
		back.setBounds(350,150,100,30);
		back.setFont(new Font("System",Font.BOLD,20));
		back.setBackground(Color.white);
		back.addActionListener(this);
		label.add(back);
		
		Conn c = new Conn();
		int balance =0;
		try {
			ResultSet rs =c.s.executeQuery("select * from bank where pin - '"+pinnumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));

				}
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
		
		JLabel text = new JLabel("Your Current Account Balance is Rs."+balance);
		text.setForeground(Color.white);
		text.setBounds(170,100,500,30);
		text.setFont(new Font("System",Font.BOLD,20));
		label.add(text);
		
		setSize(900,400);
		setVisible(true);
		//setUndecorated(true);
		setLocation(250,20);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BaanceEnquiry("");
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		setVisible(true);
		new Transactions(pinnumber).setVisible(true);
	}

}
