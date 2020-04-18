 package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.AdminPortal;
import model.Admin;
import model.Staff;
import service.AdminDAOInterface;
import utility.ConnectionManager;

public class AdminDAO implements AdminDAOInterface {

	@Override
	public boolean Adminlogin(Admin admin) throws Exception, ClassNotFoundException, SQLException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("ENTER YOUR USERNAME:");
		String name = bf.readLine();
		System.out.println("ENTER YOUR PASSWORD:");
		String pass = bf.readLine();
		
		admin.setUsername(name);
		admin.setPassword(pass);
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "select * from admin_login where username = ? and password = ? ";
		
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, admin.getUsername());
		prestmt.setString(2, admin.getPassword());
		
		ResultSet rs = prestmt.executeQuery();
		
		while(rs.next())
		{
			if(name.equals(rs.getString("username")) && pass.equals(rs.getString("password")))
			{
				con.close();
				System.out.println();
				AdminPortal admprtl = new AdminPortal();
				admprtl.admin();
				return true;
			}
		}
		return true;
	}

	
	public int Addstaff(Staff staff) throws ClassNotFoundException, Exception, NullPointerException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("ENTER COLLEGE ID : ");
		String clgid = br.readLine();
		System.out.println("ENTER COLLEGE NAME : ");
		String clgnm = br.readLine();
		System.out.println("ENTER USERNAME : ");
		String usrnm = br.readLine();
		System.out.println("ENTER PASSWORD : ");
		String pswd = br.readLine();
		
	    staff.setCollege_id(clgid);
	    staff.setCollege_name(clgnm);
	    staff.setUsername(usrnm);
	    staff.setPassword(pswd);
		
	    ConnectionManager cm = new ConnectionManager();
	    Connection con = cm.getConnection();
	    
		String sql = "insert into staff_login values(?,?,?,?)";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, staff.getCollege_id());
		prestmt.setString(2, staff.getCollege_name());
		prestmt.setString(3, staff.getUsername());
		prestmt.setString(4, staff.getPassword());
	    ResultSet rs = prestmt.executeQuery();
	   
	    
	    if(rs!=null)
	    {
	    	con.close();
	    	System.out.println();
	    	System.out.println("STAFF MEMBER ADDED SUCCESSFULLY");
	    	System.out.println();
	    }
		return 0;
	}

}
