
package version1;

public class Main
{
    public static void main(String[] args) 
    {
        MyPoint point=new MyPoint();
        
        point.setPointX(-10);
        point.setPointY(10);
        point.displayPoint();
        System.out.println("Point is in Quadrant: "+point.getQuadrant());
        System.out.println("Angle on the positive x-axis: "+point.getAngle());
        System.out.println("Distance from origin: "+point.getDistance(0, 0));
    }
    
}
