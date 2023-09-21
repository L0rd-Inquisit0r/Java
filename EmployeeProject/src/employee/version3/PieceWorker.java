package employee.version3;

import java.time.LocalDate;
import java.time.format.*;


public class PieceWorker extends Employee{
	private int totalPiecesFinished;
	private float ratePerPiece;

	public PieceWorker(int empID, Name empName, LocalDate empDateHired, LocalDate empBirthDate, int totalPiecesFinished,
			float ratePerPiece) {
		super(empID, empName, empDateHired, empBirthDate);
		this.totalPiecesFinished = totalPiecesFinished;
		this.ratePerPiece = ratePerPiece;
	}
	
	public PieceWorker(int empID, Name empName, LocalDate empDateHired, LocalDate empBirthDate) {
		super(empID, empName, empDateHired, empBirthDate);
	}

	public PieceWorker(int totalPiecesFinished, float ratePerPiece) {
		super();
		this.totalPiecesFinished = totalPiecesFinished;
		this.ratePerPiece = ratePerPiece;
	}

	public PieceWorker() {
		super();
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
        String dateHired=super.getEmpDateHired().format(dateFormat);
        String dateBirth=super.getEmpDateHired().format(dateFormat);
        
        String info=String.format("ID: %d\nNAME: %s\nDate Hired: %s\nDate of Birth: %s\nTotal Pieces Finished: %d\nRate per Piece:%.2f",
                super.getEmpID(),super.getEmpName().toString(),dateHired,dateBirth,this.totalPiecesFinished,this.ratePerPiece);

        
        return info;
    }
}
