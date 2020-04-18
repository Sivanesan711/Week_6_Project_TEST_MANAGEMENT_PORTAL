package model;

public class Result {

	private String reg_no;
	private String batch;
	private int assesment1;
	private int assesment2;
	private int assesment3;
	private int overall_result;
	
	
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public int getAssesment1() {
		return assesment1;
	}
	public void setAssesment1(int assesment1) {
		this.assesment1 = assesment1;
	}
	public int getAssesment2() {
		return assesment2;
	}
	public void setAssesment2(int assesment2) {
		this.assesment2 = assesment2;
	}
	public int getAssesment3() {
		return assesment3;
	}
	public void setAssesment3(int assesment3) {
		this.assesment3 = assesment3;
	}
	public int getOverall_result() {
		return overall_result;
	}
	public void setOverall_result(int overall_result) {
		this.overall_result = overall_result;
	}
	
	
	public Result(String reg_no, String batch, int assesment1, int assesment2, int assesment3,
			int overall_result) {
		super();
		this.reg_no = reg_no;
		this.batch = batch;
		this.assesment1 = assesment1;
		this.assesment2 = assesment2;
		this.assesment3 = assesment3;
		this.overall_result = overall_result;
	}
	
	
	
	
	
	
}
