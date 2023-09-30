package employee.version4;

import java.time.*;

public class EmployeeRoster {
	private Employee[] emplist;
	private int count;
	private int max;
	
	public EmployeeRoster(int max) {
		this.emplist=new Employee[max];
		this.count=0;
		this.max = max;
	}
	
	public EmployeeRoster() {
		this.emplist=new Employee[10];
		this.max=10;
		this.count=0;
	}

	public void displayAllEmployees() {
		System.out.printf("%-5s|%-20s|%-20s|%s\n","ID","NAME","TYPE","SALARY");
		for(int ndx=0;ndx<this.count;ndx++) {
			if(emplist[ndx] instanceof Hourly) {
				Hourly emp=(Hourly)this.emplist[ndx];
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						emp.getEmpID(),emp.getEmpName(),"Hourly",emp.computeSalary());
				System.out.println(format);
			}
			if(emplist[ndx] instanceof PieceWorker) {
				PieceWorker emp=(PieceWorker)this.emplist[ndx];
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						emp.getEmpID(),emp.getEmpName(),"Piece Worker",emp.computeSalary());
				System.out.println(format);
			}
			if(emplist[ndx] instanceof Commission&&!(emplist[ndx] instanceof BasePlus)) {
				Commission emp=(Commission)this.emplist[ndx];
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						emp.getEmpID(),emp.getEmpName(),"Commission",emp.computeSalary());
				System.out.println(format);
			}
			if(emplist[ndx] instanceof BasePlus) {
				BasePlus emp=(BasePlus)this.emplist[ndx];
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						emp.getEmpID(),emp.getEmpName(),"Base+Commission",emp.computeSalary());
				System.out.println(format);
			}
		}
	}
	
	public int countEmp(String type) {
		int ctr=0;
		for(int ndx=0;ndx<this.count;ndx++) {
			if(this.emplist[ndx].getClass().getSimpleName().equals(type)){
				ctr++;
			}
		}
		return ctr;
	}
	
	public void displayEmployee(Employee type) {
		if(this.count>0) {
			for(int ndx=0;ndx<this.count;ndx++) {
				if(emplist[ndx].getClass().getSimpleName()==type.getClass().getSimpleName()) {
					System.out.println(emplist[ndx]);
				}
			}
		}
	}
	
	public boolean addEmployee(Employee e) {
		boolean result;
		if(this.count<this.max) {
			this.emplist[this.count]=e;
			this.count++;
			result=true;
		}else {
			result=false;
		}
		return result;
	}
	
	public Employee removeEmployee(int id) {
		Employee del=new Employee();
		int ndx;
		if(this.count>0) {
			for(ndx=0;ndx<this.count&&id!=emplist[ndx].getEmpID();ndx++) {}
			del=emplist[ndx];
			for(;ndx<this.count;ndx++) {
				this.emplist[ndx]=emplist[ndx+1];
			}
			this.count--;
		}
		return del;
	}
	
	public void updateEmployee(int id,Name name,LocalDate hiredDate,LocalDate birthDate){
		int ndx;
		if(this.count>0) {
			for(ndx=0;ndx<this.count&&id!=emplist[ndx].getEmpID();ndx++) {}	
			this.emplist[ndx].setEmpName(name);
			this.emplist[ndx].setEmpBirthDate(birthDate);
			this.emplist[ndx].setEmpDateHired(birthDate);
		}
	}
	
	public EmployeeRoster searchEmployee(String keyword) {
		EmployeeRoster search=new EmployeeRoster(this.max);
		
		if(this.count>0) {
			for(int ndx=0;ndx<this.count;ndx++) {
				if(this.emplist[ndx].getEmpBirthDate().toString().equals(keyword)||
				this.emplist[ndx].getEmpDateHired().toString().equals(keyword)||
				this.emplist[ndx].getEmpName().toString().equals(keyword)) {
					search.emplist[search.count++]=this.emplist[ndx];
				}
			}
		}
		return search;
	}
}
