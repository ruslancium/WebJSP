package name.ruslan.dbservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import name.ruslan.model.User;


public class Service {
    private static Connection con;
    private static Service instance;
    private static DataSource dataSource;
 
    public static synchronized Service getInstance() {
        if (instance == null) {
            try {
                instance = new Service();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/rating");
                con = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    public String getPassword(String userName) {
    	 String result = "";
         
    	 PreparedStatement stmt;
		 try {
			 stmt = con.prepareStatement("SELECT phrase FROM auth WHERE name = ?");
	         stmt.setString(1, userName);
	         ResultSet rs = stmt.executeQuery();
	         
	         while (rs.next()) {
	             result = rs.getString(1);
	         }
	         
	         rs.close();
	         stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;    	
    }
    
    public List<User> getUsers() {
    	List<User> v = new ArrayList();

   	 PreparedStatement stmt;
		 try {
			 stmt = con.prepareStatement("SELECT name, phrase FROM auth;");        
	         
	         ResultSet rs = stmt.executeQuery();
	         
	         User user = new User();
	         while (rs.next()) {
	             user.setUserName(rs.getString(1));
	             user.setPassPhrase(rs.getString(1));
	             v.add(user);
	         }
	         
	         rs.close();
	         stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return v;
	}
}
