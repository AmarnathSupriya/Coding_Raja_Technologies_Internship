package bank_management;
import java.awt.Color;

import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MainFrame extends JFrame implements ActionListener {
	
	JButton b1,b2,b3;
	JTextField t1;
	JPasswordField t2;
	
	MainFrame(){
		
		setTitle("Bank Management");
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(100,50,100,100);
		add(label);
		
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text = new JLabel("Wecome to TYS Bank");
		text.setFont(new Font("Osword",Font.BOLD,38));
		text.setBounds(250, 10, 700, 200);
		text.setForeground(Color.black);
		add(text);
		
		JLabel cardno = new JLabel("Card No :");
		cardno.setFont(new Font("Raleway",Font.ITALIC,28));
		cardno.setBounds(150, 200, 150, 40);
		add(cardno);
		
		t1 = new JTextField();
		t1.setBounds(300,210,230,30);
		t1.setFont(new Font("Arial",Font.BOLD,14));
		add(t1);
		
		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Raleway",Font.ITALIC,28));
		pin.setBounds(150, 250, 200, 40);
		add(pin);
		
		t2 = new JPasswordField();
		t2.setBounds(300,260,230,30);
		add(t2);
		
		b1 = new JButton("Sign in");
		b1.setBounds(300,300,100,40);
		b1.setBackground(Color.GRAY);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Clear");
		b2.setBounds(430,300,100,40);
		b2.setBackground(Color.GRAY);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Sign up");
		b3.setBounds(300,350,230,40);
		b3.setBackground(Color.GRAY);
		b3.setForeground(Color.white);
		b3.addActionListener(this);
		add(b3);
		
		setSize(800,480);
		setVisible(true);
		setLocation(300,100);
	
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b2) {
			t1.setText("");
			t2.setText("");
		}
		else if(ae.getSource() == b1) {
			Conn conn = new Conn();
			String cardnum = t1.getText();
			String pinnum = t2.getText();
			
			String query = "select * from login where cardnumber ='"+cardnum+"' and pin = '"+pinnum+"'";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnum).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incoorect CardNumber or PIN");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource() == b3) {
			setVisible(false);
			new Signup1().setVisible(true);
		}
	
	}
	public static void main(String[] args) {
		new MainFrame();
	}

}
