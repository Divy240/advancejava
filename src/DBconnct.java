import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class DBconnct {
	public static void main(String[]args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter the id and name");
		int id=scanner.nextInt();
		String name=scanner.next();
		
	 try {
	 	Class.forName("com.mysql.cj.jdbc.Driver");
	 		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/dbc","root","root");
	 		System.out.println("connection success");
	 		String query ="UPDATE `user` SET `name`='"+name+"' WHERE (`id` = '"+id+"')";//UPDATE QUERY
	 		String query1="insert into dbc.user values('"+id+"','"+name+"')";//CREATE/INSERT QUERY
	 	
	 		Statement statement=connection.createStatement();
	 		int i=0;
	 		i=statement.executeUpdate(query1);
	 		ResultSet set= statement.executeQuery("SELECT * FROM dbc.user");//Retrieve QUERY
			while(set.next())
			{
				System.out.println(set.getInt("id")+" "+set.getString("name"));
			}
 		
	 		if(i!=0) {
	 			System.out.println("database updated");
	 		}
	 		

	 		
	 		String query11="DELETE FROM `myde. `user` WHERE (`id` = '"+id+"')";//DELETE QUERY
	 		int n=0;
	 		n=statement.executeUpdate(query11);
	 		if(n!=0) {
	 			System.out.println("database created");
	 		}
	 		else {
	 			System.out.println("Try again");
	 		}
	} catch (Exception e) {
		
		System.out.println(e);
		
	
	}
	}
	}
