package Controller.Child;

import DataBase.Child.CustomerDb;
import DataBase.Child.ManagerDb;
import DataBase.Child.StaffDb;
import Obj.Data.Customer;
import Obj.Data.Manager;
import Obj.Data.Staff;
import Util.ObjUtil;

public class App1Ctrl extends ObjUtil
{
    //===========================================Login============================================
    public int login(String userName, String password)
    {
        Customer customer = new CustomerDb().queryCustomerByUserName(userName);
        if (customer != null)
        {
            if (customer.getPassword().equals(password)) return 1;
            else return 2;
        }

        Staff staff = new StaffDb().queryStaffByUserName(userName);
        if (staff != null)
        {
            if (staff.getPassword().equals(password)) return 3;
            else return 4;
        }

        Manager manager = new ManagerDb().queryManagerByUserName(userName);
        if (manager != null)
        {
            if (manager.getPassword().equals(password)) return 5;
            else return 6;
        }

        return 0;
    }

    public String getCustomerId(String userName, String password)
    {
        Customer customer = new CustomerDb().queryCustomerByUserName(userName);
        if (customer == null) return null;
        else if (customer.getPassword().equals(password)) return null;
        
        return customer.getId();
    }

    public String getStaffId(String userName, String password)
    {
        Staff staff = new StaffDb().queryStaffByUserName(userName);
        if (staff == null) return null;
        else if (staff.getPassword().equals(password)) return null;
        
        return staff.getId();
    }

    public String getManagerId(String userName, String password)
    {
        Manager manager = new ManagerDb().queryManagerByUserName(userName);
        if (manager == null) return null;
        else if (manager.getPassword().equals(password)) return null;
        
        return manager.getId();
    }

    //===========================================SignUp===========================================
    public int signUp(String name, String userName, String password)
    {
        String id = this.getRandomStr(10);
        Customer customer = new Customer(id, name, userName, password, false, 0);

        String e = new CustomerDb().insertCustomerData(customer);
        if (e == null) return 0;
        else if (e.contains("Customers.Id"))
        {
            System.out.println("signUp() Error: Id already exists");
            return this.signUp(name, userName, password);
        } 
        else if (e.contains("Customers.UserName")) return 1;

        return 0;
    }
}
