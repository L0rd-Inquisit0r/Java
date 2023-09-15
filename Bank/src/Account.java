public class Account {
    private int accNum;
    private float accBal;
    private String custName;
    private String email;
    private int phoneNum;

    public Account(int accNum, float accBal, String custName, String email, int phoneNum) {
        this.accNum = accNum;
        this.accBal = accBal;
        this.custName = custName;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public Account() {
    }
    
    

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public float getAccBal() {
        return accBal;
    }

    public void setAccBal(float accBal) {
        this.accBal = accBal;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public void depositFunds(float funds)
    {
        this.accBal+=funds;
    }

    public boolean withdrawFunds(float funds)
    {
        float newBalance = this.accBal-funds;
        boolean withdrawAllowed;
        if(newBalance>=0)
        {
            this.accBal=newBalance;
            withdrawAllowed = true;
        }else
        {
            withdrawAllowed = false;
        }
        return withdrawAllowed;
    }
    
    public boolean transferFunds(Account account,float funds)
    {
        boolean transferSuccess;
        float newBalance=this.accBal-funds;
        
        if(newBalance>=0)
        {
            this.accBal=newBalance;
            account.accBal+=funds;
            transferSuccess=true;
        }else
        {
            transferSuccess=false;
        }
        
        return transferSuccess;
    }
}
