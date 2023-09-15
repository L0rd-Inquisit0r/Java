public class Main {

    public static void main(String[] args) {
        Account user1=new Account(1,525,"Joe Mama","joemama@email.com",987654321);
        Account user2=new Account(2,6420,"John Doe","johndoe@email.com",000000);
        
        System.out.println("user1 funds: "+user1.getAccBal());
        user1.depositFunds(1000);
        System.out.println("user1 funds: "+user1.getAccBal());
        System.out.println("user1 withdraw success: "+user1.withdrawFunds(500));
        System.out.println("user1 funds: "+user1.getAccBal());
        
        System.out.println("user2 funds: "+user2.getAccBal());
        System.out.println("user2 transfer success: "+user2.transferFunds(user1, 500));
        System.out.println("user1 funds: "+user1.getAccBal());
        System.out.println("user2 funds: "+user2.getAccBal());
    }
}
