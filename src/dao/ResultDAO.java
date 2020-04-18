package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Result;
import service.ResultDAOInterface;
import utility.ConnectionManager;

public class ResultDAO implements ResultDAOInterface {

	// COLLEGE_DB_1
	
	@Override
	public void insert_result(Result result) throws ClassNotFoundException, Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("ENTER STUDENT REGISTERATION NUMBER : ");
		String regno = bf.readLine();
		System.out.print("ENTER BATCH NUMBER : ");
		String btch = bf.readLine();
		System.out.print("ENTER MARK ASSESSMENT-I : ");
		int ases1 = Integer.parseInt(bf.readLine());
		System.out.print("ENTER MARK ASSESSMENT-II : ");
		int ases2 = Integer.parseInt(bf.readLine());
		System.out.print("ENTER MARK ASSESSMENT-III : ");
		int ases3 = Integer.parseInt(bf.readLine());
		int rslt = ases1 + ases2 + ases3;
		int prctng = 3;
		int ovr_reslt = rslt/prctng;
		System.out.print("OVERALL RESULT IS : " + ovr_reslt+"%");
		System.out.println();
		
		result.setReg_no(regno);
		result.setBatch(btch);
		result.setAssesment1(ases1);
		result.setAssesment2(ases2);
		result.setAssesment3(ases3);
		result.setOverall_result(ovr_reslt);
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "INSERT INTO COLLEGE_DB_1 VALUES(?,?,?,?,?,?)";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, result.getReg_no());
		prestmt.setString(2, result.getBatch());
		prestmt.setInt(3, result.getAssesment1());
		prestmt.setInt(4, result.getAssesment2());
		prestmt.setInt(5, result.getAssesment3());
		prestmt.setInt(6, result.getOverall_result());
		ResultSet rs = prestmt.executeQuery();
		
		if(rs!=null)
		{
			con.close();
			System.out.println();
			System.out.println("STUDENT RECORD ADDED");
			System.out.println();
		}
		else
		{
			con.close();
			System.out.println("CHECK YOUR CONNECTION");
		}
	}

	@Override
	public Result select_result(String reg_no) throws ClassNotFoundException, Exception, NullPointerException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		Result result = null;
		result = new Result(null, null, 0, 0, 0, 0);
		System.out.println("ENTER REGISTER NO : ");
		String regno = bf.readLine();
		
		result.setReg_no(regno);
		
		String sql = "SELECT * FROM COLLEGE_DB_1 WHERE REG_NO = ?";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setString(1, regno);
		ResultSet rs = prstmt.executeQuery();
		
		while(rs.next())
		{
			if(rs!=null)
			{
			
			result.setReg_no(rs.getString("REG_NO"));
			result.setBatch(rs.getString("BATCH"));
			result.setAssesment1(rs.getInt("ASSESMENT_I"));
			result.setAssesment2(rs.getInt("ASSESMENT_II"));
			result.setAssesment3(rs.getInt("ASSESMENT_III"));
			result.setOverall_result(rs.getInt("OVERALL_RESULT"));
			
			System.out.println();
			System.out.println("REGISTERATION NUMBER : "+ rs.getString(1) + "\n " +"BATCH : "+ rs.getString(2) + "\n " +"ASSESSMENT-I : "+ rs.getInt(3) + "\n " +"ASSESSMENT-II : "+ rs.getInt(4) + "\n " +"ASSESSMENT-III : "+ rs.getInt(5) + "\n " +"OVERALL-RESULT : "+ rs.getInt(6)+"%");
			}
		}
		rs.close();
		prstmt.close();
		con.close();
		return result;
	}

	@Override
	public List<Result> selectallresults() throws ClassNotFoundException, Exception {
		
		ResultDAO rsltdao = new ResultDAO();
		
		List<Result> rslt = new ArrayList<Result>();
		Result result = null;
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "SELECT * FROM COLLEGE_DB_1";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    System.out.println("REGISTERATION NO " + " " + "BATCH  " + " " +  "ASSESSMENT-I  " + " " + "ASSESSMENT-II  " + " " + "ASSESSMENT-III  " + " " + "OVERALL_RESULT  "  );
	    
	    while(rs.next())
	    {
	    	result = new Result(null, null, 0, 0, 0, 0);
	    	
	    	System.out.print(rs.getString("REG_NO") + "         ");
	    	System.out.print(rs.getString("BATCH") + "     ");
	    	System.out.print("       "+rs.getInt("ASSESMENT_I") + "    ");
	    	System.out.print("       "+rs.getInt("ASSESMENT_II") + "    ");
	    	System.out.print("          "+rs.getInt("ASSESMENT_III") + "    ");
	    	System.out.println("          "+rs.getInt("OVERALL_RESULT")+"%");
	    	rslt.add(result);
	    }
	    rs.close();
	    stmt.close();
	    con.close();
		return rslt;
	}

	@Override
	public boolean delete_result(String reg_no) throws ClassNotFoundException, Exception {
		
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		Result result = null;
		result = new Result(null, null, 0, 0, 0, 0);
		
		System.out.println("ENTER REGISTERATION NUMBER: ");
		String regno = bfrd.readLine();
		result.setReg_no(regno);
		
		String sql = "DELETE FROM COLLEGE_DB_1 WHERE REG_NO = ? ";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, regno);
		ResultSet rs = prestmt.executeQuery();
		
		if(rs != null)
		{
			System.out.println();
			System.out.println("RECORD DELETED SUCCESSFULLY");
		}
		
		return false;
	}

	@Override
	public boolean update_result(Result result) throws ClassNotFoundException, Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "UPDATE COLLEGE_DB_1 SET ASSESMENT_I = ?, ASSESMENT_II = ?, ASSESMENT_III = ?, OVERALL_RESULT = ? WHERE REG_NO = ?";
		PreparedStatement prestmt = con.prepareStatement(sql);
		
		result = new Result(null, null, 0, 0, 0, 0);
		System.out.println("ENTER REGISTER NO : ");
		String regno1 = bf.readLine();
		result.setReg_no(regno1);
		prestmt.setString(5, regno1);
		
		System.out.println("ENTER MARK ASSESSMENT-I : ");
		int ases1 = Integer.parseInt(bf.readLine());
		prestmt.setInt(1, ases1);
		System.out.println("ENTER MARK ASSESSMENT-II : ");
		int ases2 = Integer.parseInt(bf.readLine());
		prestmt.setInt(2, ases2);
		System.out.println("ENTER MARK ASSESSMENT-III : ");
		int ases3 = Integer.parseInt(bf.readLine());
		prestmt.setInt(3, ases3);
		int rslt = ases1 + ases2 + ases3;
		int prctng = 3;
		int ovr_reslt = rslt/prctng;
		System.out.println("OVERALL RESULT IS : " + ovr_reslt);
		prestmt.setInt(4, ovr_reslt);
		System.out.println();
		prestmt.executeUpdate();
		con.commit();
	
	    	if(prestmt.executeUpdate()>0)
	    	{
	    		con.close();
	    		System.out.println("STUDENT RECORD UPDATED");
	    	}
	    prestmt.close();
	    con.close();
		return false;
	}

//---------------------------------------------------------------------------------------//
	
	// COLLEGE_DB_2
	
	@Override
	public void insert_result1(Result result) throws ClassNotFoundException, Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("ENTER STUDENT REGISTERATION NUMBER : ");
		String regno = bf.readLine();
		System.out.print("ENTER BATCH NUMBER : ");
		String btch = bf.readLine();
		System.out.print("ENTER MARK ASSESSMENT-I : ");
		int ases1 = Integer.parseInt(bf.readLine());
		System.out.print("ENTER MARK ASSESSMENT-II : ");
		int ases2 = Integer.parseInt(bf.readLine());
		System.out.print("ENTER MARK ASSESSMENT-III : ");
		int ases3 = Integer.parseInt(bf.readLine());
		int rslt = ases1 + ases2 + ases3;
		int prctng = 3;
		int ovr_reslt = rslt/prctng;
		System.out.print("OVERALL RESULT IS : " + ovr_reslt+"%");
		System.out.println();
		
		result.setReg_no(regno);
		result.setBatch(btch);
		result.setAssesment1(ases1);
		result.setAssesment2(ases2);
		result.setAssesment3(ases3);
		result.setOverall_result(ovr_reslt);
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "INSERT INTO COLLEGE_DB_2 VALUES(?,?,?,?,?,?)";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, result.getReg_no());
		prestmt.setString(2, result.getBatch());
		prestmt.setInt(3, result.getAssesment1());
		prestmt.setInt(4, result.getAssesment2());
		prestmt.setInt(5, result.getAssesment3());
		prestmt.setInt(6, result.getOverall_result());
		ResultSet rs = prestmt.executeQuery();
		
		if(rs!=null)
		{
			con.close();
			System.out.println();
			System.out.println("STUDENT RECORD ADDED");
			System.out.println();
		}
		else
		{
			con.close();
			System.out.println("CHECK YOUR CONNECTION");
		}
	}


	@Override
	public Result select_result1(String reg_no) throws ClassNotFoundException, Exception, NullPointerException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		Result result = null;
		result = new Result(null, null, 0, 0, 0, 0);
		System.out.println("ENTER REGISTER NO : ");
		String regno = bf.readLine();
		
		result.setReg_no(regno);
		
		String sql = "SELECT * FROM COLLEGE_DB_2 WHERE REG_NO = ?";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setString(1, regno);
		ResultSet rs = prstmt.executeQuery();
		
		while(rs.next())
		{
			if(rs!=null)
			{
			
			result.setReg_no(rs.getString("REG_NO"));
			result.setBatch(rs.getString("BATCH"));
			result.setAssesment1(rs.getInt("ASSESMENT_I"));
			result.setAssesment2(rs.getInt("ASSESMENT_II"));
			result.setAssesment3(rs.getInt("ASSESMENT_III"));
			result.setOverall_result(rs.getInt("OVERALL_RESULT"));
			
			System.out.println("REGISTERATION NUMBER : "+ rs.getString(1) + "\n " +"BATCH : "+ rs.getString(2) + "\n " +"ASSESSMENT-I : "+ rs.getInt(3) + "\n " +"ASSESSMENT-II : "+ rs.getInt(4) + "\n " +"ASSESSMENT-III : "+ rs.getInt(5) + "\n " +"OVERALL-RESULT : "+ rs.getInt(6)+"%");
			}
		}
		rs.close();
		prstmt.close();
		con.close();
		return result;
	}

	@Override
	public List<Result> selectallresults1() throws ClassNotFoundException, Exception {
		
		ResultDAO rsltdao = new ResultDAO();
		
		List<Result> rslt = new ArrayList<Result>();
		Result result = null;
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "SELECT * FROM COLLEGE_DB_2";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    System.out.println("REGISTERATION NO " + " " + "BATCH  " + " " +  "ASSESSMENT-I  " + " " + "ASSESSMENT-II  " + " " + "ASSESSMENT-III  " + " " + "OVERALL_RESULT  "  );

	    while(rs.next())
	    {
	    	result = new Result(null, null, 0, 0, 0, 0);
	    	
	    	System.out.print(rs.getString("REG_NO") + "         ");
	    	System.out.print(rs.getString("BATCH") + "     ");
	    	System.out.print("       "+rs.getInt("ASSESMENT_I") + "    ");
	    	System.out.print("       "+rs.getInt("ASSESMENT_II") + "    ");
	    	System.out.print("          "+rs.getInt("ASSESMENT_III") + "    ");
	    	System.out.println("          "+rs.getInt("OVERALL_RESULT")+"%");	    	
	    	rslt.add(result);
	    }
	    rs.close();
	    stmt.close();
	    con.close();
		return rslt;
	}

	@Override
		public boolean delete_result1(String reg_no) throws ClassNotFoundException, Exception {
		
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		Result result = null;
		result = new Result(null, null, 0, 0, 0, 0);
		
		System.out.println("ENTER REGISTERATION NUMBER: ");
		String regno = bfrd.readLine();
		result.setReg_no(regno);
		
		String sql = "DELETE FROM COLLEGE_DB_2 WHERE REG_NO = ? ";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, regno);
		ResultSet rs = prestmt.executeQuery();
		
		if(rs != null)
		{
			System.out.println();
			System.out.println("RECORD DELETED SUCCESSFULLY");
		}
		
		return false;
	}

	@Override
		public boolean update_result1(Result result) throws ClassNotFoundException, Exception {
		
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "UPDATE COLLEGE_DB_2 SET ASSESMENT_I = ?, ASSESMENT_II = ?, ASSESMENT_III = ?, OVERALL_RESULT = ? WHERE REG_NO = ?";
		PreparedStatement prestmt = con.prepareStatement(sql);
		
		result = new Result(null, null, 0, 0, 0, 0);
		System.out.println("ENTER REGISTER NO : ");
		String regno1 = bf.readLine();
		result.setReg_no(regno1);
		prestmt.setString(5, regno1);
		
		System.out.println("ENTER MARK ASSESSMENT-I : ");
		int ases1 = Integer.parseInt(bf.readLine());
		prestmt.setInt(1, ases1);
		System.out.println("ENTER MARK ASSESSMENT-II : ");
		int ases2 = Integer.parseInt(bf.readLine());
		prestmt.setInt(2, ases2);
		System.out.println("ENTER MARK ASSESSMENT-III : ");
		int ases3 = Integer.parseInt(bf.readLine());
		prestmt.setInt(3, ases3);
		int rslt = ases1 + ases2 + ases3;
		int prctng = 3;
		int ovr_reslt = rslt/prctng;
		System.out.println("OVERALL RESULT IS : " + ovr_reslt);
		prestmt.setInt(4, ovr_reslt);
		System.out.println();
		prestmt.executeUpdate();
		con.commit();
	
	    	if(prestmt.executeUpdate()>0)
	    	{
	    		con.close();
	    		System.out.println("STUDENT RECORD UPDATED");
	    	}
	    prestmt.close();
	    con.close();
		return false;
	}
	
//-----------------------------------------------------------------------------------------//

	// COLLEGE_DB_3
	
	@Override
public void insert_result2(Result result) throws ClassNotFoundException, Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("ENTER STUDENT REGISTERATION NUMBER : ");
		String regno = bf.readLine();
		System.out.print("ENTER BATCH NUMBER : ");
		String btch = bf.readLine();
		System.out.print("ENTER MARK ASSESSMENT-I : ");
		int ases1 = Integer.parseInt(bf.readLine());
		System.out.print("ENTER MARK ASSESSMENT-II : ");
		int ases2 = Integer.parseInt(bf.readLine());
		System.out.print("ENTER MARK ASSESSMENT-III : ");
		int ases3 = Integer.parseInt(bf.readLine());
		int rslt = ases1 + ases2 + ases3;
		int prctng = 3;
		int ovr_reslt = rslt/prctng;
		System.out.print("OVERALL RESULT IS : " + ovr_reslt+"%");
		System.out.println();
		
		result.setReg_no(regno);
		result.setBatch(btch);
		result.setAssesment1(ases1);
		result.setAssesment2(ases2);
		result.setAssesment3(ases3);
		result.setOverall_result(ovr_reslt);
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "INSERT INTO COLLEGE_DB_3 VALUES(?,?,?,?,?,?)";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, result.getReg_no());
		prestmt.setString(2, result.getBatch());
		prestmt.setInt(3, result.getAssesment1());
		prestmt.setInt(4, result.getAssesment2());
		prestmt.setInt(5, result.getAssesment3());
		prestmt.setInt(6, result.getOverall_result());
		ResultSet rs = prestmt.executeQuery();
		
		if(rs!=null)
		{
			con.close();
			System.out.println();
			System.out.println("STUDENT RECORD ADDED");
			System.out.println();
		}
		else
		{
			con.close();
			System.out.println("CHECK YOUR CONNECTION");
		}
	}


	@Override
	public Result select_result2(String reg_no) throws ClassNotFoundException, Exception, NullPointerException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		Result result = null;
		result = new Result(null, null, 0, 0, 0, 0);
		System.out.println("ENTER REGISTER NO : ");
		String regno = bf.readLine();
		
		result.setReg_no(regno);
		
		String sql = "SELECT * FROM COLLEGE_DB_3 WHERE REG_NO = ?";
		PreparedStatement prstmt = con.prepareStatement(sql);
		prstmt.setString(1, regno);
		ResultSet rs = prstmt.executeQuery();
		
		while(rs.next())
		{
			if(rs!=null)
			{
			
			result.setReg_no(rs.getString("REG_NO"));
			result.setBatch(rs.getString("BATCH"));
			result.setAssesment1(rs.getInt("ASSESMENT_I"));
			result.setAssesment2(rs.getInt("ASSESMENT_II"));
			result.setAssesment3(rs.getInt("ASSESMENT_III"));
			result.setOverall_result(rs.getInt("OVERALL_RESULT"));
			
			System.out.println("REGISTERATION NUMBER : "+ rs.getString(1) + "\n " +"BATCH : "+ rs.getString(2) + "\n " +"ASSESSMENT-I : "+ rs.getInt(3) + "\n " +"ASSESSMENT-II : "+ rs.getInt(4) + "\n " +"ASSESSMENT-III : "+ rs.getInt(5) + "\n " +"OVERALL-RESULT : "+ rs.getInt(6)+"%");
			}
		}
		rs.close();
		prstmt.close();
		con.close();
		return result;
	}

	@Override
	public List<Result> selectallresults2() throws ClassNotFoundException, Exception {
		
		ResultDAO rsltdao = new ResultDAO();
		
		List<Result> rslt = new ArrayList<Result>();
		Result result = null;
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "SELECT * FROM COLLEGE_DB_3";
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    
	    System.out.println("REGISTERATION NO " + " " + "BATCH  " + " " +  "ASSESSMENT-I  " + " " + "ASSESSMENT-II  " + " " + "ASSESSMENT-III  " + " " + "OVERALL_RESULT  "  );
	    
	    while(rs.next())
	    {
	    	result = new Result(null, null, 0, 0, 0, 0);
	    	
	    	System.out.print(rs.getString("REG_NO") + "         ");
	    	System.out.print(rs.getString("BATCH") + "     ");
	    	System.out.print("       "+rs.getInt("ASSESMENT_I") + "    ");
	    	System.out.print("       "+rs.getInt("ASSESMENT_II") + "    ");
	    	System.out.print("          "+rs.getInt("ASSESMENT_III") + "    ");
	    	System.out.println("          "+rs.getInt("OVERALL_RESULT")+"%");	    	
	    	rslt.add(result);
	    }
	    rs.close();
	    stmt.close();
	    con.close();
		return rslt;
	}

	@Override
		public boolean delete_result2(String reg_no) throws ClassNotFoundException, Exception {
		
		BufferedReader bfrd = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		Result result = null;
		result = new Result(null, null, 0, 0, 0, 0);
		
		System.out.println("ENTER REGISTERATION NUMBER: ");
		String regno = bfrd.readLine();
		result.setReg_no(regno);
		
		String sql = "DELETE FROM COLLEGE_DB_3 WHERE REG_NO = ? ";
		PreparedStatement prestmt = con.prepareStatement(sql);
		prestmt.setString(1, regno);
		ResultSet rs = prestmt.executeQuery();
		
		if(rs != null)
		{
			System.out.println();
			System.out.println("RECORD DELETED SUCCESSFULLY");
		}
		
		return false;
	}

	@Override
		public boolean update_result2(Result result) throws ClassNotFoundException, Exception {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();
		
		String sql = "UPDATE COLLEGE_DB_3 SET ASSESMENT_I = ?, ASSESMENT_II = ?, ASSESMENT_III = ?, OVERALL_RESULT = ? WHERE REG_NO = ?";
		PreparedStatement prestmt = con.prepareStatement(sql);
		
		result = new Result(null, null, 0, 0, 0, 0);
		System.out.println("ENTER REGISTER NO : ");
		String regno1 = bf.readLine();
		result.setReg_no(regno1);
		prestmt.setString(5, regno1);
		
		System.out.println("ENTER MARK ASSESSMENT-I : ");
		int ases1 = Integer.parseInt(bf.readLine());
		prestmt.setInt(1, ases1);
		System.out.println("ENTER MARK ASSESSMENT-II : ");
		int ases2 = Integer.parseInt(bf.readLine());
		prestmt.setInt(2, ases2);
		System.out.println("ENTER MARK ASSESSMENT-III : ");
		int ases3 = Integer.parseInt(bf.readLine());
		prestmt.setInt(3, ases3);
		int rslt = ases1 + ases2 + ases3;
		int prctng = 3;
		int ovr_reslt = rslt/prctng;
		System.out.println("OVERALL RESULT IS : " + ovr_reslt);
		prestmt.setInt(4, ovr_reslt);
		System.out.println();
		prestmt.executeUpdate();
		con.commit();
	
	    	if(prestmt.executeUpdate()>0)
	    	{
	    		con.close();
	    		System.out.println("STUDENT RECORD UPDATED");
	    	}
	    prestmt.close();
	    con.close();
		return false;
	}
}
