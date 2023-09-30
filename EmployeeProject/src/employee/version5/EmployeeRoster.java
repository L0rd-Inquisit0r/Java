package employee.version5;

import java.util.ArrayList;
import java.time.LocalDate;

public class EmployeeRoster {
	private ArrayList<Employee> emplist=new ArrayList<>();

	public void displayAllEmployees() {
		System.out.printf("%-5s|%-20s|%-20s|%s\n","ID","NAME","TYPE","SALARY");
		for(Employee emp:emplist) {
			if(emp instanceof Hourly) {
				Hourly hourly=(Hourly)emp;
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						hourly.getEmpID(),hourly.getEmpName(),"Hourly",hourly.computeSalary());
				System.out.println(format);
			}
			if(emp instanceof PieceWorker) {
				PieceWorker piece=(PieceWorker)emp;
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						piece.getEmpID(),piece.getEmpName(),"Piece Worker",piece.computeSalary());
				System.out.println(format);
			}
			if(emp instanceof Commission&&!(emp instanceof BasePlus)) {
				Commission comm=(Commission)emp;
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						comm.getEmpID(),comm.getEmpName(),"Commission",comm.computeSalary());
				System.out.println(format);
			}
			if(emp instanceof BasePlus) {
				BasePlus base=(BasePlus)emp;
				String format=String.format("%-5d|%-20s|%-20s|%.2f",
						base.getEmpID(),base.getEmpName(),"Base+Commission",base.computeSalary());
				System.out.println(format);
			}
		}
	}
	
	public int countEmp(String type) {
		int ctr=0;
		for(Employee emp:emplist) {
			if(emp.getClass().getSimpleName().equals(type)){
				ctr++;
			}
		}
		return ctr;
	}
	
	public void displayEmployee(Employee type) {
		if(!(this.emplist.isEmpty())) {
			for(Employee emp:emplist) {
				if(emp.getClass().getSimpleName()==type.getClass().getSimpleName()) {
					System.out.println(emp);
				}
			}
		}
	}
	
	public boolean addEmployee(Employee e) {
		emplist.add(e);
		return (emplist.contains(e))?true:false;
	}
	
	public Employee removeEmployee(int id) {
		Employee del=new Employee();
		for(Employee emp:emplist) {
			if(emp.getEmpID()==id) {
				del=emp;
			}
		}
		emplist.remove(del);
		return del;
	}

	public void updateEmployee(int id,Name name,LocalDate hiredDate,LocalDate birthDate){
		if(!(emplist.isEmpty())) {
			Employee update=new Employee(id,name,hiredDate,birthDate);
			int ndx=0;
			for(Employee emp:emplist) {
				if(emp.getEmpID()==id) {
					break;
				}
				ndx++;
			}
			emplist.set(ndx,update);
		}
	}
	
	public EmployeeRoster searchEmployee(String keyword) {
		EmployeeRoster search=new EmployeeRoster();
		
		if(!(emplist.isEmpty())) {
			for(Employee emp:emplist) {
				if(emp.getEmpBirthDate().toString().equals(keyword)||
				emp.getEmpDateHired().toString().equals(keyword)||
				emp.getEmpName().toString().equals(keyword)) {
					search.addEmployee(emp);
				}
			}
		}
		return search;
	}
}
