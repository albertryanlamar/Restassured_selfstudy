package day2;

public class pojo_postrequest {
	String _name;
	String job;
	
    //setting
	public void setJob(String job) {
	this.job = job;
    }	
	public pojo_postrequest setName(String name) {
		_name = name;
		return this;

	}
	//getting
	public String getJob() {
	return job;
	}
	public String getName() {
	return _name;
	}






}
