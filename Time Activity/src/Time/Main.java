/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Time;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        MyTime time=new MyTime(5,30,0,true);
        time.displayTime12();
        time.advanceTime(200);
        time.displayTime12();
    }
}
