
package employee.version1;

import java.time.LocalDate;

public class TestMain
{
    public static void main(String[] args) {
        PieceWorkerEmployee emp1=new PieceWorkerEmployee(1,"Employee 1",LocalDate.now(),LocalDate.of(2003,6,28),100,10);
        emp1.displayInfo();
        System.out.println("Salary this week: "+emp1.computeSalary());
        
        HourlyEmployee emp2=new HourlyEmployee(2,"Employee 2",LocalDate.now(),LocalDate.of(2003,6,28),1000,10);
        emp2.displayInfo();
        System.out.println("Salary this week: "+emp2.computeSalary());

        
        CommissionEmployee emp3=new CommissionEmployee(3,"Employee 3",LocalDate.now(),LocalDate.of(2003,6,28),69420);
        emp3.displayInfo();
        System.out.println("Salary this week: "+emp3.computeSalary());
        
        BasePlusCommissionEmployee emp4=new BasePlusCommissionEmployee(4,"Employee 4",LocalDate.now(),LocalDate.of(2003,6,28),69420,100);
        emp4.displayInfo();
        System.out.println("Salary this week: "+emp4.computeSalary());
    }
}
