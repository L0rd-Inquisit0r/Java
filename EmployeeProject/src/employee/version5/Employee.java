package employee.version5;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Employee {
	private int empID;
    private Name empName;
    private LocalDate empDateHired;
    private LocalDate empBirthDate;
    
	public Employee(int empID, Name empName, LocalDate empDateHired, LocalDate empBirthDate) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.empDateHired = empDateHired;
		this.empBirthDate = empBirthDate;
	}
	
	public Employee(LocalDate empDateHired, LocalDate empBirthDate) {
		super();
		this.empDateHired = empDateHired;
		this.empBirthDate = empBirthDate;
	}

	public Employee(Name empName) {
		super();
		this.empName = empName;
	}

	public Employee(int empID) {
		super();
		this.empID = empID;
	}

	public Employee() {
		super();
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public Name getEmpName() {
		return empName;
	}

	public void setEmpName(Name empName) {
		this.empName = empName;
	}

	public LocalDate getEmpDateHired() {
		return empDateHired;
	}

	public void setEmpDateHired(LocalDate empDateHired) {
		this.empDateHired = empDateHired;
	}

	public LocalDate getEmpBirthDate() {
		return empBirthDate;
	}

	public void setEmpBirthDate(LocalDate empBirthDate) {
		this.empBirthDate = empBirthDate;
	}

	public void displayInfo(){
        String info=toString();
        
        System.out.println(info);
    }
    
    @Override
    public String toString(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateHired=this.empDateHired.format(dateFormat);
        String dateBirth=this.empBirthDate.format(dateFormat);
        
        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\n",
                this.empID,this.empName,dateHired,dateBirth);
        
        return info;
    }
}
