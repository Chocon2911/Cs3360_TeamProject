package DataBase.Child;

import DataBase.Base.AbstractDataBase;

public class ManagerDb extends AbstractDataBase
{
    public boolean createManagerTable()
    {
        String sql = "CREAT TABLE IF NOT EXISTS Managers"
                + "("
                + "Id TEXT PRIMARY KEY UNIQUE NOT NULL, "
                + "Name TEXT NOT NULL, "
                + "UserName TEXT NOT NULL, "
                + "Password TEXT NOT NULL, "
                + "ShopId TEXT"
                + ");";

        return this.createTable(url, sql);
    }

    public boolean insertManagerData(Manager manager)
    {

    }
}
