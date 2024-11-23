package Obj.Main;

import Obj.Base.AbstractAccount;

import java.awt.Font;
import java.util.List;
import javax.swing.*;

import DataBase.Child.ShopDb;


public class Shop extends AbstractAccount
{
    //==========================================Variable==========================================
    private String systemCode;
    private String checkInCode;
    private List<Manager> activeManagers;
    private List<Staff> activeStaffs;
    private List<Customer> activeCustomers;
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
        this.activeCustomers = null;
        this.items = null;
        this.customerRequests = null;
    }

    public Shop(String id, String name, String userName, String password, String systemCode,
    String checkInCode, List<Manager> activeManagers, List<Staff> activeStaffs, 
    List<Customer> activeCustomers, List<Item> items, List<CustomerRequest> customerRequests)
    {
        super(id, name, userName, password);
        this.systemCode = systemCode;
        this.checkInCode = checkInCode;
        this.activeManagers = activeManagers;
        this.activeStaffs = activeStaffs;
        this.activeCustomers = activeCustomers;
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
    public List<Customer> getActiveCustomers()
    {
        return activeCustomers;
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
    public List<Customer> getActiveCustomersDb()
    {
        this.queryInfo();
        return activeCustomers;
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
    public void setActiveCustomers(List<Customer> activeCustomers)
    {
        this.queryInfo();
        this.activeCustomers = activeCustomers;
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

    //==========================================Display===========================================
    public JPanel displayPrivateInfo()
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setAlignmentCenter(panel);

        // Title Label
        JLabel titleLabel = new JLabel("Private Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, normalTitleSize));
        this.setAlignmentCenter(titleLabel);

        // System Code Label
        JLabel systemCodeLabel = new JLabel("System Code: " + this.getSystemCodeDb());
        systemCodeLabel.setFont(new Font("Arial", Font.PLAIN, normalTextSize));
        this.setAlignmentCenter(systemCodeLabel);

        // CheckIn Code Label
        JLabel checkInLabel = new JLabel("CheckIn Code: " + this.getCheckInCodeDb());
        checkInLabel.setFont(new Font("Arial", Font.PLAIN, normalTextSize));
        this.setAlignmentCenter(checkInLabel);

        // display
        panel.add(titleLabel);
        panel.add(systemCodeLabel);
        panel.add(checkInLabel);
        return panel;
    }

    public JPanel displayActiveManagersInfo()
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setAlignmentCenter(panel);

        // Display
        for (Manager manager : this.getActiveManagersDb())
        {
            panel.add(Box.createVerticalStrut(this.verticalStrut));
            panel.add(manager.displayInfo());
        }

        return panel;
    }

    public JPanel displayActiveStaffsInfo()
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setAlignmentCenter(panel);

        // Display
        for (Staff staff : this.getActiveStaffs())
        {
            panel.add(Box.createVerticalStrut(this.verticalStrut));
            panel.add(staff.displayInfo());
        }

        return panel;
    }

    public JPanel displayActiveCustomersInfo()
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setAlignmentCenter(panel);

        // Display
        for (Customer customer : this.getActiveCustomersDb())
        {
            panel.add(Box.createVerticalStrut(this.verticalStrut));
            panel.add(customer.displayInfo());
        }

        return panel;
    }

    public JPanel displayItemsInfo()
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setAlignmentCenter(panel);

        // Display
        for (Item item : this.getItemsDb())
        {
            panel.add(Box.createVerticalStrut(this.verticalStrut));
            panel.add(item.displayInfo());
        }

        return panel;
    }

    public JPanel displayCustomerRequestsInfo()
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setAlignmentCenter(panel);

        // Display
        for (CustomerRequest customerRequest : this.getCustomerRequests())
        {
            panel.add(Box.createVerticalStrut(this.verticalStrut));
            panel.add(customerRequest.displayInfo());
        }

        return panel;
    }

    //==========================================Abstract==========================================
    @Override
    protected void queryInfo()
    {
        Shop queryShop = new ShopDb().queryShopData(this.id);
        if (queryShop == null)
        {
            System.out.println("QueryShop is null.");
            return;
        }
        
        this.name = queryShop.getName();
        this.userName = queryShop.getUserName();
        this.password = queryShop.getPassword();
        this.systemCode = queryShop.getSystemCode();
        this.checkInCode = queryShop.getCheckInCode();

        this.activeManagers = queryShop.getActiveManagersDb();
        this.activeStaffs = queryShop.getActiveStaffsDb();
        this.activeCustomers = queryShop.getActiveCustomersDb();
        this.items = queryShop.getItemsDb();
        this.customerRequests = queryShop.getCustomerRequests();
    }
    @Override
    protected void updateInfo()
    {
        new ShopDb().updateShopData(this);
    }
    @Override
    public JPanel displayInfo()
    {
        return null;
    }
}
