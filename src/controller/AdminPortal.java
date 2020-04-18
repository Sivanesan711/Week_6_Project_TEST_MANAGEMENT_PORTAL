package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.AdminDAO;
import dao.ResultCategoryDAO;
import dao.ResultDAO;
import model.Admin;
import model.Result;
import model.Staff;

public class AdminPortal {
	
	public void admin() throws ClassNotFoundException, Exception
	{
		System.out.println();
		System.out.println("************* WELCOME TO ADMIN PORTAL ***************");
		System.out.println("               1. MODIFY RESULT                      ");
		System.out.println("               2. VIEW ALL RESULT                    ");
		System.out.println("               3. ADD STAFF MEMBER                   ");
		System.out.println();
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a=0;
		a = Integer.parseInt(bf.readLine());
	
		switch(a)
		{
		case 1:
			
			System.out.println();
			System.out.println("*********** SELECT COLLEGE ***********");
			System.out.println("             1. COLLEGE - 1           ");
			System.out.println("             2. COLLEGE - 2           ");
			System.out.println("             3. COLLEGE - 3           ");
			System.out.println();
			
			int i = 0;
			i = Integer.parseInt(bf.readLine());
			
			if(i==1)
			{
				
				ResultDAO rsltdao = new ResultDAO();
				Result rslt = new Result(null, null, i, i, i, i);
				
				System.out.println();
				System.out.println("************ SELECT YOU WANT TO MODIFY ***************");
				System.out.println("             1. INSERT RECORD                         ");
				System.out.println("             2. DELETE RECORD                         ");
				System.out.println("             3. MODIFY RECORD                         ");
				System.out.println();
				
				int choice = 0;
				choice = Integer.parseInt(bf.readLine());
				
				switch(choice)
				{
				case 1:
					
					System.out.println();
					rsltdao.insert_result(rslt);
					System.out.println();
					String ys = "YES";
					String no = "NO";
					System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
					String ysno = bf.readLine();
					if(ys.equals(ysno))
					{
						for(i=1;i<=10;i++)
						{
							rsltdao.insert_result(rslt);
						}
					}
					else
					{
						admin();
					}
					
					break;
				
				case 2:
					
					String reg_no = null;
					rsltdao.delete_result(reg_no);
					admin();
					break;
					
				case 3:
					
					System.out.println();
					rsltdao.update_result(rslt);
					System.out.println();
					String ys1 = "YES";
					String no1 = "NO";
					System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
					String ysno1 = bf.readLine();
					if(ys1.equals(ysno1))
					{
						for(i=1;i<=10;i++)
						{
							rsltdao.update_result(rslt);						}
						}
					else
					{
						admin();
					}
					break;
					
				default:
					
					System.out.println("INVALID KEY");
					break;
				}
			}
			else if(i==2)
			{
					ResultDAO rsltdao = new ResultDAO();
					Result rslt = new Result(null, null, i, i, i, i);
					
					System.out.println();
					System.out.println("************ SELECT YOU WANT TO MODIFY ***************");
					System.out.println("             1. INSERT RECORD                         ");
					System.out.println("             2. DELETE RECORD                         ");
					System.out.println("             3. MODIFY RECORD                         ");
					System.out.println();
					
					int choice = 0;
					choice = Integer.parseInt(bf.readLine());
					
					switch(choice)
					{
					case 1:
						
						System.out.println();
						rsltdao.insert_result1(rslt);
						System.out.println();
						String ys = "YES";
						String no = "NO";
						System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
						String ysno = bf.readLine();
						if(ys.equals(ysno))
						{
							for(i=1;i<=10;i++)
							{
								rsltdao.insert_result1(rslt);
							}
						}
						else
						{
							admin();
						}
						
						break;
						
					case 2:
						
						String reg_no = null;
						rsltdao.delete_result1(reg_no);
						admin();
						break;
						
					case 3:
						
						System.out.println();
						rsltdao.update_result1(rslt);
						System.out.println();
						String ys1 = "YES";
						String no1 = "NO";
						System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
						String ysno1 = bf.readLine();
						if(ys1.equals(ysno1))
						{
							for(i=1;i<=10;i++)
							{
								rsltdao.update_result1(rslt);						}
							}
						else
						{
							admin();
						}
						break;
						
					default:
						
						System.out.println("INVALID KEY");
						admin();
						break;
					}
			}
			else if(i==3)
			{
				
				ResultDAO rsltdao = new ResultDAO();
				Result rslt = new Result(null, null, i, i, i, i);
				
				System.out.println();
				System.out.println("************ SELECT YOU WANT TO MODIFY ***************");
				System.out.println("             1. INSERT RECORD                         ");
				System.out.println("             2. DELETE RECORD                         ");
				System.out.println("             3. MODIFY RECORD                         ");
				System.out.println();
				
				int choice = 0;
				choice = Integer.parseInt(bf.readLine());
				
				switch(choice)
				{
				case 1:
					
					System.out.println();
					rsltdao.insert_result2(rslt);
					System.out.println();
					String ys = "YES";
					String no = "NO";
					System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
					String ysno = bf.readLine();
					if(ys.equals(ysno))
					{
						for(i=1;i<=10;i++)
						{
							rsltdao.insert_result2(rslt);
						}
					}
					else
					{
						admin();
					}
					
					break;
					
				case 2:
					
					String reg_no = null;
					rsltdao.delete_result2(reg_no);
					admin();
					break;
					
				case 3:
					
					System.out.println();
					rsltdao.update_result2(rslt);
					System.out.println();
					String ys1 = "YES";
					String no1 = "NO";
					System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
					String ysno1 = bf.readLine();
					if(ys1.equals(ysno1))
					{
						for(i=1;i<=10;i++)
						{
							rsltdao.update_result2(rslt);						}
						}
					else
					{
						admin();
					}
					break;
					
				default:
					
					System.out.println("INVALID KEY");
					admin();
					break;
				}
			}
			else
			{
				System.out.println("INVALID KEY");
				admin();
			}
			break;

//-----------------------------------------CASE 1 PART-----------------------------------------------//
			
		case 2:
			
			ResultDAO rsltdao1 = new ResultDAO();
			Result rslt1 = new Result(null, null, 0, 0, 0, 0);
			
			System.out.println();
			System.out.println("*********** SELECT COLLEGE ***********");
			System.out.println("             1. COLLEGE - 1           ");
			System.out.println("             2. COLLEGE - 2           ");
			System.out.println("             3. COLLEGE - 3           ");
			System.out.println();
			
			int rslt = 0;
			rslt = Integer.parseInt(bf.readLine());
			
			switch(rslt)
			{
			case 1:
				
				rsltdao1.selectallresults();
				System.out.println();
				ResultCategoryDAO rcd = new ResultCategoryDAO();
				rcd.selectallresultstoppers();
				System.out.println();
				rcd.selectallresultsAboveaverage();
				System.out.println();
				rcd.selectallresultsAverage();
				System.out.println();
				rcd.selectallresultsBelowaverage();
				System.out.println();
				admin();
				break;
				
			case 2:
			
				rsltdao1.selectallresults1();
				System.out.println();
				ResultCategoryDAO rcd1 = new ResultCategoryDAO();
				rcd1.selectallresultstoppersCollege2();
				System.out.println();
				rcd1.selectallresultsAboveaverageclg2();
				System.out.println();
				rcd1.selectallresultsAverageclg2();
				System.out.println();
				rcd1.selectallresultsBelowaverageclg2();
				System.out.println();
				admin();
				break;
				
			case 3:
				
				rsltdao1.selectallresults2();
				System.out.println();
				ResultCategoryDAO rcd2 = new ResultCategoryDAO();
				rcd2.selectallresultstoppersCollege3();
				System.out.println();
				rcd2.selectallresultsAboveaverageclg3();
				System.out.println();
				rcd2.selectallresultsAverageclg3();
				System.out.println();
				rcd2.selectallresultsBelowaverageclg3();
				System.out.println();
				admin();
				break;
				
			default:
					
				System.out.println("INVALID KEY");
				admin();
				break;
				
			}
			break;
			
		case 3:
			
			
			Admin adm = new Admin(null, null, null, null);
			AdminDAO admdao = new AdminDAO();
			Staff staff = new Staff(null, null, null, null);
			admdao.Addstaff(staff);
			admin();
			break;
		}
		
	}

}
