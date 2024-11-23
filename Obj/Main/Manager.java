package Obj.Main;

import DataBase.Child.ManagerDb;
import Obj.Base.AbstractAccount;

public class Manager extends AbstractAccount
{
    protected Shop shop;

    //========================================Constructor=========================================
    public Manager()
    {
        super();
        this.shop = null;
    }
    public Manager(String id, String name, String userName, String password, Shop shop)
    {
        super(id, name, userName, password);
        this.shop = shop;
    }

    //============================================Get=============================================
    // Curr Data
    public Shop getShop()
    {
        return this.shop;
    }
    public Shop getShopDb()
    {
        this.queryInfo();
        return this.shop;
    }

    //===========================================Modify===========================================
    public void setShop(Shop shop)
    {
        this.queryInfo();
        this.shop = shop;
        this.updateInfo();
    }

    //==========================================Abstract==========================================
    @Override
    public void queryInfo()
    {
        ManagerDb db = new ManagerDb();
        Manager queryManager = db.queryManagerData(this.id);
        if (queryManager == null)
        {
            System.out.println("QueryManager is null");
            return;
        }

        this.name = queryManager.getName();
        this.userName = queryManager.getUserName();
        this.password = queryManager.getPassword();
        this.shop = queryManager.getShop();
    }
    @Override
    public void updateInfo()
    {
        new ManagerDb().updateManagerData(this);
    }
}
