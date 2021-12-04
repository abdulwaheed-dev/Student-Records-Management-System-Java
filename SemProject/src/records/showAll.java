package records;
import javax.swing.*;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class showAll extends JFrame {
	
	Font tf = new Font("Microsoft JhengHei UI",Font.PLAIN,18);
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);
	
	void buttonCustom(JButton b) {
		b.setFont(tf);
		b.setBackground(bac);
	    b.setForeground(Color.WHITE);
	    b.setFocusPainted(false);
	}
	void labelset(JLabel b) {
		b.setForeground(bac);
		b.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 17));
	}
	
	showAll(){
		setTitle("Display All Records");
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
		
		JLabel ap=new JLabel("Display All Records");	
		ap.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,28));
		ap.setForeground(Color.white);
		ap.setBounds(15,40,400,40);
		top.add(ap);
		
		JButton da=new JButton("Click to Display");
		da.setFont(tf);
		da.setBackground(new Color(245,242,208));
	    da.setForeground(bac);
	    da.setFocusPainted(false);
		da.setBounds(590,40,200,40);
		top.add(da);
		
		JButton bak=new JButton("Back");
		buttonCustom(bak);
		bak.setBounds(520,560,100,40);
		add(bak);
		
		JLabel r = new JLabel("Roll No",SwingConstants.CENTER);
		JLabel n = new JLabel("Name",SwingConstants.CENTER);
		JLabel d = new JLabel("Department",SwingConstants.CENTER);
		JLabel b = new JLabel("Birthdate",SwingConstants.CENTER);
		JLabel g = new JLabel("Gender",SwingConstants.CENTER);
		JLabel c = new JLabel("Contact No",SwingConstants.CENTER);
		JLabel a = new JLabel("Address",SwingConstants.CENTER);
		
		labelset(r);
		r.setBounds(20,110,117,40);
		add(r);
		labelset(n);
		n.setBounds(136,110,117,40);
		add(n);
		labelset(d);
		d.setBounds(252,110,118,40);
		add(d);
		labelset(b);
		b.setBounds(369,110,117,40);
		add(b);
		labelset(g);
		g.setBounds(485,110,117,40);
		add(g);
		labelset(c);
		c.setBounds(600,110,117,40);
		add(c);
		labelset(a);
		a.setBounds(716,110,119,40);
		add(a);

		JTable table = new JTable();
		table.removeEditor();
		table.setBorder(new LineBorder(bac,1));
		table.setRowHeight(30);
		table.setShowGrid(true);
        table.setGridColor(bac);
        table.setBackground(new Color(245,242,208));
        table.setForeground(bac);
        table.setSelectionBackground(bac);
        table.setSelectionForeground(new Color(245,242,208));
        table.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 17)); 
		table.setBounds(20,150,815,400);
		add(table);
		
		
		add(top);
		add(down);
		setResizable(false);
		setVisible(true);
		
		da.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				View v = new View();
				v.DisplayRecord(table);
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
class View{
	public void DisplayRecord(JTable table1) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			Connection con = DriverManager.getConnection("jdbc:ucanaccess://Student.accdb") ;
			Statement st = con.createStatement () ;
			String sql = "SELECT * FROM Information";
			ResultSet rs = st.executeQuery(sql);
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			
		}
		catch(Exception ae) {
			JOptionPane.showMessageDialog(null,ae);
		}
	}
}

