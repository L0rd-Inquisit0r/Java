package employee.version3;

import java.time.LocalDate;

public class TestMain {

	public static void main(String[] args) {
		Name testName=new Name("John","Doe","Smith");
		
		Hourly emp1=new Hourly(1,testName,LocalDate.now(),LocalDate.now(),40,500f);
		emp1.displayInfo();
		System.out.printf("Salary this week: %.2f\n",emp1.computeSalary());
		
		System.out.println("");
		
		PieceWorker emp2=new PieceWorker(2,testName,LocalDate.now(),LocalDate.now(),5000,500f);
		emp2.displayInfo();
		System.out.printf("Salary this week: %.2f\n",emp2.computeSalary());
		
		System.out.println("");
		
		Commission emp3=new Commission(3,testName,LocalDate.now(),LocalDate.now(),9999);
		emp3.displayInfo();
		System.out.printf("Salary this week: %.2f\n",emp3.computeSalary());
		
		System.out.println("");
		
		BasePlus emp4=new BasePlus(4,testName,LocalDate.now(),LocalDate.now(),9999,5000);
		emp4.displayInfo();
		System.out.printf("Salary this week: %.2f\n",emp4.computeSalary());
	}
}
