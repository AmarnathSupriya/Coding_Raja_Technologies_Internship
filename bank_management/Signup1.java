package bank_management;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.*;
import java.awt.event.*;

public class Signup1 extends JFrame implements ActionListener {
	
	long random;
	JTextField nametf,fnametf,dobtf,emailtf,citytf,statetf,pincodetf;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser dc;
	
	
	Signup1(){
		
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong()% 9000L) +1000L);
		
		JLabel formno =new JLabel("APPLICATION FORM NO. " + random);
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personaldetails =new JLabel("Page 1: Personal Details");
		personaldetails.setFont(new Font("Raleway",Font.BOLD,28));
		personaldetails.setBounds(250,80,400,30);
		add(personaldetails);
		
		JLabel name =new JLabel("Name :");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nametf = new JTextField();
		nametf.setFont(new Font("Raleway",Font.BOLD,20));
		nametf.setBounds(300,140,400,30);
		add(nametf);
		
		JLabel fname =new JLabel("Father's name");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,180,150,30);
		add(fname);
		
		fnametf = new JTextField();
		fnametf.setFont(new Font("Raleway",Font.BOLD,20));
		fnametf.setBounds(300,180,400,30);
		add(fnametf);
		
		JLabel dob =new JLabel("Date of Birth");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,220,150,30);
		add(dob);
		
		dc = new JDateChooser();
		dc.setBounds(300,220,400,30);
		dc.setForeground(Color.black);
		add(dc);
		
		JLabel gender =new JLabel("Gender");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,260,150,30);
		add(gender);
		
		male= new JRadioButton("Male");
		male.setBounds(300,260,80,30);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(400,260,80,30);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergrp = new ButtonGroup();
		gendergrp.add(male);
		gendergrp.add(female);

		JLabel email =new JLabel("Email ");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,300,150,30);
		add(email);
		
		emailtf = new JTextField();
		emailtf.setFont(new Font("Raleway",Font.BOLD,20));
		emailtf.setBounds(300,300,400,30);
		add(emailtf);
		
		JLabel marital =new JLabel("Marital status ");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,330,150,60);
		add(marital);
		
		married= new JRadioButton("Married");
		married.setBounds(300,345,80,30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(400,345,100,30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		other= new JRadioButton("other");
		other.setBounds(510,345,80,30);
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup marriedgrp = new ButtonGroup();
		marriedgrp.add(married);
		marriedgrp.add(unmarried);
		marriedgrp.add(other);
		
		/*JLabel address =new JLabel("Address  ");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,370,150,60);
		add(address);
		
		JTextField addresstf = new JTextField();
		addresstf.setFont(new Font("Raleway",Font.BOLD,20));
		addresstf.setBounds(300,390,400,30);
		add(addresstf);*/
		
		JLabel city =new JLabel("City ");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,410,150,60);
		add(city);
		
		citytf = new JTextField();
		citytf.setFont(new Font("Raleway",Font.BOLD,20));
		citytf.setBounds(300,430,400,30);
		add(citytf);
		
		JLabel state =new JLabel("State");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,450,150,60);
		add(state);
		
		statetf = new JTextField();
		statetf.setFont(new Font("Raleway",Font.BOLD,20));
		statetf.setBounds(300,470,400,30);
		add(statetf);
		
		JLabel pincode =new JLabel("Pincode");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100,490,150,60);
		add(pincode);
		
		pincodetf = new JTextField();
		pincodetf.setFont(new Font("Raleway",Font.BOLD,20));
		pincodetf.setBounds(300,510,400,30);
		add(pincodetf);
		
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setBounds(620,550,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);

		setSize(1300,800);
		setVisible(true);
		setLocation(0,0);
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formnoo = " "+ random;
		String name = nametf.getText();
		String fname = fnametf.getText();
		String dob = ((JTextField)dc.getDateEditor().getUiComponent()).getText();
		String gen = null;
		if(male.isSelected()) {
			gen = "Male";
		}
		else if(female.isSelected()) {
			gen = "Female";
		}
		
		String email = emailtf.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}
		else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}
		else if(other.isSelected()) {
			marital = "Other";
		}
		
		//String address = addresstf.getText();
		String city = citytf.getText();
		String state = statetf.getText();
		String pincode = pincodetf.getText();

		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is required");
			}
			else if(fname.equals("")) {
				JOptionPane.showMessageDialog(null,"Father's name is required");
			}
			else if(email.equals("")) {
				JOptionPane.showMessageDialog(null,"Email is required");
			}
			/*else if(address.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is required");
			}*/
			else if(city.equals("")) {
				JOptionPane.showMessageDialog(null,"City is required");
			}
			else if(state.equals("")) {
				JOptionPane.showMessageDialog(null,"State is required");
			}
			else if(pincode.equals("")) {
				JOptionPane.showMessageDialog(null,"Pincode is required");
			}
			else {
				Conn c = new Conn();
				String query = "insert into signup1 values('"+formnoo+"','"+name+"','"+fname+"','"+dob+"','"+gen+"','"+email+"','"+marital+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new Signup2(formnoo).setVisible(true);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		}
	
	public static void main(String[] args) {
		new Signup1();
	}

}
