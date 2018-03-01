import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class GUI {
	Buttons button=new Buttons();
public JPanel getPanelDown()
{
	JButton settings=button.getSettings();
	JButton add=button.Addnew();
	Border blackline = BorderFactory.createLineBorder(Color.black);
JPanel panel4=new JPanel();
settings.setBounds(500,5, 50, 50);
add.setBounds(440, 5, 50, 50);
panel4.add(settings);
panel4.add(add);
panel4.setLayout(null);
panel4.setBackground(new Color(11,187,249));
panel4.setBounds(0,370,643,60);					//end panel
panel4.setBorder(blackline);

ActionListener al=new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
	
	main m1=new main();
	m1.exte();
	}
};
add.addActionListener(al);


return panel4;
}

public JPanel getPanelRight()
{
	JPanel panel3=new JPanel();
	return panel3;
}
public JPanel getAddPanel()
{	
	 Border blackline = BorderFactory.createLineBorder(Color.black);
	 Border titledbi=BorderFactory.createTitledBorder(blackline,"Add New Contact");
	 ImageIcon contactsimg=new ImageIcon("images/contacts2.jpg");
	final JTextField Name=new JTextField();
	JLabel Namel=new JLabel("Name : ");
	Namel.setBounds(120, 20, 50, 25);
	Name.setBounds(120, 45, 180, 25);
	final JTextField Number=new JTextField();
	JLabel Numberl=new JLabel("Number : ");
	Number.setBounds(120, 95, 180, 25);
	Numberl.setBounds(120, 70, 90, 25 );
	final JTextField Address=new JTextField();
	JLabel Addressl=new JLabel("Address : ");
	Address.setBounds(20, 150, 280, 25);
	Addressl.setBounds(20, 125, 280, 25);
	final JTextField Email=new JTextField();
	JLabel Emaill=new JLabel("E-mail Address :");	
	Email.setBounds(20, 205, 280, 25);
	Emaill.setBounds(20, 175, 280, 25);
	JLabel conicon=new JLabel(contactsimg);
	conicon.setBounds(20, 32, 93, 92);
	JPanel AddPanel=new JPanel();
	AddPanel.setLayout(null);
	AddPanel.setBounds(320,55,310,300);
	JButton cancel=button.GetCancel();
	JButton save=button.GetSave();
	save.setBounds(5, 245, 110, 45);
	cancel.setBounds(110, 245, 110, 45);
	AddPanel.add(cancel);
	AddPanel.add(save);
	AddPanel.add(Name);
	AddPanel.add(Namel);
	AddPanel.add(Email);
	AddPanel.add(Emaill);
	AddPanel.add(conicon);
	AddPanel.add(Address);
	AddPanel.add(Addressl);
	AddPanel.add(Number);
	AddPanel.add(Numberl);
	AddPanel.setBorder(titledbi);
	ActionListener al=new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			main m1=new main();
			m1.extecancel();
		}
};
cancel.addActionListener(al);

	ActionListener al2=new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			Database db=new Database();
			ArrayList<String> info=new ArrayList<String>(); 
			if(Name.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please Enter Something in The TEXT BOX");	
				return;
			}
			info.add(Name.getText());
			info.add(Number.getText());
			info.add(Address.getText());
			info.add(Email.getText());
			db.AddDatabase(info);
			main m1=new main();
			m1.extecancel();
		}
		
	};
	save.addActionListener(al2);
	return AddPanel;
}
}

