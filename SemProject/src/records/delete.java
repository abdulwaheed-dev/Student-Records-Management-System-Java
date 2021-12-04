package records;
import javax.swing.*;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class delete extends JFrame {
	
	Font tf = new Font("Microsoft JhengHei UI",Font.PLAIN,18);
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);
	
	void buttonsett(JButton b) {
		b.setBorderPainted(false);
		b.setBackground(new Color(245,242,208));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}
	
	delete(){
		setTitle("Delete Record");
		setBounds(220,10,870,700);
		getContentPane().setBackground(new Color(245,242,208));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JPanel top= new JPanel();
		top.setBackground(bac);
		top.setBounds(0,0,870,100);
		top.setLayout(null);
		
		JPanel down= new JPanel();
		down.setBackground(bac);
		down.setBounds(0,615,870,50);
		down.setLayout(null);
		
		JLabel ends = new JLabel("Lenovo Creations.",SwingConstants.RIGHT);
		ends.setFont(new Font("Arial",Font.PLAIN,17));
		ends.setForeground(Color.white);
		ends.setBounds(270,620,580,40);
		add(ends);
		
		JLabel ends1 = new JLabel("All Rights Reserved.",SwingConstants.LEFT);
		ends1.setFont(new Font("Arial",Font.PLAIN,17));
		ends1.setForeground(Color.white);
		ends1.setBounds(5,620,600,40);
		add(ends1);
		
		JLabel ap=new JLabel("Delete a Record");	
		ap.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,28));
		ap.setForeground(Color.white);
		ap.setBounds(15,40,400,40);
		top.add(ap);
		
		JLabel dele = new JLabel("Enter Name to Delete:");
		dele.setForeground(bac);
		dele.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 25));
		dele.setBounds(200,250,350,64);
		add(dele);
		
		JTextField del = new JTextField();
		del.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 25));
		del.setBackground(new Color(245,242,208));
	    del.setForeground(bac);
		del.setBounds(200,320,300,45);
		add(del);
		
		Icon i1 = new ImageIcon("dd.png");
		JButton da = new JButton(i1);
		buttonsett(da);
		da.setBounds(550,306,124,64);
		add(da);
		
		Icon p2 = new ImageIcon("back.png");
		JButton bak=new JButton(p2);
		buttonsett(bak);
		bak.setBounds(330,410,124,64);
		add(bak);
		
		
		add(top);
		add(down);
		setResizable(false);
		setVisible(true);
		
		da.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				int Flag = 0;
				String todel = del.getText();
				if(todel.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter name to delete");
				}
				else {
					Connection con = null;
				    PreparedStatement ps = null;
				        try{
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					   	con = DriverManager.getConnection("jdbc:ucanaccess://Student.accdb") ;
					   	String sqlc = "DELETE FROM Information WHERE SName = ?";
					   	ps = con.prepareStatement(sqlc);
				        ps.setString(1,todel);
				         Flag = ps.executeUpdate();
				         
				        ps.close();
				        }
					   catch(Exception ex){
				           	JOptionPane.showMessageDialog(null, ex.getMessage());
				        }
				        if( Flag == 1) {
				        	JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
				        }
				        else {
				        	JOptionPane.showMessageDialog(null, "Sorry, Record Not Found");
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