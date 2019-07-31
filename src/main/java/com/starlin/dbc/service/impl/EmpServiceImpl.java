package com.starlin.dbc.service.impl;

import com.starlin.dbc.DataBaseConnection;
import com.starlin.dbc.service.IEmpService;
import com.starlin.dbc.vo.Emp;
import com.starlin.dbc.factory.DAOFactory;


import java.util.List;

/**
 * Created by starlin
 * on 2015/09/19 22:11.
 */
public class EmpServiceImpl implements IEmpService{
    private DataBaseConnection dbc = new DataBaseConnection();

    @Override
    public boolean inset(Emp vo) throws Exception {
        try{
            if(DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findById(vo.getEmpno()) == null){
                return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).doCreate(vo);
            }
            return  false;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }

    }

    @Override
    public boolean udpate(Emp vo) throws Exception {
        try{
            return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).doUpdate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        try{
            return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).doRemove(id);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Emp getById(int id) throws Exception {
        try{
            return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findById(id);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Emp> getAll() throws Exception {
       try{
           return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAll();
       }catch (Exception e){
           throw e;
       }finally {
           this.dbc.close();
       }
    }

    @Override
    public int getCount(int empno) throws Exception {
        try{
            if(DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).findAll() !=null){
                return DAOFactory.getIEmpDaoInstance(this.dbc.getConn()).GetCount();
            }
            return 0;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

}
