package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import controller.StaffPortal;
import model.Result;
import model.Staff;
import service.StaffDAOInterface;
import utility.ConnectionManager;

public class StaffDAO implements StaffDAOInterface {


	@Override
	public boolean stafflogin(Staff staff) throws ClassNotFoundException, Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("ENTER USERNAME : ");
		String usrnm = bf.readLine();
		System.out.println("ENTER PASSWORD : ");
		String pass = bf.readLine();
		
		staff.setUsername(usrnm);
		staff.setPassword(pass);
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "SELECT * FROM STAFF_LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
		PreparedStatement prestmt = con.prepareStatement(sql);
		
		prestmt.setString(1, staff.getUsername());
		prestmt.setString(2, staff.getPassword());
		
		ResultSet rs = prestmt.executeQuery();
		
		if(rs.next())
		{
			if(usrnm.equals(rs.getString("username")) && pass.equals(rs.getString("password")))
			{
				System.out.println();
				StaffPortal stfprtl = new StaffPortal();
				stfprtl.staff();
			}
			else
			{
				System.out.println("INVALID USER PLEASE CONTACT ADMIN");
			}
		}
		
		return false;
	}


}
