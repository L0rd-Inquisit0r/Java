package employee.version3;

import java.time.format.*;
import java.time.LocalDate;

public class Hourly extends Employee{
	private float totalHoursWorked;
    private float ratePerHour;
    
	public Hourly(int empID, Name empName, LocalDate empDateHired, LocalDate empBirthDate, float totalHoursWorked,
			float ratePerHour) {
		super(empID, empName, empDateHired, empBirthDate);
		this.totalHoursWorked = totalHoursWorked;
		this.ratePerHour = ratePerHour;
	}

	public Hourly(int empID, Name empName, LocalDate empDateHired, LocalDate empBirthDate) {
		super(empID, empName, empDateHired, empBirthDate);
	}

	public Hourly(float totalHoursWorked, float ratePerHour) {
		super();
		this.totalHoursWorked = totalHoursWorked;
		this.ratePerHour = ratePerHour;
	}
	
	public Hourly() {
		super();
	}

	public double computeSalary()
    {
        double salary;
        float bonus=0;
        if(this.totalHoursWorked>40)
        {
            bonus=(this.totalHoursWorked-40)*(this.ratePerHour*1.5f);
        }
        salary=this.ratePerHour*this.totalHoursWorked+bonus;
        
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
                super.getEmpID(),super.getEmpName().toString(),dateHired,dateBirth,this.totalHoursWorked,this.ratePerHour);

        
        return info;
    }
}
