package employee.version6;

import java.util.ArrayList;

public class EmployeeRoster {
    private ArrayList<Employee> emplist=new ArrayList<>();

    public EmployeeRoster() {
    }

    public ArrayList<Employee> getEmplist() {
        return emplist;
    }

    public void setEmplist(ArrayList<Employee> emplist) {
        this.emplist = emplist;
    }
    
    public void displayAllEmployees() {
        System.out.printf("%-5s|%-20s|%-20s|%s\n","ID","NAME","TYPE","SALARY");
        String format=null;
        for(Employee emp:emplist){ 
            if(emp instanceof Hourly) {
                format=String.format("%-5d|%-20s|%-20s|%.2f",emp.getEmpID(),emp.getEmpName(),"Hourly",emp.computeSalary());
            }
            if(emp instanceof PieceWorker) {
                format=String.format("%-5d|%-20s|%-20s|%.2f",emp.getEmpID(),emp.getEmpName(),"Piece Worker",emp.computeSalary());
            }
            if(emp instanceof Commission&&!(emp instanceof BasePlus)) {
                format=String.format("%-5d|%-20s|%-20s|%.2f",emp.getEmpID(),emp.getEmpName(),"Commission",emp.computeSalary());
            }
            if(emp instanceof BasePlus) {
                format=String.format("%-5d|%-20s|%-20s|%.2f",emp.getEmpID(),emp.getEmpName(),"Base+Commission",emp.computeSalary());
            }
            System.out.println(format);
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
                if(emp.getClass().getSimpleName().equals(type.getClass().getSimpleName())) {
                    System.out.println(emp);
                }
            }
        }
    }
	
    public boolean addEmployee(Employee e) {
        emplist.add(e);
        return (emplist.contains(e));
    }
	
    public Employee removeEmployee(int id) {
        Employee del = null;
        for(Employee emp:emplist) {
            if(emp.getEmpID()==id) {
                del=emp;
                emplist.remove(del);
                return del;
            }
        }
        return del;
    }

    public void updateEmployee(int id,Name name){
        if(!(emplist.isEmpty())) {
            int ndx=0;
            for(Employee emp:emplist){
                if(emp.getEmpID()==id){
                    ndx=emplist.indexOf(emp);
                }
            }
            emplist.get(ndx).setEmpName(name);
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
