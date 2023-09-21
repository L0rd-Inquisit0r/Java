package employee.version2;

import java.time.format.*;
import java.time.LocalDate;

public class Hourly extends Employee{
	private float totalHoursWorked;
    private float ratePerHour;
    
	public Hourly(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate, float totalHoursWorked,
			float ratePerHour) {
		super(empID, empName, empDateHired, empBirthDate);
		this.totalHoursWorked = totalHoursWorked;
		this.ratePerHour = ratePerHour;
	}

	public Hourly(int empID, String empName, float totalHoursWorked, float ratePerHour) {
		super(empID, empName);
		this.totalHoursWorked = totalHoursWorked;
		this.ratePerHour = ratePerHour;
	}
	

	public Hourly(float totalHoursWorked, float ratePerHour) {
		super();
		this.totalHoursWorked = totalHoursWorked;
		this.ratePerHour = ratePerHour;
	}

	public Hourly(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate) {
		super(empID, empName, empDateHired, empBirthDate);
	}
	

	public Hourly(int empID, String empName) {
		super(empID, empName);
	}
	

	public Hourly() {
		super();
	}
	

	public float getTotalHoursWorked() {
		return totalHoursWorked;
	}

	public void setTotalHoursWorked(float totalHoursWorked) {
		this.totalHoursWorked = totalHoursWorked;
	}

	public float getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(float ratePerHour) {
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
        String dateHired=super.getEmpDateHired().format(dateFormat);
        String dateBirth=super.getEmpBirthDate().format(dateFormat);
        
        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\nTotal Hours Worked: %.2f\nRate per Hour:%.2f",
                super.getEmpID(),super.getEmpName(),dateHired,dateBirth,this.totalHoursWorked,this.ratePerHour);

        
        return info;
    }
}
