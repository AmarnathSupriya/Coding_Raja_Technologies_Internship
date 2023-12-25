package bank_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fastcash extends JFrame implements ActionListener {

	JButton deposit,withdraw,fastcash,billing,pinchange,balance,clear;
	String pinnum;
	Fastcash(String pinnum){
		
		this.pinnum = pinnum;
		
		setLayout(null);
		
		setTitle("Easy Cash");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/plain.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0,900,900);
		add(label);
		
		getContentPane().setBackground(Color.white);
		
		JLabel text = new JLabel("SELECT WITHDRWAL AMOUNT");
		text.setBounds(150,150,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,28));
		label.add(text);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(170,220,150,40);
		deposit.setBackground(Color.white);
		deposit.addActionListener(this);
		label.add(deposit);
		
		withdraw = new JButton("Rs 500");
		withdraw.setBounds(400,220,150,40);
		withdraw.setBackground(Color.white);
		withdraw.addActionListener(this);
		label.add(withdraw);
		
		fastcash = new JButton("Rs 1000");
		fastcash.setBounds(170,300,150,40);
		fastcash.setBackground(Color.white);
		fastcash.addActionListener(this);
		label.add(fastcash);
		
		billing = new JButton("Rs 4000");
		billing.setBounds(400,300,150,40);
		billing.setBackground(Color.white);
		billing.addActionListener(this);
		label.add(billing);
		
		pinchange = new JButton("Rs 5000");
		pinchange.setBounds(170,380,150,40);
		pinchange.setBackground(Color.white);
		pinchange.addActionListener(this);
		label.add(pinchange);
		
		balance = new JButton("Rs 10000");
		balance.setBounds(400,380,150,40);
		balance.setBackground(Color.white);
		balance.addActionListener(this);
		label.add(balance);
		
		clear = new JButton("Back");
		clear.setBounds(270,450,150,40);
		clear.setBackground(Color.white);
		clear.addActionListener(this);
		label.add(clear);
	
		
		setSize(700,600);
		setVisible(true);
		//setUndecorated(true);
		setLocation(200,20);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fastcash("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()== clear) {
			setVisible(false);
			new Transactions(pinnum).setVisible(true);
		}
		else{
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c = new Conn();
			try {
				ResultSet rs =c.s.executeQuery("select * from bank where pin - '"+pinnum+"'");
				int balance =0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));

					}
				}
				if(ae.getSource()!= clear && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinnum+"','"+date+"','Withdrawl','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Withdrew Sucessfully");
				
				setVisible(false);
				new Transactions(pinnum).setVisible(true);
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		
	}
	

}

