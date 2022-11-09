package cn.lxh.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by starlin
 * on 2015/10/20 15:17.
 */
public class JDBCUtil {
    private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=model";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "starlin.cn";
    private JDBCUtil(){
    }
    static{
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
    }
}
