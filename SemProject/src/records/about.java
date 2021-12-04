/*///////////////////////////////////////
Coder: Abdul Waheed Chachar
CMS ID: 021-19-0044
Class: BSCS-II, Section: A
Suukur IBA University 
*////////////////////////////////////////

package records;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

class about extends JFrame {
	
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);
	Font tf = new Font("Arial",Font.PLAIN,20);
	JLabel title,title1, menu,ends,ends1;
	JButton close,backb;
	
	void buttonCustom(JButton b) {
		b.setBorderPainted(false);
		b.setBackground(new Color(245,242,208));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}
	void labelset(JLabel info) {
		info.setFont(new Font("Bodoni MT",Font.PLAIN,30));
		info.setForeground(bac);
	}
	void labelset1(JLabel info1) {
		info1.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,24));
		info1.setForeground(bac);
	}
	
	about(){
		setName("About Us");
		getContentPane().setBackground(Color.white);
		setBounds(220,10,870,700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		title = new JLabel("ABOUT US");
		title.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,28));
		title.setForeground(Color.white);
		title.setBounds(15,20,400,40);
		top.add(title);
		
		ImageIcon mono3 = new ImageIcon("ext.jpg");
		JLabel logo1 = new JLabel("",mono3,JLabel.CENTER);
		logo1.setBounds(70,90,242,185);
		add(logo1);
		
		ImageIcon mono4 = new ImageIcon("logo.png");
		JLabel logo = new JLabel("",mono4,JLabel.CENTER);
		logo.setBounds(70,290,256,256);
		add(logo);
		
		JLabel jl1 = new JLabel("Project Name:");
		JLabel jl2 = new JLabel("Developer:");
		JLabel jl3 = new JLabel("Department:");
		JLabel jl4 = new JLabel("Semester:");
		JLabel jl5 = new JLabel("Teacher:");
		JLabel jl6 = new JLabel("Language:");
		JLabel jl7 = new JLabel("Student Records System");
		JLabel jl8 = new JLabel("Ab.Waheed Chachar");
		JLabel jl9 = new JLabel("Computer Science");
		JLabel jl10 = new JLabel("II_Fall-2019");
		JLabel jl11 = new JLabel("G.Mujtaba Shaikh");
		JLabel jl12 = new JLabel("JAVA.");
		labelset(jl1);
		labelset(jl2);
		labelset(jl3);
		labelset(jl4);
		labelset(jl5);
		labelset(jl6);
		labelset1(jl7);
		labelset1(jl8);
		labelset1(jl9);
		labelset1(jl10);
		labelset1(jl11);
		labelset1(jl12);
				
		jl1.setBounds(360,100,200,40);
		add(jl1);
		jl2.setBounds(360,170,200,40);
		add(jl2);
		jl3.setBounds(360,240,200,40);
		add(jl3);
		jl4.setBounds(360,310,200,40);
		add(jl4);
		jl5.setBounds(360,380,200,40);
		add(jl5);
		jl6.setBounds(360,450,200,40);
		add(jl6);
		jl7.setBounds(560,100,300,40);
		add(jl7);
		jl8.setBounds(560,170,250,40);
		add(jl8);
		jl9.setBounds(560,240,250,40);
		add(jl9);
		jl10.setBounds(560,310,250,40);
		add(jl10);
		jl11.setBounds(560,380,250,40);
		add(jl11);
		jl12.setBounds(560,450,250,40);
		add(jl12);
		Icon p27 = new ImageIcon("back.png");
		JButton bak=new JButton(p27);
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
	}
	
}