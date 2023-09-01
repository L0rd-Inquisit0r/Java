public class Account {
    private int accNum;
    private float accBal;
    private String custName;
    private String email;
    private int phoneNum;

    public void setAccNum(int num)
    {
        this.accNum=num;
    }

    public int getAccNum()
    {
        return this.accNum;
    }

    public void setAccBal(float bal)
    {
        this.accBal=bal;
    }

    public float getAccbal()
    {
        return this.accBal;
    }

    public void setCustName(String name)
    {
        this.custName=name;
    }

    public String getCustName()
    {
        return this.custName;
    }

    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setPhone(int num)
    {
        this.phoneNum=num;
    }

    public int getPhone()
    {
        return this.phoneNum;
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
}
