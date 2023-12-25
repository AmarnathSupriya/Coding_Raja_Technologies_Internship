package bank_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pinchange extends JFrame implements ActionListener {
	
	JPasswordField pin,repin;
	JButton change,back;
	String pinnumber;
	
	Pinchange(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		setTitle("PinChange");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/plain.png"));
		Image i2 = i1.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0,0,900,600);
		add(label);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setFont(new Font("System",Font.BOLD,30));
		text.setForeground(Color.white);
		text.setBounds(250,100,500,35);
		label.add(text);
		
		JLabel pintext = new JLabel("NEW PIN :");
		pintext.setFont(new Font("System",Font.BOLD,20));
		pintext.setForeground(Color.white);
		pintext.setBounds(100,190,500,35);
		label.add(pintext);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,19));
		pin.setBounds(330,190,100,35);
		label.add(pin);
		
		JLabel repintext = new JLabel("RE-ENTER NEW PIN :");
		repintext.setFont(new Font("System",Font.BOLD,20));
		repintext.setForeground(Color.white);
		repintext.setBounds(100,230,500,35);
		label.add(repintext);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,19));
		repin.setBounds(330,230,100,35);
		label.add(repin);
		
		change = new JButton("Change PIN");
		//change.setBackground(Color.GRAY);
		change.setBounds(330,300,150,30);
		change.setFont(new Font("System",Font.BOLD,20));
		change.addActionListener(this);
		label.add(change);
		
		back = new JButton("Back");
		//back.setBackground(Color.GRAY);
		back.setBounds(330,350,150,30);
		back.setFont(new Font("System",Font.BOLD,20));
		back.addActionListener(this);
		label.add(back);
		
		setSize(900,600);
		setLocation(300,0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Pinchange("").setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==change) {
		try {
			String mpin= pin.getText();
			String mrepin = repin.getText();
			
			if(!mpin.equals(mrepin)){
				JOptionPane.showMessageDialog(null, "Entered PIN doesn't Match");
				return;
			}
			if(mpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter new pin");
				return;
			}
			if(mrepin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re-enter the pin");
				return;
			}
			Conn conn = new Conn();
			String query1 = "update bank set pin = '"+mrepin+"' where pin ='"+pinnumber+"'";
			String query2 = "update login set pin = '"+mrepin+"' where pin ='"+pinnumber+"'";
			String query3 = "update signup3 set pin = '"+mrepin+"' where pin ='"+pinnumber+"'";

			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			conn.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN changed successfully");
			
			setVisible(false);
			new Transactions(mrepin).setVisible(true);


		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
		else {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	
	}
}
