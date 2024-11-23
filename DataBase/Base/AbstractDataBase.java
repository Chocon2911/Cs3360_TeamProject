package DataBase.Base;

import Util.ObjUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataBase extends ObjUtil
{
    protected static String url = "/DataBase/ShopDataBase.db";
    
    //=========================================Connection=========================================
    protected Connection getConnection(String url)
    {
        String dataBaseUrl = "jdbc:sqlite:." + url;
        try
        {
            Connection conn = DriverManager.getConnection(dataBaseUrl);
            if (conn == null)
            {
                System.out.println("Connection is null");
            }

            return conn;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //========================================Create Table========================================
    protected boolean createTable(String url, String executeLine)
    {
        Connection conn = getConnection(url);
        if (conn == null) return false;

        try (Statement statement = conn.createStatement())
        {
            statement.execute(executeLine);
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //===========================================Insert===========================================
    protected boolean insertData(String url, String executeLine, List<DataBaseData> data)
    {
        Connection conn = getConnection(url);
        if (conn == null) return false;
        
        try (PreparedStatement preStatement = conn.prepareStatement(executeLine))
        {
            for (int i = 0; i < data.size(); i++)
            {
                if (data.get(i).getDataBaseType() == DataBaseType.INTEGER)
                {
                    preStatement.setInt(i + 1, data.get(i).getValueInt());
                }
                else if (data.get(i).getDataBaseType() == DataBaseType.TEXT)
                {
                    preStatement.setString(i + 1, data.get(i).getValueStr());
                }
                else if (data.get(i).getDataBaseType() == DataBaseType.FLOAT)
                {
                    preStatement.setFloat(i + 1, data.get(i).getValueFloat());
                }
                else if (data.get(i).getDataBaseType() == DataBaseType.BLOB)
                {
                    preStatement.setBlob(i + 1, data.get(i).getValueBlob());
                }
                else
                {
                    System.out.println("DataBaseType is null");
                    return false;
                }
            }

            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //===========================================Query============================================
    protected List<List<DataBaseData>> queryDatas(String url, String executeLine, DataBaseData queryData, List<String> rowNames, List<DataBaseType> rowTypes)
    {
        Connection conn = getConnection(url);
        if (conn == null) return null;

        try (PreparedStatement preStatement = conn.prepareStatement(executeLine))
        {
            if (queryData.getDataBaseType() == DataBaseType.TEXT)
            {
                preStatement.setString(1, queryData.getValueStr());
            }
            else if (queryData.getDataBaseType() == DataBaseType.INTEGER)
            {
                preStatement.setInt(1, queryData.getValueInt());
            }
            else if (queryData.getDataBaseType() == DataBaseType.FLOAT)
            {
                preStatement.setFloat(1, queryData.getValueFloat());
            }
            else if (queryData.getDataBaseType() == DataBaseType.BLOB)
            {
                preStatement.setBlob(1, queryData.getValueBlob());
            }
            else
            {
                System.out.println("DataBaseType is null");
                return null;
            }

            ResultSet resultSet = preStatement.executeQuery(executeLine);
            List<List<DataBaseData>> datas = new ArrayList<>();
            while (resultSet.next())
            {
                List<DataBaseData> data = new ArrayList<>();
                for (int i = 0; i < rowNames.size(); i++)
                {
                    DataBaseData newData = new DataBaseData();
                    if (rowTypes.get(i) == DataBaseType.TEXT)
                    {
                        newData.setValueStr(resultSet.getString(rowNames.get(i)));
                        data.add(newData);
                    }
                    else if (rowTypes.get(i) == DataBaseType.INTEGER)
                    {
                        newData.setValueInt(resultSet.getInt(rowNames.get(i)));
                        data.add(newData);
                    }
                    else if (rowTypes.get(i) == DataBaseType.FLOAT)
                    {
                        newData.setValueFloat(resultSet.getFloat(rowNames.get(i)));
                        data.add(newData);
                    }
                    else if (rowTypes.get(i) == DataBaseType.BLOB)
                    {
                        newData.setValueBlob(resultSet.getBlob(rowNames.get(i)));
                        data.add(newData);
                    }
                    else
                    {
                        System.out.println("DataBaseType is null");
                        return null;
                    }
                }
                datas.add(data);
            }
            return datas;
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //===========================================Update===========================================
    protected boolean updateData(String url, String execute, DataBaseData whereData, List<DataBaseData> datas)
    {
        Connection conn = getConnection(url);
        if (conn == null) return false;

        try (PreparedStatement preStatement = conn.prepareStatement(execute))
        {
            if (whereData.getDataBaseType() == DataBaseType.TEXT)
            {
                preStatement.setString(1, whereData.getValueStr());
            }
            else if (whereData.getDataBaseType() == DataBaseType.INTEGER)
            {
                preStatement.setInt(1, whereData.getValueInt());
            }
            else if (whereData.getDataBaseType() == DataBaseType.FLOAT)
            {
                preStatement.setFloat(1, whereData.getValueFloat());
            }
            else if (whereData.getDataBaseType() == DataBaseType.BLOB)
            {
                preStatement.setBlob(1, whereData.getValueBlob());
            }
            else
            {
                System.out.println("DataBaseType is null");
                return false;
            }

            for (int i = 0; i < datas.size(); i++)
            {
                if (datas.get(i).getDataBaseType() == DataBaseType.INTEGER)
                {
                    preStatement.setInt(i + 2, datas.get(i).getValueInt());
                }
                else if (datas.get(i).getDataBaseType() == DataBaseType.TEXT)
                {
                    preStatement.setString(i + 2, datas.get(i).getValueStr());
                }
                else if (datas.get(i).getDataBaseType() == DataBaseType.FLOAT)
                {
                    preStatement.setFloat(i + 2, datas.get(i).getValueFloat());
                }
                else if (datas.get(i).getDataBaseType() == DataBaseType.BLOB)
                {
                    preStatement.setBlob(i + 2, datas.get(i).getValueBlob());
                }
                else
                {
                    System.out.println("DataBaseType is null");
                    return false;
                }
            }
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    //===========================================Delete===========================================
    protected boolean deleteRow(String url, String execute, DataBaseData data)
    {
        Connection conn = getConnection(url);
        if (conn == null) return false;

        try (PreparedStatement preStatement = conn.prepareStatement(execute))
        {
            if (data.getDataBaseType() == DataBaseType.TEXT)
            {
                preStatement.setString(1, data.getValueStr());
            }
            else if (data.getDataBaseType() == DataBaseType.INTEGER)
            {
                preStatement.setInt(1, data.getValueInt());
            }
            else if (data.getDataBaseType() == DataBaseType.FLOAT)
            {
                preStatement.setFloat(1, data.getValueFloat());
            }
            else if (data.getDataBaseType() == DataBaseType.BLOB)
            {
                preStatement.setBlob(1, data.getValueBlob());
            }
            else
            {
                System.out.println("DataBaseType is null");
                return false;
            }
            preStatement.executeUpdate();
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
