package DataBase.Child;

import DataBase.Base.AbstractDataBase;
import DataBase.Base.DataBaseData;
import DataBase.Base.DataBaseType;
import Obj.Main.Manager;
import Obj.Main.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopDb extends AbstractDataBase
{
    public boolean createShopTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS Shops"
                + "("
                + "Id TEXT PRIMARY KEY UNIQUE NOT NULL, "
                + "Name TEXT NOT NULL, "
                + "UserName TEXT NOT NULL, "
                + "Password TEXT NOT NULL, "
                + "SystemCode TEXT NOT NULL, "
                + "CheckInCode TEXT NOT NULL"
                + ");";

        return this.createTable(url, sql);
    }

    public boolean insertShopData(Shop shop)
    {
        String sql = "INSERT INTO Shops" 
                + "(Id, Name, UserName, Password, SystemCode, CheckInCode) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        DataBaseData id = new DataBaseData();
        DataBaseData name = new DataBaseData();
        DataBaseData userName = new DataBaseData();
        DataBaseData password = new DataBaseData();
        DataBaseData systemCode = new DataBaseData();
        DataBaseData checkInCode = new DataBaseData();

        id.setValueStr(shop.getIdDb());
        name.setValueStr(shop.getNameDb());
        userName.setValueStr(shop.getUserNameDb());
        password.setValueStr(shop.getPasswordDb());
        systemCode.setValueStr(shop.getSystemCodeDb());
        checkInCode.setValueStr(shop.getCheckInCodeDb());

        List<DataBaseData> datas = new ArrayList<>();
        datas.add(id);
        datas.add(name);
        datas.add(userName);
        datas.add(password);
        datas.add(systemCode);
        datas.add(checkInCode);

        return this.insertData(url, sql, datas);
    }

    public Shop queryShopData(String id)
    {
        DataBaseData queryData = new DataBaseData();
        queryData.setValueStr(id);

        String sql = "SELECT * FROM Shops WHERE Id = ?";

        List<String> rowNames = new ArrayList();
        rowNames.add("Id");
        rowNames.add("Name");
        rowNames.add("UserName");
        rowNames.add("Password");
        rowNames.add("SystemCode");
        rowNames.add("CheckInCode");

        List<DataBaseType> rowTypes = new ArrayList();
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);
        rowTypes.add(DataBaseType.TEXT);

        List<DataBaseData> datas = this.queryData(url, sql, queryData, rowNames, rowTypes);
        if (datas.size() == 0) return null;

        String name = datas.get(0).getValueStr();
        String userName = datas.get(1).getValueStr();
        String password = datas.get(2).getValueStr();
        String systemCode = datas.get(3).getValueStr();
        String checkInCode = datas.get(4).getValueStr();
        List<Manager> activeManagers = new ManagerDb().queryManagersByShopId(id);
        List<Staff> activeStaffs = new StaffDb().queryStaffsByShopId(id);
        List<Item> items = new ItemDb().queryItemsByShopId(id);
        List<CustomerRequest> customerRequests = new CustomerRequestDb().queryCustomerRequestsByShopId(id);

        return new Shop(id, name, userName, password, systemCode, checkInCode, activeManagers, activeStaffs, items, customerRequests);
    }

    public boolean updateShopData(Shop shop)
    {
        String sql = "UPDATE Shops SET * WHERE Id = ?";

        DataBaseData id = new DataBaseData();
        id.setValueStr(shop.getIdDb());

        DataBaseData name = new DataBaseData();
        DataBaseData userName = new DataBaseData();
        DataBaseData password = new DataBaseData();
        DataBaseData systemCode = new DataBaseData();
        DataBaseData checkInCode = new DataBaseData();

        name.setValueStr(shop.getNameDb());
        userName.setValueStr(shop.getUserNameDb());
        password.setValueStr(shop.getPasswordDb());
        systemCode.setValueStr(shop.getSystemCodeDb());
        checkInCode.setValueStr(shop.getCheckInCodeDb());

        List<DataBaseData> datas = new ArrayList<>();
        datas.add(name);
        datas.add(userName);
        datas.add(password);
        datas.add(systemCode);
        datas.add(checkInCode);

        return this.updateData(url, sql, id, datas);
    }

    public boolean deleteManagerData(String id)
    {
        String sql = "DELETE FROM Shops WHERE Id = ?";
        DataBaseData idDb = new DataBaseData();
        idDb.setValueStr(id);

        return this.deleteRow(url, sql, idDb);
    }
}
