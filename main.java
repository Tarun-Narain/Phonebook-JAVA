import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;


public class main{
	public static JPanel panel2=new JPanel();
	public static JFrame frame=new JFrame("My Phonebook");
	public static JPanel panel3;
	public static JPanel panel5;
	public static DefaultListModel<String> dlm=new DefaultListModel<>();
	public static JList<String> list=new JList<>(dlm);
	public static JTextField enter_con=new JTextField();
	 public static void main(String args[])
	{
		 GUI graphics=new GUI();
	Buttons button=new Buttons();
	JButton edit=button.GetEdit();
	final JButton save=button.GetSave();
	final JButton cancel=button.GetCancel();
	ImageIcon contactsimg=new ImageIcon("images/contacts.jpg");
 
	final Database db=new Database();
	final JTextField vari=new JTextField();
	ArrayList<String> contacts=db.GetContacts();
			for(String i:contacts)
			{
				dlm.addElement(i);
			}
	JLabel title=new JLabel("PHONEBOOK");
		
	JPanel panel1=new JPanel();
	JPanel panel4 =graphics.getPanelDown();
	panel3 =graphics.getPanelRight();
		
	Border blackline = BorderFactory.createLineBorder(Color.black);
	Border titledb=BorderFactory.createTitledBorder(blackline,"Search");				//borders titled
	Border titledbi=BorderFactory.createTitledBorder(blackline,"Selected Contact");
	
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//main frame
	frame.setBounds(300,150,650,460);
	frame.setLayout(null);							
	frame.setResizable(false);
		
	title.setBounds(230,10,400,30);
	title.setFont(new Font("", Font.ITALIC, 24));
	
	panel1.setLayout(null);
	panel1.setBounds(0,0,650,50);							//panel1 phone-book title
	panel1.setBorder(blackline);
	panel1.setBackground(new Color(11,187,249));
	panel1.add(title);
	frame.add(panel1);
	
	panel2.setLayout(null);
	panel2.setBorder(titledb);					//panel2 search
	panel2.setBounds(10,55,300,300);
	enter_con.setBounds(15,25,270,27);			//text box contacts
	list.setBounds(15,60,270,225);					//JList
	list.setBorder(blackline);
	panel2.add(list);
	panel2.add(enter_con);
	frame.add(panel2);

	panel3.setLayout(null);	
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
	edit.setBounds(220, 245, 80, 45);
	cancel.setVisible(false);
	save.setVisible(false);
	save.setBounds(10, 245, 110, 45);
	cancel.setBounds(110, 245, 110, 45);
	Name.setEditable(false);
	Address.setEditable(false);
	Number.setEditable(false);
	Email.setEditable(false);

	panel3.add(cancel);
	panel3.add(edit);
	panel3.add(conicon);
	panel3.add(Email);
	panel3.add(save);
	panel3.add(Emaill);
	panel3.add(Address);
	panel3.add(Addressl);
	panel3.add(Number);
	panel3.add(Numberl);
	panel3.add(Name);
	panel3.add(vari);
	panel3.add(Namel);
	panel3.setBounds(320,55,310,300);
	panel3.setBorder(titledbi);
	frame.add(panel3);	
	frame.add(panel4);
	
	enter_con.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e)
    {
    	dlm.removeAllElements();
    	String text=enter_con.getText();
       	  ArrayList<String> contacts=db.GetContacts(text);
    	  for(String i:contacts)
    	  {
    		  dlm.addElement(i);
    	  }
    }
	});
	final String savevar=list.getSelectedValue();
	list.addListSelectionListener(new ListSelectionListener()
	{
	public void valueChanged(ListSelectionEvent arg0) {
		ArrayList<String> values=db.GetValues(list.getSelectedValue());

		if(list.getSelectedValue()!=null)
		{
			vari.setText(list.getSelectedValue());
		Name.setText(values.get(0));
		Number.setText(values.get(1));
		Address.setText(values.get(2));
		save.setVisible(false);
		cancel.setVisible(false);
		Email.setText(values.get(3));
		Address.setEditable(false);
		Name.setEditable(false);
		Email.setEditable(false);
		Number.setEditable(false);}
		}
	});

ActionListener editing=new ActionListener()
{
	public void actionPerformed(ActionEvent arg0) {
		save.setVisible(true);
		cancel.setVisible(true);
		Address.setEditable(true);
		Name.setEditable(true);
		Email.setEditable(true);
		Number.setEditable(true);
	}
};
edit.addActionListener(editing);

ActionListener cancelling=new ActionListener()
{
	public void actionPerformed(ActionEvent arg0) {
		if(Name.getText().equals(""))
		{
			Address.setEditable(false);
			Name.setEditable(false);
			Email.setEditable(false);
			Number.setEditable(false);
		}
		else{
		ArrayList<String> values=db.GetValues(vari.getText());
		Name.setText(values.get(0));
		Number.setText(values.get(1));
		Address.setText(values.get(2));
		save.setVisible(false);
		cancel.setVisible(false);
		Email.setText(values.get(3));
		Address.setEditable(false);
		Name.setEditable(false);
		Email.setEditable(false);
		Number.setEditable(false);
		}	}
};
cancel.addActionListener(cancelling);


ActionListener saver=new ActionListener()
{
	public void actionPerformed(ActionEvent ae)
	{
		
		while(Name.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Something in The TEXT BOX");	
			Name.setText(vari.getText());
			break;
		}
		ArrayList<String> savinglist=new ArrayList<String>();
		savinglist.add(vari.getText());
		savinglist.add(Name.getText());
		savinglist.add(Number.getText());
		savinglist.add(Address.getText());
		savinglist.add(Email.getText());

	db.SavingEdits(savinglist);
	vari.setText(Name.getText());
	dlm.removeAllElements();
	db.CDatabase();
 	  ArrayList<String> contacts=db.GetContacts();
	  for(String i:contacts)
	  {
		  dlm.addElement(i);
	  }
	if(Name.getText().equals(""))
	{
		Address.setEditable(false);
		Name.setEditable(false);
		Email.setEditable(false);
		Number.setEditable(false);
	}
	else{
	ArrayList<String> values=db.GetValues(vari.getText());
	Name.setText(values.get(0));
	Number.setText(values.get(1));
	Address.setText(values.get(2));
	save.setVisible(false);
	cancel.setVisible(false);
	Email.setText(values.get(3));
	Address.setEditable(false);
	Name.setEditable(false);
	Email.setEditable(false);
	Number.setEditable(false);
	}	
	}
};
save.addActionListener(saver);
	}
public void exte()
{
	panel3.setVisible(false);
	GUI graphics =new GUI();
	list.setFocusable(false);
	enter_con.setEditable(false);
	panel5=graphics.getAddPanel();
	frame.add(panel5);
}

public void extecancel() {
	panel5.setVisible(false);
	panel3.setVisible(true);
	enter_con.setEditable(true);
	list.setFocusable(true);
	dlm.removeAllElements();
	String text=enter_con.getText();
	Database db=new Database();
   	  ArrayList<String> contacts=db.GetContacts(text);
	  for(String i:contacts)
	  {
		  dlm.addElement(i);
	  }
	  db.CDatabase();
}
}
