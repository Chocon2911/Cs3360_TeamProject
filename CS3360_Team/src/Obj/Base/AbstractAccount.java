package Obj.Base;

public abstract class AbstractAccount extends AbstractObj
{
    //==========================================Variable==========================================
    protected String userName;
    protected String password;

    //========================================Constructor=========================================
    public AbstractAccount()
    {
        super();
        this.userName = "";
        this.password = "";
    }

    public AbstractAccount(String id, String name, String userName, String password)
    {
        super(id, name);
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
