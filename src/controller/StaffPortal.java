package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.ResultDAO;
import dao.StaffDAO;
import model.Result;
import model.Staff;

public class StaffPortal {
	
	public void staff() throws ClassNotFoundException, Exception
	{
		System.out.println("************* WELCOME TO STAFF PORTAL **************");
		System.out.println("              1. ADD RESULT                         ");
		System.out.println("              2. VIEW RESULT                        ");
		System.out.println("              3. UPDATE RESULT                      ");
		System.out.println();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int a = 0;
		a = Integer.parseInt(bf.readLine());
		
		switch(a)
		{
		case 1:
			
			System.out.print("ENTER COLLEGE ID: ");
			String clg1 = "CLG1-001";
			String clg2 = "CLG2-002";
			String clg3 = "CLG3-003";
			String clg_id = bf.readLine();
			System.out.println();
			
			if(clg_id.equals(clg1))
			{
				System.out.println();
				ResultDAO rsltdao = new ResultDAO();
				Result rslt = new Result(null, null, 0, 0, 0, 0);
				
				rsltdao.insert_result(rslt);
				System.out.println();
				System.out.println(" DO YOU WANT TO ADD MORE RECORDS ENTER YES OR NO ?");
				String ys = "YES";
				String no = "NO";
				System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
				String ysno = bf.readLine();
				
				if(ys.equals(ysno))
				{
					System.out.println("SELECT YOUR RANGE OF INSERT RECORD");
					System.out.println("1. RANGE 1-10");
					System.out.println("2. RANGE 1-20");
					System.out.println("3. RANGE 1-30");
					System.out.println();
					
					int x=0;
					x=Integer.parseInt(bf.readLine());
					
					if(x==1)
					{
						for(int i=1;i<=10;i++)
						{
							rsltdao.insert_result(rslt);
						}
						staff();
					}
					else if(x==2)
					{
						for(int i=1;i<=20;i++)
						{
							rsltdao.insert_result(rslt);
						}
						staff();
					}
					else if(x==3)
					{
						for(int i=1;i<=30;i++)
						{
							rsltdao.insert_result(rslt);
						}
						staff();
					}
					
				else
				{
					System.out.println("INVALID ACCESS");
					System.out.println();
					System.out.println("PLEASE CONTACT ADMINISTRATOR");
				}
				}
				else
				{
					break;
				}
				staff();
			}
			else if(clg_id.equals(clg2))
			{
	
				System.out.println();
				ResultDAO rsltdao = new ResultDAO();
				Result rslt = new Result(null, null, 0, 0, 0, 0);
				
				rsltdao.insert_result1(rslt);
				System.out.println();
				System.out.println(" DO YOU WANT TO ADD MORE RECORDS ENTER YES OR NO ?");
				String ys = "YES";
				String no = "NO";
				System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
				String ysno = bf.readLine();
				
				if(ys.equals(ysno))
				{
					System.out.println("SELECT YOUR RANGE OF INSERT RECORD");
					System.out.println("1. RANGE 1-10");
					System.out.println("2. RANGE 1-20");
					System.out.println("3. RANGE 1-30");
					System.out.println();
				
					int x=0;
					x=Integer.parseInt(bf.readLine());
				
					if(x==1)
					{
						for(int i=1;i<=10;i++)
						{
							rsltdao.insert_result1(rslt);
						}
						staff();
					}
					else if(x==2)
					{
						for(int i=1;i<=20;i++)
						{
							rsltdao.insert_result1(rslt);
						}
						staff();
					}
					else if(x==3)
					{
						for(int i=1;i<=30;i++)
						{
							rsltdao.insert_result1(rslt);
						}
						staff();
					}
				
					else
					{
						System.out.println("INVALID ACCESS");
						System.out.println();
						System.out.println("PLEASE CONTACT ADMINISTRATOR");
					}
				}
				else
				{
					break;
				}
				staff(); 
			}
			else if(clg_id.equals(clg3))
			{
			
				System.out.println();
				ResultDAO rsltdao = new ResultDAO();
				Result rslt = new Result(null, null, 0, 0, 0, 0);
				
				rsltdao.insert_result2(rslt);
				System.out.println();
				System.out.println(" DO YOU WANT TO ADD MORE RECORDS ENTER YES OR NO ?");
				String ys = "YES";
				String no = "NO";
				System.out.println("DO YOU WANT TO ADD MORE RECORDS ENTER YES/NO ?");
				String ysno = bf.readLine();
				
				if(ys.equals(ysno))
				{
					System.out.println("SELECT YOUR RANGE OF INSERT RECORD");
					System.out.println("1. RANGE 1-10");
					System.out.println("2. RANGE 1-20");
					System.out.println("3. RANGE 1-30");
					System.out.println();
				
					int x=0;
					x=Integer.parseInt(bf.readLine());
				
					if(x==1)
					{
						for(int i=1;i<=10;i++)
						{
							rsltdao.insert_result2(rslt);
						}
						staff();
					}
					else if(x==2)
					{
						for(int i=1;i<=20;i++)
						{
							rsltdao.insert_result2(rslt);
						}
						staff();
					}
					else if(x==3)
					{
						for(int i=1;i<=30;i++)
						{
							rsltdao.insert_result2(rslt);
						}
						staff();
					}
				
					else
					{
						System.out.println("INVALID ACCESS");
						System.out.println();
						System.out.println("PLEASE CONTACT ADMINISTRATOR");
					}
				}
				else
				{
					break;
				}
				staff();
			}
			break;
			
//**********************************************************************************************************************//
			
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
			
				System.out.println();
				rsltdao1.selectallresults();
				System.out.println();
				staff();
				break;
				
			case 2:
			
				
				System.out.println();
				rsltdao1.selectallresults1();
				System.out.println();
				staff();
				break;
				
			case 3:
				

				System.out.println();
				rsltdao1.selectallresults2();
				System.out.println();
				staff();
				break;
				
			default:
					
				System.out.println("INVALID KEY");
				break;
				
			}
			break;
			
//***************************************************************************************************//
			
		case 3:
			
			ResultDAO rsltdao2 = new ResultDAO();
			Result rslt2 = new Result(null, null, 0, 0, 0, 0);
			
			System.out.println();
			System.out.println("*********** SELECT COLLEGE ***********");
			System.out.println("             1. COLLEGE - 1           ");
			System.out.println("             2. COLLEGE - 2           ");
			System.out.println("             3. COLLEGE - 3           ");
			System.out.println();
			
			int c = 0;
			c = Integer.parseInt(bf.readLine());
			
			switch(c)
			{
			case 1:
				
				rsltdao2.update_result(rslt2);
				System.out.println();
				staff();
				break;
				
			case 2:
				
				rsltdao2.update_result1(rslt2);
				System.out.println();
				staff();
				break;
				
			case 3:
				
				rsltdao2.update_result2(rslt2);
				System.out.println();
				staff();
				break;
			}
			
		}
		
	}

}
