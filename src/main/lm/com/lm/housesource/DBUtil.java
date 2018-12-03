package com.lm.housesource;

import java.sql.*;

/**
 * Created by Administrator on 2018/10/28/028.
 */
public class DBUtil
{
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/house?useUnicode=true&characterEncoding=utf-8";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "123456";
    public static Connection getConn(){
        Connection connection = null;
            try
            {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return connection;
    }
}
