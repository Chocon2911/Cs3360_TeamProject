package Obj.Main;

import java.util.List;

import Obj.Base.AbstractAccount;

public class Shop extends AbstractAccount
{
    //==========================================Variable==========================================
    private String systemCode;
    private String checkInCode;
    private List<Manager> activeManagers;
    private List<Staff> activeStaffs;
    private List<Item> items;
    private List<CustomerRequest> customerRequests;

    //========================================Constructor=========================================
    public Shop()
    {
        super();
        this.systemCode = null;
        this.checkInCode = null;
        this.activeManagers = null;
        this.activeStaffs = null;
        this.items = null;
        this.customerRequests = null;
    }

    public Shop(String id, String name, String userName, String password, String systemCode,
    String checkInCode, List<Manager> activeManagers, List<Staff> activeStaffs, 
    List<Item> items, List<CustomerRequest> customerRequests)
    {
        super(id, name, userName, password);
        this.systemCode = systemCode;
        this.checkInCode = checkInCode;
        this.activeManagers = activeManagers;
        this.activeStaffs = activeStaffs;
        this.items = items;
        this.customerRequests = customerRequests;
    }

    //============================================Get=============================================
    // Curr Data
    public String getSystemCode()
    {
        return systemCode;
    }
    public String getCheckInCode()
    {
        return checkInCode;
    }
    public List<Manager> getActiveManagers()
    {
        return activeManagers;
    }
    public List<Staff> getActiveStaffs()
    {
        return activeStaffs;
    }
    public List<Item> getItems()
    {
        return items;
    }
    public List<CustomerRequest> getCustomerRequests()
    {
        return customerRequests;
    }

    // Db Data
    public String getSystemCodeDb()
    {
        this.queryInfo();
        return systemCode;
    }
    public String getCheckInCodeDb()
    {
        this.queryInfo();
        return checkInCode;
    }
    public List<Manager> getActiveManagersDb()
    {
        this.queryInfo();
        return activeManagers;
    }
    public List<Staff> getActiveStaffsDb()
    {
        this.queryInfo();
        return activeStaffs;
    }
    public List<Item> getItemsDb()
    {
        this.queryInfo();
        return items;
    }
    public List<CustomerRequest> getCustomerRequestsDb()
    {
        this.queryInfo();
        return customerRequests;
    }

    //===========================================Modify===========================================
    public void setSystemCode(String systemCode)
    {
        this.queryInfo();
        this.systemCode = systemCode;
        this.updateInfo();
    }
    public void setCheckInCode(String checkInCode)
    {
        this.queryInfo();
        this.checkInCode = checkInCode;
        this.updateInfo();
    }
    public void setActiveManagers(List<Manager> activeManagers)
    {
        this.queryInfo();
        this.activeManagers = activeManagers;
        this.updateInfo();
    }
    public void setActiveStaffs(List<Staff> activeStaffs)
    {
        this.queryInfo();
        this.activeStaffs = activeStaffs;
        this.updateInfo();
    }
    public void setItems(List<Item> items)
    {
        this.queryInfo();
        this.items = items;
        this.updateInfo();
    }
    public void setCustomerRequests(List<CustomerRequest> customerRequests)
    {
        this.queryInfo();
        this.customerRequests = customerRequests;
        this.updateInfo();
    }

    //==========================================Abstract==========================================
    @Override
    protected void queryInfo()
    {

    }
    @Override
    protected void updateInfo()
    {

    }
}
