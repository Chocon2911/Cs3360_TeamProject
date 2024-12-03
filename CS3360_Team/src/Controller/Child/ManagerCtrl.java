package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.ManagerDb;
import DataBase.Child.ShopDb;
import DataBase.Child.StaffDb;
import Obj.Data.*;
import Util.GuiUtil;
import javax.swing.*;

public class ManagerCtrl extends AbstractObjCtrl
{
    //========================================Constructor=========================================
    public ManagerCtrl() { super(); }
    public ManagerCtrl(String id) { super(id); }

    //==========================================Override==========================================  
    @Override
    protected <T> String insertInfo(T info)
    {
        return new ManagerDb().insertManagerData((Manager)info);
    }
    @Override
    @SuppressWarnings("unchecked")
    protected Manager queryInfo() 
    { 
        return new ManagerDb().queryManagerData(id); 
    }
    @Override
    protected <T> String updateInfo(T info)
    {
        return new ManagerDb().updateManagerData((Manager)info);
    }



    //============================================================================================
    //========================================Information=========================================
    //============================================================================================
    public JPanel displayInfo()
    {
        Manager manager = this.queryInfo();

        // MainPanel
        JPanel mainPanel = GuiUtil.getInstance().getMainPanel();

        // Id Label
        JLabel idLabel = GuiUtil.getInstance().getNormalLabel(manager.getId());

        // Name Label
        JLabel nameLabel = GuiUtil.getInstance().getNormalLabel(manager.getName());

        // UserName Label
        JLabel userNameLabel = GuiUtil.getInstance().getNormalLabel(manager.getUserName());

        // Password Label
        JLabel passwordLabel = GuiUtil.getInstance().getNormalLabel(manager.getPassword());

        // ShopName Label
        JLabel shopNameLabel = GuiUtil.getInstance().getNormalLabel("Doesn't join Shop yet!");
        if (manager.getShop() != null)
        {
            shopNameLabel = GuiUtil.getInstance().getNormalLabel("Shop Name: " + manager.getShop().getName());
        }

        // Display
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(idLabel);
        mainPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        mainPanel.add(nameLabel);
        mainPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        mainPanel.add(userNameLabel);
        mainPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        mainPanel.add(passwordLabel);
        mainPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        mainPanel.add(shopNameLabel);
        mainPanel.add(Box.createVerticalGlue());

        return mainPanel;
    }



    //============================================================================================
    //=========================================Join Shop==========================================
    //============================================================================================
    public int joinShop(String checkInCode)
    {
        Shop shop = new ShopDb().queryShopByCheckInCode(checkInCode);
        if (shop == null) // No Shop with CheckInCode 
        {
            System.out.println("joinShop(): No Shop with CheckInCode: " + checkInCode);
            return 1;
        }
        else if (shop.getIsLogin()) // Shop is not online yet
        {
            System.out.println("joinShop(): Shop is not online yet: " + checkInCode);
            return 1;
        }

        return 0;
    }

    public String getShopIdByCheckInCode(String checkInCode)
    {
        Shop shop = new ShopDb().queryShopByCheckInCode(checkInCode);
        if (shop == null)
        {
            System.out.println("getShopIdByCheckInCode(): No Shop with CheckInCode: " + checkInCode);
            return null;
        }
        return shop.getId();
    }



    //============================================================================================
    //========================================Create Staff========================================
    //============================================================================================
    public int createStaff(String name, String userName, String password)
    {
        String id = this.getRandomStr(10);
        Staff staff = new Staff(id, name, userName, password, false);
        String e = new StaffDb().insertStaffData(staff);
        if (e.contains("Staffs.Id")) return 1; // Id Already exists
        else if (e.contains("Staffs.UserName")) return 2; // UserName is already exist

        return 0; // Create Successfully
    }

    public String getStaffId(String userName, String password)
    {
        Staff staff = new StaffDb().queryStaffByUserName(userName);
        if (staff == null) return null;
        else if (!staff.getPassword().equals(password)) return null;

        return staff.getId();
    }



    //============================================================================================
    //========================================Delete Staff========================================
    //============================================================================================



    //============================================================================================
    //==========================================Add Item==========================================
    //============================================================================================
}
