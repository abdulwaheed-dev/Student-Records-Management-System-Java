package records;
import java.sql.* ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class add extends JFrame {
	
	
	JTextField j1,j2,j3,j4,j6,j7;
	JComboBox gend;
	String gndr[] = {"Male" , "Female"};
	Font tf = new Font("Microsoft JhengHei UI",Font.PLAIN,18);
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);
	
	void buttonCustom(JButton b) {
//		b.setFont(tf);
//		b.setBackground(bac);
//	    b.setForeground(Color.WHITE);
//	    b.setFocusPainted(false);
		b.setBorderPainted(false);
		b.setBackground(new Color(245,242,208));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}
	
	add(){
		setTitle("Add New Record");
		setBounds(220,10,870,700);
		getContentPane().setBackground(new Color(245,242,208));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JPanel top= new JPanel();
		top.setBackground(bac);
		top.setBounds(0,0,870,70);
		top.setLayout(null);
		
		JPanel down= new JPanel();
		down.setBackground(bac);
		down.setBounds(0,615,870,50);
		down.setLayout(null);
		
		JLabel ends = new JLabel("Lenovo Creations.",SwingConstants.RIGHT);
		ends.setFont(new Font("Arial",Font.PLAIN,17));
		ends.setForeground(Color.white);
		ends.setBounds(275,620,580,40);
		add(ends);
		
		JLabel ends1 = new JLabel("All Rights Reserved.",SwingConstants.LEFT);
		ends1.setFont(new Font("Arial",Font.PLAIN,17));
		ends1.setForeground(Color.white);
		ends1.setBounds(5,620,200,40);
		add(ends1);
		
		JLabel ap=new JLabel("Enter Student Information");
		JLabel roll=new JLabel("Roll No:");
		JLabel name=new JLabel("Name:");
		JLabel dep=new JLabel("Department:");
		JLabel bd=new JLabel("Birthdate:");
		JLabel gen=new JLabel("Gender:");
		JLabel cont=new JLabel("Contact No:");
		JLabel adr=new JLabel("Address:");
		
		ap.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,28));
		ap.setForeground(Color.white);
		ap.setBounds(15,20,400,40);
		top.add(ap);
		roll.setFont(tf);
		roll.setForeground(new Color(76,75,66));
		roll.setBounds(200,90,80,50);
		add(roll);
		name.setFont(tf);
		name.setForeground(new Color(76,75,66));
		name.setBounds(200,150,80,50);
		add(name);
		dep.setFont(tf);
		dep.setForeground(new Color(76,75,66));
		dep.setBounds(200,210,170,50);
		add(dep);
		bd.setFont(tf);
		bd.setForeground(new Color(76,75,66));
		bd.setBounds(200,270,100,50);
		add(bd);
		gen.setFont(tf);
		gen.setForeground(new Color(76,75,66));
		gen.setBounds(200,330,80,50);
		add(gen);
		cont.setFont(tf);
		cont.setForeground(new Color(76,75,66));
		cont.setBounds(200,390,110,50);
		add(cont);
		adr.setFont(tf);
		adr.setForeground(new Color(76,75,66));
		adr.setBounds(200,450,80,50);
		add(adr);

		j1=new JTextField();
		j1.setFont(tf);
		j1.setBounds(330,100,250,30);
		add(j1);
		j2=new JTextField();
		j2.setFont(tf);
		j2.setBounds(330,160,250,30);
		add(j2);
		j3=new JTextField();
		j3.setFont(tf);
		j3.setBounds(330,220,250,30);
		add(j3);
		j4=new JTextField();
		j4.setFont(tf);
		j4.setBounds(330,280,210,30);
		add(j4);
		JButton b = new JButton("...");
		b.setFont(tf);
		b.setBackground(bac);
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
		b.setBounds(542,280,30,30);
		add(b);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JFrame ff = new JFrame();
				selectDate ddd = new selectDate(ff);
				String datee = ddd.setPickedDate();
				j4.setText(datee);
				ff.setVisible(false);
			}
		});
		
		gend = new JComboBox(gndr);
		gend.setFont(tf);
		gend.setBounds(330,340,250,30);
		add(gend);
		j6=new JTextField();
		j6.setFont(tf);
		j6.setBounds(330,400,250,30);
		add(j6);
		j7=new JTextField();
		j7.setFont(tf);
		j7.setBounds(330,460,250,30);
		add(j7);
		
		Icon p1 = new ImageIcon("ad.png");
		JButton add=new JButton(p1);
		buttonCustom(add);
		add.setBounds(700,530,124,64);
		add(add);
		Icon p2 = new ImageIcon("back.png");
		JButton bak=new JButton(p2);
		buttonCustom(bak);
		bak.setBounds(570,530,124,64);
		add(bak);
		add(top);
		add(down);
		setResizable(false);
		setVisible(true);
		
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				
				String roll = j1.getText();
				String name = j2.getText();
				String dep = j3.getText();
				String bd = j4.getText();
				String gen = (String) gend.getSelectedItem();
				String cont = (String)j6.getText();
				String adr = j7.getText();
				if(roll.equals("")||name.equals("") || dep.equals("") || bd.equals("") || cont.equals("") || adr.equals("")){
					JOptionPane.showMessageDialog(null,"Please provide complete information"); 
				}
				else
				{
					try{
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection con = DriverManager.getConnection("jdbc:ucanaccess://Student.accdb") ;
						Statement st = con.createStatement () ;
						String sql = "insert into Information(RollNo,SName,SDept,Birthdate,Gender,ContactNo,Address) Values('"+roll+"','"+name+"','"+dep+"','"+bd+"','"+gen+"','"+cont+"','"+adr+"') ";
						int num = st.executeUpdate (sql) ;
						JOptionPane.showMessageDialog(null, "Record Added Successfully.");
						con.close () ;
						setVisible(false);
						new menu();
					}
					catch(Exception ae) {
						JOptionPane.showMessageDialog(null,ae);	
					} 
				}
				

				}
			}
		);
		bak.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new menu();
			}
		}
		);
		
	}

}