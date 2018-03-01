import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Buttons {
	public ImageIcon saveico=new ImageIcon("images/save.jpg");
	public ImageIcon editico=new ImageIcon("images/edit.jpg");
	public ImageIcon cancelico=new ImageIcon("images/cancel.jpg");
	public ImageIcon saveico2=new ImageIcon("images/save2.jpg");
	public ImageIcon editico2=new ImageIcon("images/edit2.jpg");
	public ImageIcon cancelico2=new ImageIcon("images/cancel2.jpg");
	public ImageIcon saveico3=new ImageIcon("images/save3.jpg");
	public ImageIcon editico3=new ImageIcon("images/edit3.jpg");
	public ImageIcon cancelico3=new ImageIcon("images/cancel3.jpg");
	public ImageIcon setico=new ImageIcon("images/settings.jpg");
	public ImageIcon setico2=new ImageIcon("images/settings3.jpg");
	public ImageIcon setico3=new ImageIcon("images/settings2.jpg");
	public ImageIcon addico=new ImageIcon("images/add.jpg");
	public ImageIcon addico2=new ImageIcon("images/add2.jpg");
	public ImageIcon addico3=new ImageIcon("images/add3.jpg");
	
	public Buttons()
	{
		
	}
	public JButton GetSave()
	{
		JButton save=new JButton();
		save.setBorderPainted(false);
		save.setBorder(null);
		save.setOpaque(false);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.setFocusPainted(false);
		save.setMargin(new Insets(0, 0, 0, 0));
		save.setContentAreaFilled(false);
		save.setIcon(saveico);
		save.setRolloverIcon(saveico3);
		save.setPressedIcon(saveico2);
		save.setDisabledIcon(saveico);
		return save;
	}
	
	public JButton GetEdit()
	{
		JButton Edit=new JButton();
		Edit.setBorderPainted(false);
		Edit.setBorder(null);
		Edit.setMargin(new Insets(0, 0, 0, 0));
		Edit.setContentAreaFilled(false);
		Edit.setIcon(editico);
		Edit.setBorderPainted(false);
		Edit.setFocusPainted(false);
		Edit.setMargin(new Insets(0, 0, 0, 0));
		Edit.setContentAreaFilled(false);
		Edit.setRolloverIcon(editico3);
		Edit.setPressedIcon(editico2);
		Edit.setDisabledIcon(editico);
		return Edit;
	}
	
	public JButton GetCancel()
	{
		JButton cancel=new JButton();
		cancel.setBorderPainted(false);
		cancel.setBorder(null);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setContentAreaFilled(false);
		cancel.setIcon(cancelico);
		cancel.setRolloverIcon(cancelico3);
		cancel.setPressedIcon(cancelico2);
		cancel.setDisabledIcon(cancelico);
		cancel.setBorderPainted(false);
		 cancel.setFocusPainted(false);
		cancel.setMargin(new Insets(0, 0, 0, 0));
		cancel.setContentAreaFilled(false);
		return cancel;
	}
	public JButton getSettings() {
		
		JButton set=new JButton();
		set.setBorderPainted(false);
		set.setBorder(null);
		set.setMargin(new Insets(0, 0, 0, 0));
		set.setContentAreaFilled(false);
		set.setIcon(setico);
		set.setRolloverIcon(setico3);
		set.setPressedIcon(setico2);
		set.setDisabledIcon(setico);
		set.setBorderPainted(false);
		set.setFocusPainted(false);
		set.setMargin(new Insets(0, 0, 0, 0));
		set.setContentAreaFilled(false);
		return set;
	}
	
	public JButton Addnew()
	{
		JButton add=new JButton();
		add.setBorderPainted(false);
		add.setBorder(null);
		add.setOpaque(false);
		add.setContentAreaFilled(false);
		add.setBorderPainted(false);
		add.setFocusPainted(false);
		add.setMargin(new Insets(0, 0, 0, 0));
		add.setContentAreaFilled(false);
		add.setIcon(addico);
		add.setRolloverIcon(addico2);
		add.setPressedIcon(addico3);
		add.setDisabledIcon(addico);
		return add;
		
	}
	
}
