package bank_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdraw extends JFrame implements ActionListener {
	JTextField amount;
	JButton withdraw,back;
	String pinnum;
	
	Withdraw(String pinnum){
		
		this.pinnum = pinnum;
		setLayout(null);
		
		setTitle("Withdrawl");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/plain.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0,900,400);
		add(label);
		
		JLabel text = new JLabel("Enter the amount you want to Withdraw:");
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(100,30,400,20);
		label.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway",Font.BOLD,20));
		amount.setBounds(100,60,400,30);
		label.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setFont(new Font("Raleway",Font.BOLD,15));
		withdraw.setBounds(150,120,150,30);
		withdraw.addActionListener(this);
		label.add(withdraw);
		
		back = new JButton("Back");
		back.setFont(new Font("Raleway",Font.BOLD,15));
		back.setBounds(350,120,150,30);
		back.addActionListener(this);
		label.add(back);
		
		setSize(900,400);
		setVisible(true);
		setLocation(100,20);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Withdraw("");
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==withdraw) {
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null,"Pease enter the amount you want to withdraw");
			}
			else {
				try {
					Conn conn = new Conn();
					String query = "insert into bank values('"+pinnum+"','"+date+"','Withdrawl','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs"+number+"Withdrew Successfully");
					setVisible(false);
					new Transactions(pinnum).setVisible(true);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				
			}
		}
		else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnum).setVisible(true);
		}
	}

}

