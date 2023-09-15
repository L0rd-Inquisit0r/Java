package employee.version1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommissionEmployee 
{
    private int empID;
    private String empName;
    private LocalDate empDateHired;
    private LocalDate empBirthDate;
    private double totalSales;

    public CommissionEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate, float totalSales) 
    {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalSales = totalSales;
    }

    public CommissionEmployee(int empID, String empName, float totalSales) 
    {
        this.empID = empID;
        this.empName = empName;
        this.totalSales = totalSales;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
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

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(float totalSales) {
        this.totalSales = totalSales;
    }
    
    public double computeSalary()
    {
        double salary=0;
        double sales=this.totalSales;
        
        if(sales<50000)
        {
            salary=sales*.05;
        }
        if(sales>=50000&&sales<100000)
        {
            salary=sales*.20;
        }
        if(sales>=100000&&sales<500000)
        {
            salary=sales*.30;
        }
        if(sales>=500000){
            salary=sales*.50;
        }
        
        return salary;
    }
    
    public void displayInfo()
    {
        String info=toString();
        
        System.out.println(info);
    }
    
    @Override
    public String toString()
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateHired=this.empDateHired.format(dateFormat);
        String dateBirth=this.empBirthDate.format(dateFormat);
        
        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\nTotal Sales: %.2f",
                this.empID,this.empName,dateHired,dateBirth,this.totalSales);

        
        return info;
    }
}
