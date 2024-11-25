package DataBase.Child;

import DataBase.Base.AbstractDataBase;
import DataBase.Base.DataBaseData;
import DataBase.Base.DataBaseType;
import Obj.Main.Manager;
import Obj.Main.Shop;
import java.util.ArrayList;
import java.util.List;

public class ManagerDb extends AbstractDataBase
{
    //============================================Main============================================
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
        DataBaseData id = new DataBaseData();
        DataBaseData name = new DataBaseData();
        DataBaseData userName = new DataBaseData();
        DataBaseData password = new DataBaseData();
        DataBaseData shopId = new DataBaseData();

        id.setValueStr(manager.getIdDb());
        name.setValueStr(manager.getNameDb());
        userName.setValueStr(manager.getUserNameDb());
        password.setValueStr(manager.getPasswordDb());
        shopId.setValueStr(manager.getShop().getIdDb());

        List<DataBaseData> datas = new ArrayList<>();
        datas.add(id);
        datas.add(name);
        datas.add(userName);
        datas.add(password);
        datas.add(shopId);

        String sql = "INSERT INTO Managers "
                + "(Id, Name, UserName, Password, ShopId) "
                + "VALUES (?, ?, ?, ?, ?)";

        return this.insertData(url, sql, datas);
    }
    
    public Manager queryManagerData(String id)
    {
        DataBaseData queryData = new DataBaseData();
        queryData.setValueStr(id);

        String sql = "SELECT * FROM Managers WHERE Id = ?";
        List<String> rowNames = new ArrayList(); 
        rowNames.add("Id");
        rowNames.add("Name");
        rowNames.add("UserName");
        rowNames.add("Password");
        rowNames.add("ShopId");

        List<DataBaseType> rowTypes = new ArrayList();
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);

        List<List<DataBaseData>> datas = this.queryDatas(url, sql, queryData, rowNames, rowTypes);
        if (datas.size() == 0) return null;

        String name = datas.get(0).get(0).getValueStr();
        String userName = datas.get(0).get(1).getValueStr();
        String password = datas.get(0).get(2).getValueStr();
        String shopId = datas.get(0).get(3).getValueStr();
        Shop shop = new ShopDb().queryShopData(shopId);

        return new Manager(id, name, userName, password, shop);
    }

    public boolean updateManagerData(Manager manager)
    {
        String sql = "UPDATE Managers SET * WHERE Id = ?";

        DataBaseData id = new DataBaseData();
        id.setValueStr(manager.getIdDb());

        DataBaseData name = new DataBaseData();
        DataBaseData userName = new DataBaseData();
        DataBaseData password = new DataBaseData();
        DataBaseData shopId = new DataBaseData();

        name.setValueStr(manager.getNameDb());
        userName.setValueStr(manager.getUserNameDb());
        password.setValueStr(manager.getPasswordDb());
        shopId.setValueStr(manager.getShop().getIdDb());

        List<DataBaseData> datas = new ArrayList<>();
        datas.add(name);
        datas.add(userName);
        datas.add(password);
        datas.add(shopId);

        return this.updateData(url, sql, id, datas);
    }

    public boolean deleteManagerData(String id)
    {
        String sql = "DELETE FROM Managers WHERE Id = ?";

        DataBaseData idData = new DataBaseData();
        idData.setValueStr(id);

        return this.deleteRow(url, sql, idData);
    }

    //=========================================Additional=========================================
    public List<Manager> queryManagersByShopId(String shopId)
    {
        String sql = "SELECT * FROM Managers WHERE ShopId = ?";

        DataBaseData queryData = new DataBaseData();
        queryData.setValueStr(shopId);

        List<String> rowNames = new ArrayList();
        rowNames.add("Id");
        rowNames.add("Name");
        rowNames.add("UserName");
        rowNames.add("Password");

        List<DataBaseType> rowTypes = new ArrayList();
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);

        List<List<DataBaseData>> datas = this.queryDatas(url, sql, queryData, rowNames, rowTypes);
        if (datas.size() == 0) return null;

        List<Manager> managers = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++)
        {
            String id = datas.get(i).get(0).getValueStr();
            String name = datas.get(i).get(1).getValueStr();
            String userName = datas.get(i).get(2).getValueStr();
            String password = datas.get(i).get(3).getValueStr();
            Shop shop = new ShopDb().queryShopData(shopId);

            managers.add(new Manager(id, name, userName, password, shop));
        }
        
        return managers;
    }
}
