package com.project.proletariatv3;

import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
    private static final String TAG ="Dbutils";
    private static String driver="com.mysql.jdbc.Driver";
    //Details to get access to the
    private static String user="u3q2qwq0t55ly6bv";

    private static String password = "K4zjQIWBPKZGNmNmGVn2";

    public static Connection getConn(String dbName){
        Connection connection = null;
        try{
            Class.forName(driver);
            String ip="b7grpvyfjkpjoxrfwrro-mysql.services.clever-cloud.com";
            String port="3306";
            String url = "jdbc:mysql://" + ip + ":" + port +"/" + dbName;
            connection= DriverManager.getConnection(url, user, password);
            Log.e("Database Link", "Success");
        } catch (Exception e) {
            Log.e("Database Link", "Failure!");
            e.printStackTrace();
        }
        return connection;
    }
    public static String[] getEthData() {
        String rsdata[]=new String[24];
        Connection connection = getConn("b7grpvyfjkpjoxrfwrro");
        if (connection!=null){
            String sql="select * from apidate order by id DESC limit 1";
            try{
                java.sql.Statement statement = connection.createStatement();
                ResultSet rSet = statement.executeQuery(sql);
//                while (rSet.next()) {
//                    rsdata[0]=rSet.getString("id");//date
//                    Log.e(TAG,"Array creation successful");
//                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
        Log.e(TAG,"Array returned from method");
        return rsdata;
    }
    public static String getVersion() {
        String version=null;
        Connection connection = getConn("b7grpvyfjkpjoxrfwrro");
        if (connection!=null){
            String sql="select version from version";
            try{
                java.sql.Statement statement = connection.createStatement();
                ResultSet rSet = statement.executeQuery(sql);
                while (rSet.next()) {
                    version=rSet.getString("version");//date
                    Log.e(TAG,"Array Success"+version);
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
        Log.e(TAG,"String returned from method getVersion");
        return version;
    }
}
