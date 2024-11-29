package Controller.Base;

import Obj.Base.BaseObj;

public abstract class AbstractObjCtrl extends BaseObj
{
    //========================================Constructor=========================================
    public AbstractObjCtrl() {}
    public AbstractObjCtrl(String id) { super(id); }

    //==========================================Abstract==========================================
    protected abstract <T> String insertInfo(T info);
    protected abstract <T> T queryInfo();
    protected abstract <T> String updateInfo(T info);
}
