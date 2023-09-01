/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Account user=new Account();
        
        user.setAccBal(420.69f);
        user.setAccNum(999);
        user.setCustName("Joe Mama");
        user.setEmail("joemama@email.com");
        user.setPhone(987654321);
        user.withdrawFunds(100.50f);
        System.out.println(user.getAccbal());
        
    }
    
}
