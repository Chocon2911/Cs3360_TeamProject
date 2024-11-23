package Obj.Base;

import Util.ObjUtil;
import javax.swing.*;

public abstract class AbstractObj extends ObjUtil
{
    //==========================================Variable==========================================
    protected String id;
    protected String name;

    //========================================Constructor=========================================
    public AbstractObj()
    {
        this.id = "";
        this.name = "";
    }

    public AbstractObj(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    //============================================Get=============================================
    // Curr Data
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return this.name;
    }

    // Db Data
    public String getIdDb()
    {
        this.queryInfo();
        return this.id;
    }
    public String getNameDb()
    {
        this.queryInfo();
        return this.name;
    }

    //============================================Set=============================================
    public void setId(String id)
    {
        this.queryInfo();
        this.id = id;
        this.updateInfo();
    }
    public void setName(String name)
    {
        this.queryInfo();
        this.name = name;
        this.updateInfo();
    }

    //==========================================DataBase==========================================
    protected abstract void queryInfo();
    protected abstract void updateInfo();
    public abstract JPanel displayInfo();
}
