import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Util 
{
		static Connection connection = null;
		public static Connection getConnection() 
		{
			try 
			{
				if(connection == null) 
				{
					System.out.println("in Connection try");
					Class.forName("org.postgresql.Driver"); 
					connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
						"postgres", "root");
					Statement stmt=connection.createStatement();  
					  
					//step4 execute query  
					ResultSet rs=stmt.executeQuery("select * from users");  
					while(rs.next())  
					System.out.println("Database done");	
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
				}
				return connection;
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			return connection;
		}
		public static void closeConnection(Connection connection) 
		{
			try 
			{
				if(connection!=null) 
				{
					try 
					{
						connection.close();
					} 
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			finally 
			{
				
			}
		}

}

	

