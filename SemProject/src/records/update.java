package records;
import javax.swing.*;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class update extends JFrame {
	
	
	 JTextField j1,j2,j3,j4,j5,j6,j7,j8;
	Font tf = new Font("Microsoft JhengHei UI",Font.PLAIN,18);
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);
	
	void buttonCustom(JButton b) {
		b.setFont(tf);
		b.setBackground(bac);
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	}
	
	update(){
		setTitle("Update Record");
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
		
		JLabel entr=new JLabel("Enter Name to Update:");
		JLabel ap=new JLabel("Update a Record");
		JLabel roll=new JLabel("Roll No:"); 
		JLabel name=new JLabel("Name:");
		JLabel dept=new JLabel("Department:");
		JLabel bd=new JLabel("Birthdate:");
		JLabel gen=new JLabel("Gender:");
		JLabel cont=new JLabel("Contact No:");
		JLabel adr=new JLabel("Address:");
		
		entr.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,18));
		entr.setForeground(new Color(76,75,66));
		entr.setBounds(140,90,220,30);
		add(entr);
		j8=new JTextField();
		j8.setFont(tf);
		j8.setBounds(380,90,200,30);
		add(j8);
		JButton sear=new JButton("Search");
		buttonCustom(sear);
		sear.setBounds(590,90,100,30);
		add(sear);
		
		ap.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,28));
		ap.setForeground(Color.white);
		ap.setBounds(15,20,400,40);
		top.add(ap);
		roll.setFont(tf);
		roll.setForeground(new Color(76,75,66));
		roll.setBounds(200,150,80,50);
		add(roll);
		name.setFont(tf);
		name.setForeground(new Color(76,75,66));
		name.setBounds(200,210,80,50);
		add(name);
		dept.setFont(tf);
		dept.setForeground(new Color(76,75,66));
		dept.setBounds(200,270,120,50);
		add(dept);
		bd.setFont(tf);
		bd.setForeground(new Color(76,75,66));
		bd.setBounds(200,330,100,50);
		add(bd);
		gen.setFont(tf);
		gen.setForeground(new Color(76,75,66));
		gen.setBounds(200,390,80,50);
		add(gen);
		cont.setFont(tf);
		cont.setForeground(new Color(76,75,66));
		cont.setBounds(200,450,110,50);
		add(cont);
		adr.setFont(tf);
		adr.setForeground(new Color(76,75,66));
		adr.setBounds(200,510,80,50);
		add(adr);

		j1=new JTextField();
		j1.setFont(tf);
		j1.setBounds(330,160,250,30);
		add(j1);
		j2=new JTextField();
		j2.setFont(tf);
		j2.setBounds(330,220,250,30);
		add(j2);
		j3=new JTextField();
		j3.setFont(tf);
		j3.setBounds(330,280,250,30);
		add(j3);
		j4=new JTextField();
		j4.setFont(tf);
		j4.setBounds(330,340,250,30);
		add(j4);
		j5=new JTextField();
		j5.setFont(tf);
		j5.setBounds(330,400,250,30);
		add(j5);
		j6=new JTextField();
		j6.setFont(tf);
		j6.setBounds(330,460,250,30);
		add(j6);
		j7=new JTextField();
		j7.setFont(tf);
		j7.setBounds(330,520,250,30);
		add(j7);
		
		JButton upd=new JButton("Update");
		buttonCustom(upd);
		upd.setBounds(730,560,100,40);
		add(upd);
		
		JButton bak=new JButton("Back");
		buttonCustom(bak);
		bak.setBounds(620,560,100,40);
		add(bak);
		
		add(top);
		add(down);
		setVisible(true);
		
		sear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				String tosearch = j8.getText();
				if(tosearch.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter name to search");
				}
				else {
				    ResultSet rs = null;
				    rs = find1(j8.getText());
				    try{
				        if(rs.next()){
				            j1.setText(rs.getString("RollNo"));
				            j2.setText(rs.getString("SName"));
				            j3.setText(rs.getString("SDept"));
				            j4.setText(rs.getString("Birthdate"));
				            j5.setText(rs.getString("Gender"));
				            j6.setText(rs.getString("ContactNo"));
				            j7.setText(rs.getString("Address"));
				        }  else{
				            JOptionPane.showMessageDialog(null, "NO DATA FOUND FOR THIS NAME.");
				        }
				      }catch(Exception ex){
				             JOptionPane.showMessageDialog(null, ex.getMessage());
				              }
				      }
				}
				
			}
		);
		upd.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) 
			{ 	
				String toupd1 = j8.getText();
				int Flag=0;
				String roll = (String)j1.getText();
				String name = (String)j2.getText();
				String dep = (String)j3.getText();
				String bd = (String)j4.getText();
				String gen = (String)j5.getText();
				String cont = (String)j6.getText();
				String adr = (String)j7.getText();
				if(roll.equals("")||name.equals("") || dep.equals("") || bd.equals("") || cont.equals("") || adr.equals("")||gen.equals("")){
					JOptionPane.showMessageDialog(null,"Please provide complete information"); 
				}
				else
				{
					try{
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection con = DriverManager.getConnection("jdbc:ucanaccess://Student.accdb");
						Statement stmt = con.createStatement();
						//String sqls="UPDATE Information SET RollNo = '"+roll+"', SName = '"+name+"', SDept = '"+dep+"', Birthdate = '"+bd+"', Gender = '"+gen+"', ContactNo = '"+cont+"', Address = '"+adr+"'"+"WHERE SName = '"+toupd1+"'";
						Flag=stmt.executeUpdate("update Information set RollNo='"+roll+"' where SName='"+toupd1+"'");
						Flag=stmt.executeUpdate("update Information set SName='"+name+"' where SName='"+toupd1+"'");	
						Flag=stmt.executeUpdate("update Information set SDept='"+dep+"' where SName='"+toupd1+"'");
						Flag=stmt.executeUpdate("update Information set Birthdate='"+bd+"' where SName='"+toupd1+"'");
						Flag=stmt.executeUpdate("update Information set Gender='"+gen+"' where SName='"+toupd1+"'");
						Flag=stmt.executeUpdate("update Information set ContactNo='"+cont+"' where SName='"+toupd1+"'");
						Flag=stmt.executeUpdate("update Information set Address='"+adr+"' where SName='"+toupd1+"'");
						con.close () ;
						//
						stmt.close();
					}
					catch(Exception ae) {
						JOptionPane.showMessageDialog(null,ae.getMessage());	
					}
					if(Flag==1) {
						JOptionPane.showMessageDialog(null, "Record Updated Successfully.");
						setVisible(false);
						new menu();
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
	
	public ResultSet find1(String s){
    	Connection con = null;
    	PreparedStatement ps =null;
    	ResultSet rs =null;
        try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	   	con = DriverManager.getConnection("jdbc:ucanaccess://Student.accdb") ;
	   	ps = con.prepareStatement("select * from Information where SName = ?");
        	ps.setString(1,s);
        	rs = ps.executeQuery();
        }
	   catch(Exception ex){
           	JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return rs;
	}

}
