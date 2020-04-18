package service;

import java.io.IOException;
import java.util.List;

import model.Result;

public interface ResultDAOInterface {

	// COLLEGE_DB_1
	void insert_result(Result result) throws IOException, ClassNotFoundException, Exception;
	boolean delete_result(String reg_no) throws IOException, ClassNotFoundException, Exception;
	boolean update_result(Result result) throws IOException, ClassNotFoundException, Exception;
	Result select_result(String reg_no) throws IOException, ClassNotFoundException, Exception, NullPointerException;
	List<Result> selectallresults() throws ClassNotFoundException, Exception;
	
	// COLLEGE_DB_2
	void insert_result1(Result result1) throws ClassNotFoundException, Exception;
	boolean delete_result1(String reg_no) throws ClassNotFoundException, Exception;
	boolean update_result1(Result result) throws ClassNotFoundException, Exception;
	Result select_result1(String reg_no) throws ClassNotFoundException, Exception, NullPointerException;
	List<Result> selectallresults1() throws ClassNotFoundException, Exception;
	
	// COLLEGE_DB_3
	void insert_result2(Result result) throws ClassNotFoundException, Exception;
	boolean delete_result2(String reg_no) throws ClassNotFoundException, Exception;
	boolean update_result2(Result result) throws ClassNotFoundException, Exception;
	Result select_result2(String reg_no)throws ClassNotFoundException, Exception, NullPointerException;
	List<Result> selectallresults2() throws ClassNotFoundException, Exception;
}
