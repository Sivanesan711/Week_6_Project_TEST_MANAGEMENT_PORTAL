package service;

import java.io.IOException;

import model.Admin;
import model.Staff;

public interface AdminDAOInterface {

	
	boolean Adminlogin(Admin admin) throws Exception;
	int Addstaff(Staff staff) throws IOException, ClassNotFoundException, Exception, NullPointerException;
}
