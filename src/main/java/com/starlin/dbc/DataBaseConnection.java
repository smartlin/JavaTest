package com.starlin.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by starlin
 * on 2015/09/19 21:39.
 */
public class DataBaseConnection {
    private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=model";
    private static final String DBUSER = "sa";
    private static final String PASSWORD = "starlin.cn";
    private Connection conn;
    public DataBaseConnection(){
        try{
            Class.forName(DBDRIVER);
            this.conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
    public void close(){
        if(this.conn == null){
            try {
                this.conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
