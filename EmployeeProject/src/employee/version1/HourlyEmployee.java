package employee.version1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourlyEmployee
{
    private int empID;
    private String empName;
    private LocalDate empDateHired;
    private LocalDate empBirthDate;
    private float totalHoursWorked;
    private float ratePerHour;

    public HourlyEmployee()
    {
    }

    public HourlyEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate, float totalHoursWorked, float ratePerHour) 
    {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public HourlyEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate) 
    {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
    }

    public int getEmpID() 
    {
        return empID;
    }

    public void setEmpID(int empID) 
    {
        this.empID = empID;
    }

    public String getEmpName() 
    {
        return empName;
    }

    public void setEmpName(String empName) 
    {
        this.empName = empName;
    }

    public LocalDate getEmpDateHired() 
    {
        return empDateHired;
    }

    public void setEmpDateHired(LocalDate empDateHired) 
    {
        this.empDateHired = empDateHired;
    }

    public LocalDate getEmpBirthDate() 
    {
        return empBirthDate;
    }

    public void setEmpBirthDate(LocalDate empBirthDate) 
    {
        this.empBirthDate = empBirthDate;
    }

    public float getTotalHoursWorked() 
    {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) 
    {
        this.totalHoursWorked = totalHoursWorked;
    }

    public float getRatePerHour() 
    {
        return ratePerHour;
    }

    public void setRatePerHour(float ratePerHour) 
    {
        this.ratePerHour = ratePerHour;
    }
    
    public double computeSalary()
    {
        double salary;
        int regWorkHours=40;
        float hoursWorked=this.totalHoursWorked;
        float rate=this.ratePerHour;
        float overtimeHours=0;
        float overtimeRate=this.ratePerHour*1.5f;
        float bonus=0;
        if(hoursWorked>40)
        {
            overtimeHours=hoursWorked-regWorkHours;
            bonus=overtimeHours*overtimeRate;
        }
        salary=rate*hoursWorked+bonus;
        
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
        
        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\nTotal Hours Worked: %.2f\nRate per Hour:%.2f",
                this.empID,this.empName,dateHired,dateBirth,this.totalHoursWorked,this.ratePerHour);

        
        return info;
    }
}
