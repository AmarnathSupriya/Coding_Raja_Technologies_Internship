package bank_management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener{
	
	//long random;
	JTextField aadhartf,pantf;
	JButton next;
	JRadioButton syes,sno,syes1,sno1;
	JComboBox religion,categorybox,incomebox,educationbox,occupationbox;
	String formnoo;
	
	Signup2(String formnoo){
		this.formnoo = formnoo;
		setLayout(null);
		
		setTitle("NEW APPLCATION FORM - PAGE 2");
		
		
		JLabel additionaldetails =new JLabel("Page 2: Additional Details");
		additionaldetails.setFont(new Font("Raleway",Font.BOLD,28));
		additionaldetails.setBounds(250,80,400,30);
		add(additionaldetails);
		
		JLabel name =new JLabel("Religion:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		String[] valreligion = {"Hindu","Muslim","Christian","Sikh","Other"};
		religion = new JComboBox(valreligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.white);
		add(religion);
		
		JLabel category =new JLabel("Category:");
		category.setFont(new Font("Raleway",Font.BOLD,20));
		category.setBounds(100,180,150,30);
		add(category);
		
		String[] valcategory = {"General","OBC","SC","ST","Other"};
		categorybox = new JComboBox(valcategory);
		categorybox.setBounds(300,180,400,30);
		categorybox.setBackground(Color.white);
		add(categorybox);
		
		JLabel dob =new JLabel("Income");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,220,150,30);
		add(dob);
		
		String[] valincome = {"NULL","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
		incomebox = new JComboBox(valincome);
		incomebox.setBounds(300,220,400,30);
		incomebox.setBackground(Color.white);
		add(incomebox);
		
		JLabel income =new JLabel("Educational");
		income.setFont(new Font("Raleway",Font.BOLD,20));
		income.setBounds(100,260,150,30);
		add(income);

		JLabel education =new JLabel("Qualification :");
		education.setFont(new Font("Raleway",Font.BOLD,20));
		education.setBounds(100,290,150,30);
		add(education);
		
		String[] valeducation = {"Non-Graduate","Graduate","Post-Graduate","Doctorate","other"};
		educationbox = new JComboBox(valeducation);
		educationbox.setBounds(300,290,400,30);
		educationbox.setBackground(Color.white);
		add(educationbox);
		
		JLabel occupation =new JLabel("Occupation: ");
		occupation.setFont(new Font("Raleway",Font.BOLD,20));
		occupation.setBounds(100,330,150,60);
		add(occupation);
		
		String[] valoccupation = {"Salaried","Self-employed","Business","Student","Retired"};
		occupationbox = new JComboBox(valoccupation);
		occupationbox.setBounds(300,350,400,30);
		occupationbox.setBackground(Color.white);
		add(occupationbox);
		
		/*JLabel address =new JLabel("Address  ");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,370,150,60);
		add(address);
		
		JTextField addresstf = new JTextField();
		addresstf.setFont(new Font("Raleway",Font.BOLD,20));
		addresstf.setBounds(300,390,400,30);
		add(addresstf);*/
		
		JLabel aadhar =new JLabel("Aadhar no:");
		aadhar.setFont(new Font("Raleway",Font.BOLD,20));
		aadhar.setBounds(100,370,150,60);
		add(aadhar);
		
		aadhartf = new JTextField();
		aadhartf.setFont(new Font("Raleway",Font.BOLD,20));
		aadhartf.setBounds(300,390,400,30);
		add(aadhartf);
		
		JLabel pan =new JLabel("PAN no:");
		pan.setFont(new Font("Raleway",Font.BOLD,20));
		pan.setBounds(100,410,150,60);
		add(pan);
		
		pantf = new JTextField();
		pantf.setFont(new Font("Raleway",Font.BOLD,20));
		pantf.setBounds(300,430,400,30);
		add(pantf);
		
		JLabel citizen =new JLabel("Senior Citizen:");
		citizen.setFont(new Font("Raleway",Font.BOLD,20));
		citizen.setBounds(100,450,150,60);
		add(citizen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300,470,60,30);
		syes.setBackground(Color.white);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(360,470,60,30);
		sno.setBackground(Color.white);
		add(sno);
		
		ButtonGroup senior = new ButtonGroup();
		senior.add(syes);
		senior.add(sno);
		
		JLabel exists =new JLabel("Existing Account:");
		exists.setFont(new Font("Raleway",Font.BOLD,20));
		exists.setBounds(100,490,200,60);
		add(exists);
		
		syes1 = new JRadioButton("Yes");
		syes1.setBounds(300,510,60,30);
		syes1.setBackground(Color.white);
		add(syes1);
		
		sno1 = new JRadioButton("No");
		sno1.setBounds(380,510,60,30);
		sno1.setBackground(Color.white);
		add(sno1);
		
		ButtonGroup exists1 = new ButtonGroup();
		exists1.add(syes1);
		exists1.add(sno1);
		
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
		
		String sreligion = (String)religion.getSelectedItem();
		String category = (String)categorybox.getSelectedItem();
		String income = (String)incomebox.getSelectedItem();
		String education = (String)educationbox.getSelectedItem();
		String occupation = (String)occupationbox.getSelectedItem();
		
		String senior1 = null;
		if(syes.isSelected()) {
			senior1 = "Yes";
		}
		else if(sno.isSelected()) {
			senior1 = "No";
		}
		
		String exists = null;
		if(syes1.isSelected()) {
			exists = "Yes";
		}
		else if(sno1.isSelected()) {
			exists = "No";
		}
		
		String pan = pantf.getText();
		String aadhar = aadhartf.getText();

		try {
				Conn c = new Conn();
				String query = "insert into signup2 values('"+formnoo+"','"+sreligion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior1+"','"+exists+"')";
				c.s.executeUpdate(query);
				
				//signup1 object
				setVisible(false);
				new Signup3(formnoo).setVisible(true);
			}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Signup2("");
	}
	

}
