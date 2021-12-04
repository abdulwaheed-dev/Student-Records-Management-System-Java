/*///////////////////////////////////////
Coder: Abdul Waheed Chachar
CMS ID: 021-19-0044
Class: BSCS-II, Section: A
Suukur IBA University 
*////////////////////////////////////////
package records;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class Design extends JFrame{
	JLabel title,username,pass,ends,ends1,title1;
	JTextField tusername;
	JButton blogin,bexit,babout;
	JPasswordField tpass;
	Font tf = new Font("Arial",Font.PLAIN,20);
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);	
	
	void buttonsett(JButton b) {
//		b.setFont(tf);
//		b.setBackground(bac);
//	    b.setForeground(Color.WHITE);
//	    b.setFocusPainted(false);
		b.setBorderPainted(false);
		b.setBackground(new Color(245,242,208));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}
	
	Design(){
		setTitle("Welcome");
		getContentPane().setBackground(new Color(245,242,208));		
		setBounds(280,100,800,489);
		setUndecorated(true);
		setLayout(null);
		
		Icon icon = new ImageIcon("symbol-delete-icon.png");
		JButton button7 = new JButton(icon);
		button7.setToolTipText("Close");
		buttonsett(button7);
		button7.setBounds(750,0,48,48);
		add(button7);
		
		Icon icon1 = new ImageIcon("math-minus-icon.png");
		JButton button8 = new JButton(icon1);
		button8.setToolTipText("Minimize");
		buttonsett(button8);
		button8.setBounds(695,0,48,48);
		add(button8);
		
		JPanel left = new JPanel();
		left.setBounds(0,0,400,490);
		left.setBackground(bac);
		left.setLayout(null);

		ImageIcon mono1 = new ImageIcon("iba.png");
		JLabel logo1 = new JLabel("",mono1,JLabel.CENTER);
		logo1.setBounds(105,25,180,101);
		left.add(logo1);
		
		ImageIcon mono = new ImageIcon("logo.png");
		JLabel logo = new JLabel("",mono,JLabel.CENTER);
		logo.setBounds(60,155,256,256);
		left.add(logo);
		
		ends1 = new JLabel("All Rights Reserved.",SwingConstants.LEFT);
		ends1.setFont(new Font("Arial",Font.PLAIN,15));
		ends1.setForeground(Color.white);
		ends1.setBounds(5,457,150,40);
		left.add(ends1);
		
		JPanel right = new JPanel();
		right.setBounds(427,65,350,400);
		right.setBorder(new LineBorder(bac , 4));
		right.setBackground(new Color(245,242,208));
		right.setLayout(null);
		
		title = new JLabel("Students Management",SwingConstants.CENTER);
		title.setFont(new Font("Times New Roman",Font.ITALIC,30));
		title.setForeground(bac);
		title.setBounds(23,5,300,60);
		right.add(title);
		
		JLabel title1 = new JLabel("System",SwingConstants.CENTER);
		title1.setFont(new Font("Times New Roman",Font.ITALIC,30));
		title1.setForeground(bac);
		title1.setBounds(120,50,100,60);
		right.add(title1);
		
		ends = new JLabel("Lenovo Creations.",SwingConstants.RIGHT);
		ends.setFont(new Font("Arial",Font.PLAIN,15));
		ends.setForeground(Color.white);
		ends.setBounds(240,457,150,40);
		left.add(ends);

		username = new JLabel("Username: ");
		username.setFont(new Font("Microsoft JhengHei UI",Font.BOLD,20));
		username.setForeground(bac);
		username.setBounds(50,105,130,50);
		right.add(username);
		
		tusername = new JTextField();
		tusername.setFont(new Font("Microsoft JhengHei UI",Font.BOLD,20));
		tusername.setBackground(new Color(245,242,208));
		tusername.setBorder(new LineBorder(bac,2));
		tusername.setForeground(bac);
		tusername.setBounds(55,155,260,35);
		right.add(tusername);
		
		pass = new JLabel("Password: ");
		pass.setFont(new Font("Microsoft JhengHei UI",Font.BOLD,20));
		pass.setForeground(bac);
		pass.setBounds(50,205,130,50);
		right.add(pass);
		
		tpass = new JPasswordField();
		tpass.setFont(new Font("Microsoft JhengHei UI",Font.PLAIN,25));
		tpass.setBorder(new LineBorder(bac,2));
		tpass.setBackground(new Color(245,242,208));
		tpass.setForeground(bac);
		tpass.setBounds(55,255,260,35);
		right.add(tpass);
		
		Icon i = new ImageIcon("blogin.png");
		blogin = new JButton(i);
		buttonsett(blogin);
		blogin.setBounds(60,325,124,47);
		right.add(blogin);
		
		Icon j = new ImageIcon("bexit.png");
		bexit = new JButton(j);
		buttonsett(bexit);
		bexit.setBounds(200,325,112,47);
		right.add(bexit);
		
		add(right);
		add(left);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		button7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}	
		);
		button8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//setState(Frame.ICONIFIED);
				setExtendedState(JFrame.ICONIFIED);
			}
		}	
		);
		
		blogin.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e) {
			String u,p;
			u =  tusername.getText();
			p = tpass.getText();
			if((u.equals("admin"))&&(p.equals("123"))) {
				setVisible(false);
				new menu();
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
			}
		}
		}	
		);
		bexit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}	
		);
	}
}
public class login{

	public static void main(String args[]){
		new Design();
		
	}
}