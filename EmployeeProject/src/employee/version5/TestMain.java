package employee.version5;

import java.time.LocalDate;

public class TestMain {

	public static void main(String[] args) {
		Name name=new Name("John","Doe","Smith");
		EmployeeRoster list=new EmployeeRoster();
		
		list.addEmployee(new Hourly(1,name,LocalDate.now(),LocalDate.now(),45.5f,500));
		list.addEmployee(new PieceWorker(2,name,LocalDate.now(),LocalDate.now(),2000,40));
		list.addEmployee(new Commission(3,name,LocalDate.now(),LocalDate.now(),55000));
		list.addEmployee(new BasePlus(4,name,LocalDate.now(),LocalDate.now(),45000,5000));
		list.addEmployee(new Hourly(5,name,LocalDate.now(),LocalDate.now(),55.5f,420));
		list.displayAllEmployees();
		
		System.out.println();
		
		list.removeEmployee(3);
		list.displayAllEmployees();
		
		System.out.println();
		
		list.displayEmployee(new Hourly());
		
		System.out.println();
		
		EmployeeRoster search=list.searchEmployee("John Doe Smith");
		search.displayAllEmployees();
		
		System.out.println();
		
		System.out.println("How may Base+Commission employess in list? "+list.countEmp("BasePlus"));
	}
}
