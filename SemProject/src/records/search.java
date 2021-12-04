package records;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class search extends JFrame {
	
	
	JTextField j1,j2,j3,j4,j5,j6,j7,j8;
	Font tf = new Font("Microsoft JhengHei UI",Font.PLAIN,18);
	Color butt = new Color(47, 48, 52);	
	Color bac = new Color(29,41,81);
	
	void buttonCustom(JButton b) {
		b.setBorderPainted(false);
		b.setBackground(new Color(245,242,208));
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
	}
	
	search(){
		setTitle("Search Record");
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
		
		JLabel entr=new JLabel("Enter Name to Search:");
		JLabel ap=new JLabel("Search a Record");
		JLabel roll=new JLabel("Roll No:");
		JLabel name=new JLabel("Name:");
		JLabel dept=new JLabel("Department:");
		JLabel bd=new JLabel("Birthdate:");
		JLabel gen=new JLabel("Gender:");
		JLabel cont=new JLabel("Contact No:");
		JLabel adr=new JLabel("Address:");
		
		entr.setFont(tf);
		entr.setForeground(new Color(76,75,66));
		entr.setBounds(120,90,200,40);
		add(entr);
		j8=new JTextField();
		j8.setFont(tf);
		j8.setBounds(350,90,250,40);
		add(j8);
		
		Icon p22 = new ImageIcon("ss.png");
		JButton sear=new JButton(p22);
		buttonCustom(sear);
		sear.setBounds(620,75,124,64);
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
		j1.setEditable(false);
		j1.setBounds(330,160,250,30);
		add(j1);
		j2=new JTextField();
		j2.setFont(tf);
		j2.setEditable(false);
		j2.setBounds(330,220,250,30);
		add(j2);
		j3=new JTextField();
		j3.setFont(tf);
		j3.setEditable(false);
		j3.setBounds(330,280,250,30);
		add(j3);
		j4=new JTextField();
		j4.setFont(tf);
		j4.setEditable(false);
		j4.setBounds(330,340,250,30);
		add(j4);
		j5=new JTextField();
		j5.setFont(tf);
		j5.setEditable(false);
		j5.setBounds(330,400,250,30);
		add(j5);
		j6=new JTextField();
		j6.setFont(tf);
		j6.setEditable(false);
		j6.setBounds(330,460,250,30);
		add(j6);
		j7=new JTextField();
		j7.setFont(tf);
		j7.setEditable(false);
		j7.setBounds(330,520,250,30);
		add(j7);
		
		Icon p2 = new ImageIcon("back.png");
		JButton bak=new JButton(p2);
		buttonCustom(bak);
		bak.setBounds(700,530,124,64);
		
		add(bak);
		add(top);
		add(down);
		setResizable(false);
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
				    rs = find(j8.getText());
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
		bak.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new menu();
			}
		}
		);
		
	}
    public ResultSet find(String s){
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
