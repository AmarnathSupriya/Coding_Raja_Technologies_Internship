package bank_management;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Signup3 extends JFrame implements ActionListener {
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formnoo;
	
	Signup3(String formnoo){
		this.formnoo = formnoo;
		setLayout(null);
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway",Font.BOLD,22));
		l1.setBounds(280,40,400,40);
		add(l1);
		
		JLabel type = new JLabel("Account Type");
		type.setFont(new Font("Raleway",Font.BOLD,22));
		type.setBounds(100,140,200,30);
		add(type);
		
		r1 = new JRadioButton("Savings Account");
		r1.setFont(new Font("Raleway",Font.BOLD,16));
		r1.setBackground(Color.white);
		r1.setBounds(100,180,200,20);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway",Font.BOLD,16));
		r2.setBackground(Color.white);
		r2.setBounds(350,180,200,20);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway",Font.BOLD,16));
		r3.setBackground(Color.white);
		r3.setBounds(100,220,200,20);
		add(r3);
		
		r4 = new JRadioButton("Recurring Account");
		r4.setFont(new Font("Raleway",Font.BOLD,16));
		r4.setBackground(Color.white);
		r4.setBounds(350,220,200,20);
		add(r4);
		
		ButtonGroup account = new ButtonGroup();
		account.add(r1);
		account.add(r2);
		account.add(r3);
		account.add(r4);
		
		JLabel card = new JLabel("Card Number :");
		card.setFont(new Font("Raleway",Font.BOLD,22));
		card.setBounds(100,270,200,30);
		add(card);
		
		JLabel number = new JLabel("xxxx-xxxx-xxxx-4323");
		number.setFont(new Font("Raleway",Font.BOLD,22));
		number.setBounds(330,275,300,30);
		add(number);
		
		JLabel carddetail = new JLabel("Your 16 digit card number");
		carddetail.setFont(new Font("Raleway",Font.ITALIC,10));
		carddetail.setBounds(100,295,300,18);
		add(carddetail);
		
		JLabel pin = new JLabel("PIN :");
		pin.setFont(new Font("Raleway",Font.BOLD,22));
		pin.setBounds(100,320,200,30);
		add(pin);
		
		JLabel pindetail = new JLabel("Your PIN number");
		pindetail.setFont(new Font("Raleway",Font.ITALIC,10));
		pindetail.setBounds(100,350,300,18);
		add(pindetail);
		
		JLabel number1 = new JLabel("xxxx");
		number1.setFont(new Font("Raleway",Font.BOLD,22));
		number1.setBounds(330,330,300,30);
		add(number1);
		
		JLabel services = new JLabel("Services Required: ");
		services.setFont(new Font("Raleway",Font.BOLD,22));
		services.setBounds(100,380,300,30);
		add(services);
		
		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.white);
		c1.setBounds(100,415,200,18);
		c1.setFont(new Font("Raleway",Font.BOLD,16));
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setBounds(300,415,200,18);
		c2.setFont(new Font("Raleway",Font.BOLD,16));
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setBounds(100,445,200,18);
		c3.setFont(new Font("Raleway",Font.BOLD,16));
		add(c3);
		
		c4 = new JCheckBox("Email & SMS alerts");
		c4.setBackground(Color.white);
		c4.setBounds(300,445,200,18);
		c4.setFont(new Font("Raleway",Font.BOLD,16));
		add(c4);

		c5= new JCheckBox("E-statement");
		c5.setBackground(Color.white);
		c5.setBounds(100,475,200,18);
		c5.setFont(new Font("Raleway",Font.BOLD,16));
		add(c5);
		
		c6= new JCheckBox("Cheque book");
		c6.setBackground(Color.white);
		c6.setBounds(300,475,200,18);
		c6.setFont(new Font("Raleway",Font.BOLD,16));
		add(c6);
		
		c7 = new JCheckBox("I here by declare that the above entered details are correct to the best of my knowledge ");
		c7.setBackground(Color.white);
		c7.setBounds(100,500,500,20);
		c7.setFont(new Font("Raleway",Font.BOLD,11));
		add(c7);

		submit = new JButton("Submit");
		submit.setBackground(Color.white);
		submit.setForeground(Color.black);
		submit.setBounds(350,550,100,30);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.white);
		cancel.setForeground(Color.black);
		cancel.setBounds(470,550,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		getContentPane().setBackground(Color.white);
		
		setSize(800,800);
		setVisible(true);
		setLocation(150,0);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==submit) {
				String acctype = null;
				if(r1.isSelected()) {
					acctype ="Savings Account";
				}
				else if(r2.isSelected()) {
					acctype = "Fixed Deposit Account";
				}
				else if(r3.isSelected()) {
					acctype = "Current Account";
				}
				else if(r4.isSelected()) {
					acctype = "Recurring Account";
				}
				
				Random random = new Random();
				String cardnumber ="" +Math.abs((random.nextLong()%9000000L) + 5040936000000000L);
				
				String pinnumber ="" +Math.abs((random.nextLong()%9000L) + 1000L);
				
				String facility ="";
				if(c1.isSelected()) {
					facility = facility + " ATM card";
				}
				else if(c2.isSelected()) {
					facility = facility + " Internet Banking";
				}
				else if(c3.isSelected()) {
					facility = facility + " Mobile Banking";
				}
				else if(c4.isSelected()) {
					facility = facility + " Email & SMS alert";
				}
				else if(c5.isSelected()) {
					facility = facility + " E-statement";
				}
				else if(c6.isSelected()) {
					facility = facility + " Cheque Book";
				}
				
			try {
				if(acctype.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}
				else {
					Conn c = new Conn();
					String query1= "insert into signup3 values('"+formnoo+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2= "insert into login values('"+formnoo+"','"+cardnumber+"','"+pinnumber+"')";
					
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null,"Card Number"+cardnumber+"\n Pin: "+pinnumber+"\n");
					
					setVisible(false);
					new Deposit(pinnumber).setVisible(false);
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
				
		}
		else if(ae.getSource()==cancel) {
			setVisible(false);
			new MainFrame().setVisible(true);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup3("");
	}

}
