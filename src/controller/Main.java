package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.AdminDAO;
import dao.ResultDAO;
import dao.StaffDAO;
import model.Admin;
import model.Result;
import model.Staff;

public class Main {

	public static void main(String[] args) throws Exception, ClassNotFoundException, SQLException, NullPointerException {
		
		Admin adm = new Admin(null, null, null, null);
		AdminDAO admdao = new AdminDAO();
		Staff stf = new Staff(null, null, null, null);
		StaffDAO stfdao = new StaffDAO();
		Result rslt = new Result(null, null, 0, 0, 0, 0);
		ResultDAO rsltdao = new ResultDAO();
		AdminPortal admprtl = new AdminPortal();
		StaffPortal stfprtl = new StaffPortal();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
	    System.out.println("*************** WELCOME TO TEST MANAGEMENT PORTAL ****************");
	    System.out.println("                1. ADMINISTRATOR                                  ");
	    System.out.println("                2. STAFF LOGIN                                    ");
	    System.out.println("                3. STUDENT RESULT                                 ");
	    
	    int i = 0;
	    i = Integer.parseInt(bf.readLine());
	    
	    switch(i)
	    {
	    case 1:
	    	
	    	admdao.Adminlogin(adm);
	    	break;
	    	
	    case 2:
	    	
	    	stfdao.stafflogin(stf);
	    	break;
	    	
	    case 3:
	    	
	    	System.out.print("ENTER YOUR COLLEGE NAME: ");
	    	String clg1 = "COLLEGE-I";
	    	String clg2 = "COLLEGE-II";
	    	String clg3 = "COLLEGE-III";
	    	String clg_rslt = bf.readLine();
	    	
	    	if(clg_rslt.equals(clg1))
	    	{
	    		String reg_no = null;
	    		rsltdao.select_result(reg_no);
	    		System.out.println();
	    		main(args);
	    	}
	    	else if(clg_rslt.equals(clg2))
	    	{
	    		String reg_no = null;
	    		rsltdao.select_result1(reg_no);
	    		System.out.println();
	    		main(args);
	    	}
	    	else if(clg_rslt.equals(clg3))
	    	{
	    		String reg_no = null;
	    		rsltdao.select_result2(reg_no);
	    		System.out.println();
	    		main(args);
	    	}
			break;
	    
		default:
			
			System.out.println("INVALID KEY");
			break;
	    
	    }
		

	}

}

