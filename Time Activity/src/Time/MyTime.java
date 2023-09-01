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
public class MyTime {
    private int hours;
    private int minutes;
    private int seconds;
    private boolean meridian; //true = am; false = pm
    
    public MyTime() {
        
    }

    public MyTime(int hours, int minutes, int seconds, boolean meredian) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.meridian = meredian;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public String isMeridian() {
        if(this.meridian==true){
            return "AM";
        }else{
            return "PM";
        }
    }

    public void setMeridian(boolean meredian) {
        this.meridian = meredian;
    }
    
    public void advanceTime(int seconds){
        int advance;
        for(advance=1;advance<=seconds;advance++){
            this.tickBySecond();
        }
    }
    public void tickBySecond(){
        this.seconds++;
        if(this.seconds>=60){
            this.seconds-=60;
            this.tickByMinute();
        }
    }
    public void tickByMinute(){
        this.minutes++;
        if(this.minutes>=60){
            this.minutes-=60;
            this.tickByHour();
        }
    }
    public void tickByHour(){
        boolean change=false;
        this.hours++;
        if(this.hours>12){
            this.hours-=12;
            change=true;
        }
        if(change==true&&this.meridian==true)
        {
            change=false;
            this.meridian=false;
        }
        if(change==true&&this.meridian==false)
        {
            this.meridian=true;
        }
    }
    public void displayTime12(){
        System.out.println(this.toString());
    }
    public void displayTime24(){
        int hour=this.hours;
        int minute=this.minutes;
        if(this.meridian==false)
        {
            hour+=12;
        }
        String time24=String.format("%02d%02d", hours,minutes);
        System.out.println(time24);
    }
    public String toString(){
        String meridian;
        if(this.meridian==true)
        {
            meridian="AM";
        }else
        {
            meridian="PM";
        }
        String time12=String.format("%d:%2d%s", this.hours,this.minutes,meridian);
        return time12;
    }
    
}


