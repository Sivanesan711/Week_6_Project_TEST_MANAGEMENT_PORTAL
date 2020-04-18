package service;

import java.io.IOException;
import java.util.List;

import model.Result;
import model.Staff;

public interface StaffDAOInterface {
	
	boolean stafflogin(Staff staff) throws IOException, ClassNotFoundException, Exception;
	

}
