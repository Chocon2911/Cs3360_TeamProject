package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.ManagerDb;
import Obj.Data.*;
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
        JPanel mainPanel = this.getMainPanel();

        // Id Label
        JLabel idLabel = this.getNormalLabel(manager.getId());

        // Name Label
        JLabel nameLabel = this.getNormalLabel(manager.getName());

        // UserName Label
        JLabel userNameLabel = this.getNormalLabel(manager.getUserName());

        // Password Label
        JLabel passwordLabel = this.getNormalLabel(manager.getPassword());

        // ShopName Label
        JLabel shopNameLabel = this.getNormalLabel("Doesn't join Shop yet!");
        if (manager.getShop() != null)
        {
            shopNameLabel = this.getNormalLabel("Shop Name: " + manager.getShop().getName());
        }

        // Display
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(idLabel);
        mainPanel.add(Box.createVerticalStrut(this.verticalStrut));
        mainPanel.add(nameLabel);
        mainPanel.add(Box.createVerticalStrut(this.verticalStrut));
        mainPanel.add(userNameLabel);
        mainPanel.add(Box.createVerticalStrut(this.verticalStrut));
        mainPanel.add(passwordLabel);
        mainPanel.add(Box.createVerticalStrut(this.verticalStrut));
        mainPanel.add(shopNameLabel);
        mainPanel.add(Box.createVerticalGlue());

        return mainPanel;
    }



    //============================================================================================
    //=========================================Join Shop==========================================
    //============================================================================================



    //============================================================================================
    //========================================Create Staff========================================
    //============================================================================================



    //============================================================================================
    //========================================Delete Staff========================================
    //============================================================================================



    //============================================================================================
    //==========================================Add Item==========================================
    //============================================================================================
}
