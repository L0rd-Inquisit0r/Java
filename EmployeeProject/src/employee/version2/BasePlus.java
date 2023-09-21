package employee.version2;

import java.time.LocalDate;
import java.time.format.*;

public class BasePlus extends Commission{
	private double baseSalary;

	public BasePlus(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate, double totalSales,
			double baseSalary) {
		super(empID, empName, empDateHired, empBirthDate, totalSales);
		this.baseSalary = baseSalary;
	}

	public BasePlus(int empID, String empName, double totalSales, double baseSalary) {
		super(empID, empName, totalSales);
		this.baseSalary = baseSalary;
	}

	public BasePlus(double totalSales, double baseSalary) {
		super(totalSales);
		this.baseSalary = baseSalary;
	}

	public BasePlus(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate, double baseSalary) {
		super(empID, empName, empDateHired, empBirthDate);
		this.baseSalary = baseSalary;
	}

	public BasePlus(int empID, String empName, double baseSalary) {
		super(empID, empName);
		this.baseSalary = baseSalary;
	}

	public BasePlus(double baseSalary) {
		super();
		this.baseSalary = baseSalary;
	}

	public BasePlus() {
		super();
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	 public double computeSalary(){
	        double salary=this.baseSalary;
	        double sales=super.getTotalSales();
	        
	        if(sales<50000){
	            salary+=sales*.05;
	        }
	        if(sales>=50000&&sales<100000){
	            salary+=sales*.20;
	        }
	        if(sales>=100000&&sales<500000){
	            salary+=sales*.30;
	        }
	        if(sales>=500000){
	            salary+=sales*.50;
	        }
	        
	        return salary;
	    }
	 
	    public void displayInfo(){
	        String info=toString();
	        
	        System.out.println(info);
	    }
	    
	    @Override
	    public String toString(){
	        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String dateHired=super.getEmpDateHired().format(dateFormat);
	        String dateBirth=super.getEmpBirthDate().format(dateFormat);
	        
	        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\nTotal Sales: %.2f\nBase Salary: %.2f",
	                super.getEmpID(),super.getEmpName(),dateHired,dateBirth,super.getTotalSales(),this.baseSalary);
	        
	        return info;
	    }
}
