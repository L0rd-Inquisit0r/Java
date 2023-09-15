package employee.version1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PieceWorkerEmployee 
{
    private int empID;
    private String empName;
    private LocalDate empDateHired;
    private LocalDate empBirthDate;
    private int totalPiecesFinished;
    private float ratePerPiece;

    public PieceWorkerEmployee(int empID, String empName, LocalDate empDateHired, LocalDate empBirthDate, int totalPiecesFinished, float ratePerPiece) 
    {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, float ratePerPiece) 
    {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public PieceWorkerEmployee() {}

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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public float getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(float ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
    
    public double computeSalary()
    {
        double salary=0;
        int piecesFinished=0;
        double bonus=0;
        
        for(int hundredth=0;piecesFinished<this.totalPiecesFinished;piecesFinished++,hundredth++)
        {
            if(hundredth==99)
            {
                hundredth-=99;
                bonus+=(this.ratePerPiece)*10;
            }
            salary+=this.ratePerPiece;
        }
        salary+=bonus;
        
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
        
        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\nTotal Pieces Finished: %d\nRate per Piece:%.2f",
                this.empID,this.empName,dateHired,dateBirth,this.totalPiecesFinished,this.ratePerPiece);

        
        return info;
    }
}
