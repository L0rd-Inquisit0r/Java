package employee.version6;

public class Name {
	private String fname;
	private String mmname;
	private String lname;
	
	public Name(String fname, String mmname, String lname) {
		super();
		this.fname = fname;
		this.mmname = mmname;
		this.lname = lname;
	}
	
	public Name() {
		super();
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMmname() {
		return mmname;
	}

	public void setMmname(String mmname) {
		this.mmname = mmname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s", this.fname,this.mmname,this.lname);
	}
}
