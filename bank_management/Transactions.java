package bank_management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit,withdraw,fastcash,billing,pinchange,balance,clear;
	String pinnumber;
	Transactions(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/plain.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0,900,900);
		add(label);
		
		getContentPane().setBackground(Color.white);
		
		JLabel text = new JLabel("Please select your transaction");
		text.setBounds(150,100,700,50);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,38));
		label.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(200,220,150,40);
		deposit.setBackground(Color.white);
		deposit.addActionListener(this);
		label.add(deposit);
		
		withdraw = new JButton("Cash WIthdraw");
		withdraw.setBounds(500,220,150,40);
		withdraw.setBackground(Color.white);
		withdraw.addActionListener(this);
		label.add(withdraw);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(200,300,150,40);
		fastcash.setBackground(Color.white);
		fastcash.addActionListener(this);
		label.add(fastcash);
		
		billing = new JButton("Mini Statement");
		billing.setBounds(500,300,150,40);
		billing.setBackground(Color.white);
		billing.addActionListener(this);
		label.add(billing);
		
		pinchange = new JButton("Change PIN");
		pinchange.setBounds(200,380,150,40);
		pinchange.setBackground(Color.white);
		pinchange.addActionListener(this);
		label.add(pinchange);
		
		balance = new JButton("Check Balance");
		balance.setBounds(500,380,150,40);
		balance.setBackground(Color.white);
		balance.addActionListener(this);
		label.add(balance);
		
		clear = new JButton("Exit");
		clear.setBounds(350,450,150,40);
		clear.setBackground(Color.white);
		clear.addActionListener(this);
		label.add(clear);
	
		
		setSize(900,900);
		setVisible(true);
		//this.setUndecorated(true);
		setLocation(350,20);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Transactions("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()== clear) {
			System.exit(0);
		}
		else if(ae.getSource()== deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource()==withdraw) {
			setVisible(false);
			new Withdraw(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==fastcash) {
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
		}
		else if(ae.getSource()== pinchange) {
			setVisible(false);
			new Pinchange(pinnumber).setVisible(true);
		}else if(ae.getSource()== billing) {
			setVisible(false);
			new Ministatement(pinnumber).setVisible(true);
		}
		else if(ae.getSource()== balance) {
			setVisible(false);
			new BaanceEnquiry(pinnumber).setVisible(true);
		}
	
		
		
	}
	

}
