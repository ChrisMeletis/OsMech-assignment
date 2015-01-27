package paradoxprograming.org;

import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class MainSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	//Call form to log on user
	LoginForm();	
		
	}
	
	//Function to be used by other classes to pass queries into database
	public static ArrayList<String> askDB(String query,int i,String field, String Surename,String Dest_Address, String Pack_Status,String Position,String Courier)
	 {
	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs = null;
	  ArrayList<String> result = new ArrayList<String>();
	  try
	  {
	   Class.forName("com.mysql.jdbc.Driver").newInstance();
	   String connectionUrl = "jdbc:mysql://localhost:3306/mech";
	   String connectionUser = "root";
	   String connectionPassword="1234";
	   conn = DriverManager.getConnection(connectionUrl,connectionUser,connectionPassword);
	   stmt = conn.createStatement();
	   if (i == 1){
	    stmt.executeUpdate(query);
	   }else if (i == 2){
	    rs = stmt.executeQuery(query);
	    
	    while (rs.next())
	    {
	     result.add(rs.getString(field));
	    }
	   }else{
	    rs = stmt.executeQuery(query);
	    
	    while (rs.next())
	    {
	     
	     result.add(rs.getString(field));
	     result.add(rs.getString(Surename));
	     result.add(rs.getString(Dest_Address));
	     result.add(rs.getString(Pack_Status));
	     result.add(rs.getString(Position));
	     result.add(rs.getString(Courier));
	    }
	   }

	  }
	  catch (Exception e)
	  {
	   e.printStackTrace();
	  }
	  //System.out.println("name:" + result);
	  return result;
	  
	 }
	


	
	public static void LoginForm() {

			try {
				LoginForm window = new LoginForm();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void CallForm(String field){
		
	}

}
