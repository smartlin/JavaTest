package com.starlin.dbc.dao.impl;

import com.starlin.dbc.dao.IEmpDao;
import com.starlin.dbc.vo.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by starlin
 * on 2015/09/19 21:49.
 */
public class EmpDAOImpl implements IEmpDao{
    private Connection conn;
    private PreparedStatement pstmt;
    public EmpDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public boolean doCreate(Emp vo) throws Exception {
        String sql = "insert into emp(empno,ename,job,hiredate,sal,comm) values (?,?,?,?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,vo.getEmpno());
        this.pstmt.setString(2,vo.getEname());
        this.pstmt.setString(3,vo.getJob());
        this.pstmt.setDate(4,new java.sql.Date(vo.getHiredate().getTime()));
        this.pstmt.setDouble(5,vo.getSal());
        this.pstmt.setDouble(6,vo.getComm());
        if(this.pstmt.executeUpdate() > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean doUpdate(Emp vo) throws Exception {
        String sql = "update emp set ename=?,job=?,hiredate=?,sal=?,comm=? where empno=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1, vo.getEname());
        this.pstmt.setString(2, vo.getJob());
        this.pstmt.setDate(3, new java.sql.Date(vo.getHiredate().getTime()));
        this.pstmt.setDouble(4, vo.getSal());
        this.pstmt.setDouble(5, vo.getComm());
        this.pstmt.setInt(6, vo.getEmpno());
        if(this.pstmt.executeUpdate() > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean doRemove(Integer id) throws Exception {
        String sql = "delete  from emp where empno = ?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,id);
        if(this.pstmt.executeUpdate() > 0){
            return true;
        }
        return false;
    }

    @Override
    public Emp findById(Integer id) throws Exception {
        Emp vo = null;
        String sql = "select empno,ename,job,hiredate,sal,comm from emp where empno=?";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,id);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            vo = new Emp();
            vo.setEmpno(rs.getInt(1));
            vo.setEname(rs.getString(2));
            vo.setJob(rs.getString(3));
            vo.setHiredate(rs.getDate(4));
            vo.setSal(rs.getDouble(5));
            vo.setComm(rs.getDouble(6));
        }
        return vo;
    }

    @Override
    public List<Emp> findAll() throws Exception {
        List<Emp> all = new ArrayList<Emp>();
        String sql = "select empno,ename,job,hiredate,sal,comm from emp";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){
            Emp vo = new Emp();
            vo.setEmpno(rs.getInt(1));
            vo.setEname(rs.getString(2));
            vo.setJob(rs.getString(3));
            vo.setHiredate(rs.getDate(4));
            vo.setSal(rs.getDouble(5));
            vo.setComm(rs.getDouble(6));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer GetCount() throws Exception {
        String sql = "select COUNT(empno) from emp ";
        this.pstmt =this.conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        if(rs.next()){

            return rs.getInt(1);
        }
        return 0;
    }
}
