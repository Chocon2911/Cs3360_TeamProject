package UI.App1;

import Controller.Child.ManagerCtrl;

public class ManagerUI 
{
    private ManagerCtrl ctrl;
    
    public ManagerUI()
    {
        this.ctrl = null;
    }

    public ManagerUI(String id)
    {
        this.ctrl = new ManagerCtrl(id);
    }
}
