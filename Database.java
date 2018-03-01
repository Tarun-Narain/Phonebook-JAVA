import java.util.ArrayList;
import java.sql.*;


public class Database {
	public ArrayList<String> contacts=new ArrayList<String>();
	public Database()
	{	//Databse initialisation
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from PhoneBook");
			while(rs.next())
			{
					contacts.add(rs.getString(1));	
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
	}
	public void AddDatabase(ArrayList<String> info)
	{
		//System.out.println("here");
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");  
			  
			PreparedStatement stmt=con.prepareStatement("insert into Phonebook values(?,?, ?, ?)");  
			int l=1;
			for(String i:info)
			{
				stmt.setString(l, info.get(l-1));
				System.out.println(i);
				l++;
			}
			stmt.executeUpdate();  
						  
			con.close();  
			  
			}catch(Exception e)
			{ System.out.println(e);}  

	}
	public void CDatabase()
	{//Database initialisation on call;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from PhoneBook");
			contacts.clear();
			while(rs.next())
			{
					contacts.add(rs.getString(1));	
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
	}
	public ArrayList<String> GetContacts(String sub)
	{
		ArrayList<String> contacts1=new ArrayList<String>();
		for(String x:contacts)
		{
			if(x.toLowerCase().contains(sub.toLowerCase()))
			{
				contacts1.add(x);
			}
		}
		return contacts1;
	}
	public ArrayList<String> GetContacts()
	{
		ArrayList<String> contacts1=new ArrayList<String>();
		for(String x:contacts)
		{
				contacts1.add(x);	
		}
		return contacts1;
	}
	
	public ArrayList<String> GetValues(String Name)
	{
		ArrayList<String> values=new ArrayList<String>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from PhoneBook");
			while(rs.next())
			{
					if(rs.getString(1).equals(Name))
					{
						values.add(Name);
						values.add(rs.getString(2));
						values.add(rs.getString(3));
						values.add(rs.getString(4));
						break;
					}
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
		return values;
	}
	public void SavingEdits(ArrayList<String> info )
	{
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			Statement stmt=con.createStatement();
			stmt.executeQuery("update PhoneBook" + " SET Name = '"+info.get(1)+"' "+" WHERE Name= '"+info.get(0)+"'");
			stmt.executeQuery("update PhoneBook" + " SET Phoneno = '"+info.get(2)+"' "+" WHERE Name= '"+info.get(0)+"'");
			stmt.executeQuery("update PhoneBook" + " SET Address = '"+info.get(3)+"' "+" WHERE Name= '"+info.get(0)+"'");
			stmt.executeQuery("update PhoneBook" + " SET Email = '"+info.get(4)+"' "+" WHERE Name= '"+info.get(0)+"'");
			
			}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
	}
}
