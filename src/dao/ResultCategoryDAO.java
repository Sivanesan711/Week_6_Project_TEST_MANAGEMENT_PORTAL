package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Result;
import utility.ConnectionManager;

public class ResultCategoryDAO {
	
//***********************************************COLLEGE-I*************************************************************************************//
		public List<Result> selectallresultstoppers() throws ClassNotFoundException, Exception {
		
				ResultDAO rsltdao = new ResultDAO();
		
				List<Result> rslt = new ArrayList<Result>();
				Result result = null;
		
				ConnectionManager cm = new ConnectionManager();
				Connection con = cm.getConnection();
		
				String sql = "SELECT * FROM COLLEGE_DB_1 WHERE OVERALL_RESULT >=85 AND OVERALL_RESULT <=100 ORDER BY REG_NO";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
	    
				System.out.println();
				System.out.println("                    **************** TOPPERS LIST *******************");
				System.out.println();
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
		
		public List<Result> selectallresultsAboveaverage() throws ClassNotFoundException, Exception {
			
			ResultDAO rsltdao = new ResultDAO();
	
			List<Result> rslt = new ArrayList<Result>();
			Result result = null;
	
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
	
			String sql = "SELECT * FROM COLLEGE_DB_1 WHERE OVERALL_RESULT >=70 AND OVERALL_RESULT <=84 ORDER BY REG_NO";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
    
			System.out.println();
			System.out.println("                       **************** ABOVE AVERAGE *******************");
			System.out.println();
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
		
public List<Result> selectallresultsAverage() throws ClassNotFoundException, Exception {
			
			ResultDAO rsltdao = new ResultDAO();
	
			List<Result> rslt = new ArrayList<Result>();
			Result result = null;
	
			ConnectionManager cm = new ConnectionManager();
			Connection con = cm.getConnection();
	
			String sql = "SELECT * FROM COLLEGE_DB_1 WHERE OVERALL_RESULT >=50 AND OVERALL_RESULT <=69 ORDER BY REG_NO";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
    
			System.out.println();
			System.out.println("                    **************** AVERAGE *******************");
			System.out.println();
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


public List<Result> selectallresultsBelowaverage() throws ClassNotFoundException, Exception {
	
	ResultDAO rsltdao = new ResultDAO();

	List<Result> rslt = new ArrayList<Result>();
	Result result = null;

	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();

	String sql = "SELECT * FROM COLLEGE_DB_1 WHERE OVERALL_RESULT <=45  ORDER BY REG_NO";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	System.out.println();
	System.out.println("                          **************** BELOW AVERAGE *******************");
	System.out.println();
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
//*************************************************COLLEGE-I END*****************************************************************************************************************************************************//




//*********************************************COLLEGE-II START***************************************************************************************************************************************************//

public List<Result> selectallresultstoppersCollege2() throws ClassNotFoundException, Exception {
	
	ResultDAO rsltdao = new ResultDAO();

	List<Result> rslt = new ArrayList<Result>();
	Result result = null;

	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();

	String sql = "SELECT * FROM COLLEGE_DB_2 WHERE OVERALL_RESULT >=85 AND OVERALL_RESULT <=100 ORDER BY REG_NO";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	System.out.println();
	System.out.println("                    **************** TOPPERS LIST *******************");
	System.out.println();
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

public List<Result> selectallresultsAboveaverageclg2() throws ClassNotFoundException, Exception {

ResultDAO rsltdao = new ResultDAO();

List<Result> rslt = new ArrayList<Result>();
Result result = null;

ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();

String sql = "SELECT * FROM COLLEGE_DB_2 WHERE OVERALL_RESULT >=70 AND OVERALL_RESULT <=84 ORDER BY REG_NO";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

System.out.println();
System.out.println("                       **************** ABOVE AVERAGE *******************");
System.out.println();
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

public List<Result> selectallresultsAverageclg2() throws ClassNotFoundException, Exception {

ResultDAO rsltdao = new ResultDAO();

List<Result> rslt = new ArrayList<Result>();
Result result = null;

ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();

String sql = "SELECT * FROM COLLEGE_DB_2 WHERE OVERALL_RESULT >=50 AND OVERALL_RESULT <=69 ORDER BY REG_NO";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

System.out.println();
System.out.println("                    **************** AVERAGE *******************");
System.out.println();
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


public List<Result> selectallresultsBelowaverageclg2() throws ClassNotFoundException, Exception {

ResultDAO rsltdao = new ResultDAO();

List<Result> rslt = new ArrayList<Result>();
Result result = null;

ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();

String sql = "SELECT * FROM COLLEGE_DB_2 WHERE OVERALL_RESULT <=45  ORDER BY REG_NO";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

System.out.println();
System.out.println("                          **************** BELOW AVERAGE *******************");
System.out.println();
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

//*************************************************COLLEGE-II END******************************************************************************************************************************************************************************//

//*************************************************COLLEGE-III START**************************************************************************************************************************************************************************//

public List<Result> selectallresultstoppersCollege3() throws ClassNotFoundException, Exception {
	
	ResultDAO rsltdao = new ResultDAO();

	List<Result> rslt = new ArrayList<Result>();
	Result result = null;

	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();

	String sql = "SELECT * FROM COLLEGE_DB_3 WHERE OVERALL_RESULT >=85 AND OVERALL_RESULT <=100 ORDER BY REG_NO";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	System.out.println();
	System.out.println("                    **************** TOPPERS LIST *******************");
	System.out.println();
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

public List<Result> selectallresultsAboveaverageclg3() throws ClassNotFoundException, Exception {

ResultDAO rsltdao = new ResultDAO();

List<Result> rslt = new ArrayList<Result>();
Result result = null;

ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();

String sql = "SELECT * FROM COLLEGE_DB_3 WHERE OVERALL_RESULT >=70 AND OVERALL_RESULT <=84 ORDER BY REG_NO";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

System.out.println();
System.out.println("                       **************** ABOVE AVERAGE *******************");
System.out.println();
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

public List<Result> selectallresultsAverageclg3() throws ClassNotFoundException, Exception {

ResultDAO rsltdao = new ResultDAO();

List<Result> rslt = new ArrayList<Result>();
Result result = null;

ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();

String sql = "SELECT * FROM COLLEGE_DB_3 WHERE OVERALL_RESULT >=50 AND OVERALL_RESULT <=69 ORDER BY REG_NO";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

System.out.println();
System.out.println("                    **************** AVERAGE *******************");
System.out.println();
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


public List<Result> selectallresultsBelowaverageclg3() throws ClassNotFoundException, Exception {

ResultDAO rsltdao = new ResultDAO();

List<Result> rslt = new ArrayList<Result>();
Result result = null;

ConnectionManager cm = new ConnectionManager();
Connection con = cm.getConnection();

String sql = "SELECT * FROM COLLEGE_DB_3 WHERE OVERALL_RESULT <=45  ORDER BY REG_NO";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);

System.out.println();
System.out.println("                          **************** BELOW AVERAGE *******************");
System.out.println();
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

//************************************************COLLEGE-III END********************************************************************************************************************************************************************************//
}
