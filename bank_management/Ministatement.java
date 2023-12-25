package bank_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ministatement extends JFrame implements ActionListener {
	
	String pinnumber;
	
	Ministatement(String pinnumber){
		this.pinnumber = pinnumber;
		setLayout(null);
		
setTitle("PinChange");
		
		
		setTitle("Mini Statement");
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank = new JLabel("TYS bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);	
		add(balance);
		
		try {
			Conn con = new Conn();
			ResultSet rs = con.s.executeQuery("select * from login where pin= '"+pinnumber+"'"); 
			while(rs.next()) {
				card.setText("Card Number: "+rs.getString("cardnumber").substring(0, 4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
			
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		try {
			Conn con = new Conn();
			int bal =0;

			ResultSet rs = con.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));

				}
			
			}
			balance.setText("Your current account balance is Rs. "+bal);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ministatement("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	}

}
}
