package records;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class deleteAll extends JFrame {
	
	Font tf = new Font("Microsoft JhengHei UI",Font.PLAIN,18);
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);
	
	void buttonCustom(JButton b) {
		b.setBorderPainted(false);
		b.setBackground(new Color(245,242,208));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}
	
	deleteAll(){
		setTitle("Delete All Records");
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
		
		JLabel ap=new JLabel("Delete All Records");	
		ap.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,28));
		ap.setForeground(Color.white);
		ap.setBounds(15,20,400,40);
		top.add(ap);
		
		JLabel l1=new JLabel("Click here to DELETE ALL RECORDS.",SwingConstants.CENTER);
		l1.setBorder(new LineBorder(bac,2));
		l1.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,22));
		l1.setForeground(new Color(76,75,66));
		l1.setBounds(220,250,450,60);
		add(l1);
		
		Icon p25 = new ImageIcon("click.png");
		JButton del=new JButton(p25);
		buttonCustom(del);
		del.setBounds(380,330,152,64);
		add(del);
		
		Icon p23 = new ImageIcon("back.png");
		JButton bak=new JButton(p23);
		buttonCustom(bak);
		bak.setBounds(700,530,124,64);
		add(bak);
		
		add(top);
		add(down);
		setVisible(true);
		
		bak.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new menu();
			}
		}
		);
		del.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{ 
				int Flag = 0;
				Connection con = null;
			    PreparedStatement ps = null;
				        try{
						Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
					   	con = DriverManager.getConnection("jdbc:ucanaccess://Student.accdb") ;
					   	String sqlc = "DELETE FROM Information";
					   	ps = con.prepareStatement(sqlc);
				        Flag = ps.executeUpdate();
				        JOptionPane.showMessageDialog(null, "All Records Deleted Successfully");
				        ps.close();
				        }
					   catch(Exception ex){
				           	JOptionPane.showMessageDialog(null, ex.getMessage());
				        }					
				   
				}
				
			}
		);
		
	}

}

