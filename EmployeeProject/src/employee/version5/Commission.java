package employee.version5;

import java.time.format.*;
import java.time.LocalDate;

public class Commission extends Employee{
	private double totalSales;

	public Commission(int empID, Name empName, LocalDate empDateHired, LocalDate empBirthDate, double totalSales) {
		super(empID, empName, empDateHired, empBirthDate);
		this.totalSales = totalSales;
	}

	public Commission(int empID, Name empName, LocalDate empDateHired, LocalDate empBirthDate) {
		super(empID, empName, empDateHired, empBirthDate);
	}

	public Commission(double totalSales) {
		super();
		this.totalSales = totalSales;
	}

	public Commission() {
		super();
	}

	public double getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(double totalSales) {
		this.totalSales = totalSales;
	}
	
	public double computeSalary(){
        double salary=0;
        double sales=this.totalSales;
        
        if(sales<50000){
            salary=sales*.05;
        }
        if(sales>=50000&&sales<100000){
            salary=sales*.20;
        }
        if(sales>=100000&&sales<500000){
            salary=sales*.30;
        }
        if(sales>=500000){
            salary=sales*.50;
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
        
        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\nTotal Sales: %.2f",
                super.getEmpID(),super.getEmpName().toString(),dateHired,dateBirth,this.totalSales);

        return info;
    }
}
