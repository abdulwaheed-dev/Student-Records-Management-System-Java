/*///////////////////////////////////////
Coder: Abdul Waheed Chachar
CMS ID: 021-19-0044
Class: BSCS-II, Section: A
Suukur IBA University 
*////////////////////////////////////////
package records;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.io.* ;
import java.awt.event.*;
import javax.swing.border.LineBorder;

class menu extends JFrame{
	
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);	
	Font tf = new Font("Arial",Font.PLAIN,20);
	JLabel title,tmenu,ends,ends1;
	
	void buttonCustom(JButton b) {
		b.setBorderPainted(false);
		b.setBackground(new Color(245,242,208));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}

	menu(){
		setTitle("Main Menu");
		getContentPane().setBackground(new Color(245,242,208));
		setBounds(220,10,870,700);
		setLayout(null);
		
		JPanel top= new JPanel();
		top.setBackground(bac);
		top.setBounds(0,0,870,100);
		top.setLayout(null);
		
		JPanel down= new JPanel();
		down.setBackground(bac);
		down.setBounds(0,615,870,50);
		down.setLayout(null);
		
		title = new JLabel("DASHBOARD", SwingConstants.CENTER);
		title.setFont(new Font("Constantia",Font.PLAIN,40));
		title.setForeground(Color.white);
		title.setBounds(150,20,570,70);
		add(title);
		
		Icon i1 = new ImageIcon("add.png");
		JButton btn1 = new JButton(i1);
		btn1.setBounds(40,170,242,64);
		buttonCustom(btn1);
		add(btn1);
		
		Icon i2 = new ImageIcon("search.png");
		JButton btn4 = new JButton(i2);
		btn4.setBounds(307,170,240,64);
		buttonCustom(btn4);
		add(btn4);
		
		Icon i3 = new ImageIcon("delete.png");
		JButton btn5 = new JButton(i3);
		btn5.setBounds(570,170,242,64);
		buttonCustom(btn5);
		add(btn5);
		
		Icon i4 = new ImageIcon("showall.png");
		JButton btn2 = new JButton(i4);
		btn2.setBounds(40,290,242,64);
		buttonCustom(btn2);
		add(btn2);
		
		Icon i5 = new ImageIcon("update.png");
		JButton btn3 = new JButton(i5);
		btn3.setBounds(307,290,238,64);
		buttonCustom(btn3);
		add(btn3);
		
		Icon i6 = new ImageIcon("erase.png");
		JButton btn6 = new JButton(i6);
		btn6.setBounds(570,290,244,64);
		buttonCustom(btn6);
		add(btn6);
		
		Icon i7 = new ImageIcon("about.png");
		JButton babout = new JButton(i7);
		babout.setBounds(450,410,206,64);
		buttonCustom(babout);
		add(babout);
		
		babout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new about();
			}
		}	
		);
		
		Icon i8 = new ImageIcon("exit.png");
		JButton btn7 = new JButton(i8);
		btn7.setBounds(200,410,206,64);
		buttonCustom(btn7);
		add(btn7);
		
		JButton logout = new JButton("Logout");
		logout.setFont(tf);
		logout.setBackground(bac);
		logout.setForeground(Color.WHITE);
		logout.setFocusPainted(false);
		logout.setBounds(730,560,100,40);
		add(logout);
		
		ends = new JLabel("Lenovo Creations.",SwingConstants.RIGHT);
		ends.setFont(new Font("Arial",Font.PLAIN,17));
		ends.setForeground(Color.white);
		ends.setBounds(275,620,580,40);
		add(ends);
		
		ends1 = new JLabel("All Rights Reserved.",SwingConstants.LEFT);
		ends1.setFont(new Font("Arial",Font.PLAIN,17));
		ends1.setForeground(Color.white);
		ends1.setBounds(5,620,600,40);
		add(ends1);

		add(top);
		add(down);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		btn1.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new add();
			}
			}	
		);
		btn3.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new update();
		}
		}	
		);
		btn2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new showAll();
		}
		}	
		);
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			new search();
			}
		}	
		);
		btn5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new delete();
			}
		}	
		);
		btn6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new deleteAll();
			}
		}	
		);
		btn7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				//new Design();
				System.exit(0);
			}
		}	
		);
		logout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Design();
			}
		}	
		);
	}

}