public class Calculator 
{
    public int add(int x, int y)
    {
        return x + y;
    }
    
    // This method could throw an ArithmeticException
    public double divide(int x, int y) 
    {
        double div=0;
        
        try
        {
            checkZero(y);
            div=(double)x/y;
        }catch(Exception e)
        {
            System.out.println("OOPSIE: "+e);
        }
        return div;
    }
    
    public static void checkZero(int y)throws ArithmeticException
    {
        if(y==0)
        {
            throw new ArithmeticException("YOU CANNOT 0DIVIDE BY ZERO YOU IDIOT!!!");
        }
    }
}
