package version1;
import java.lang.Math;
import java.util.Locale;

public class MyPoint
{
    private int pointX;
    private int pointY;
    
    public void MyPoint()
    {
    }

    public void MyPoint(int pointX, int pointY)
    {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public int getPointX()
    {
        return pointX;
    }

    public void setPointX(int pointX)
    {
        this.pointX = pointX;
    }

    public int getPointY()
    {
        return pointY;
    }

    public void setPointY(int pointY)
    {
        this.pointY = pointY;
    }
    
    public float getDistance(int pointX,int pointY)
    {
        float side1=(float)Math.pow(pointX-this.pointX,2);
        float side2=(float)Math.pow(pointY-this.pointY,2);
        return (float)Math.sqrt(side1+side2);
    }
    
    public void displayPoint()
    {
        System.out.println(this.toString());
    }
    
    public String toString()
    {
        return String.format("(%d,%d)",this.pointX,this.pointY);
    }
    
    public int getQuadrant()
    {
        int quadrant=0;
        
        if(this.pointX>0&&this.pointY>0)
        {
            quadrant=1;
        }
        if(this.pointX<0&&this.pointY>0)
        {
            quadrant=2;
        }
        if(this.pointX<0&&this.pointY<0)
        {
            quadrant=3;
        }
        if(this.pointX>0&&this.pointY<0)
        {
            quadrant=4;
        }
        if(this.pointX!=0&&this.pointY==0)
        {
            quadrant=5;
        }
        if(this.pointX==0&&this.pointY!=0)
        {
            quadrant=6;
        }
        
        return quadrant;
    }
    
    public double getAngle()
    {
        int quadrant=this.getQuadrant();
        double X=Math.abs(this.pointX);
        double Y=Math.abs(this.pointY);
        double rad=Math.atan(Y/X);
        
        double angle=Math.toDegrees(rad);
        
        if(this.pointX<0&&this.pointY>0)
        {
            angle+=90;
        }
        if(this.pointX<0&&this.pointY<0)
        {
            angle+=180;
        }
        if(this.pointX>0&&this.pointY<0)
        {
            angle+=270;
        }
     
        return angle;
    }
}
