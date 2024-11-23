package Obj;

public abstract class AbstractAccount extends AbstractObj
{
    //==========================================Variable==========================================
    private String userName;
    private String password;

    //========================================Constructor=========================================
    public AbstractAccount()
    {
        this.userName = "";
        this.password = "";
    }

    public AbstractAccount(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    //============================================Get=============================================
    // Curr Data
    public String getUserName()
    {
        return this.userName;
    }
    public String getPassword()
    {
        return this.password;
    }

    // Db Data
    public String getUserNameDb()
    {
        this.queryInfo();
        return userName;
    }
    public String getPasswordDb()
    {
        this.queryInfo();
        return password;
    }

    //===========================================Modify===========================================
    public void setUserName(String userName)
    {
        this.queryInfo();
        this.userName = userName;
        this.updateInfo();
    }
    public void setPassword(String password)
    {
        this.queryInfo();
        this.password = password;
        this.updateInfo();
    }
}
