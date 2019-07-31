package cn.lxh.java.JDBC;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by starlin
 * on 2015/10/20 14:36.
 */

public class CURD {
    public static void main(String[] args) throws Exception{
        read(1762);
     //   creat(1762,"starlin","会计",new Date(),201.0,10.3);
    }
    //将读取的文件插入至数据库，IO流实现
    public static void creat1(Integer empno,String ename,String job,Date hiredate,Double sal,Double comm,String clob) throws Exception{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        conn = JDBCUtil.getConnection();
        preparedStatement = conn.prepareStatement("INSERT into emp (empno,ename,job,hiredate,sal,comm,clob) VALUES (?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, empno);
        preparedStatement.setString(2,ename);
        preparedStatement.setString(3, job);
        preparedStatement.setDate(4, new java.sql.Date(hiredate.getTime()));
        preparedStatement.setDouble(5, sal);
        preparedStatement.setDouble(6, comm);

        preparedStatement.executeUpdate();
        conn.close();
    }
    public static void creat(Integer empno,String ename,String job,Date hiredate,Double sal,Double comm) throws Exception{
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        conn = JDBCUtil.getConnection();
        preparedStatement = conn.prepareStatement("INSERT into emp (empno,ename,job,hiredate,sal,comm) VALUES (?,?,?,?,?,?)");
        preparedStatement.setInt(1,empno);
        preparedStatement.setString(2,ename);
        preparedStatement.setString(3, job);
        preparedStatement.setDate(4, new java.sql.Date(hiredate.getTime()));
        preparedStatement.setDouble(5, sal);
        preparedStatement.setDouble(6, comm);
        preparedStatement.executeUpdate();
        conn.close();
    }
    public static void read(Integer empno) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        //建立连接
        conn = JDBCUtil.getConnection();
        //创建语句
        preparedStatement = conn.prepareStatement("select empno,ename,job,hiredate,sal,comm from emp where empno  = ?");
        //执行语句
        preparedStatement.setInt(1, empno);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt("empno") + "\t" + rs.getString("ename") + "\t" + rs.getString("job") + "\t" +
                     rs.getDate("hiredate") + "\t" + rs.getDouble("sal") +"\t"+ rs.getDouble("comm"));
        }
        conn.close();
    }

}
