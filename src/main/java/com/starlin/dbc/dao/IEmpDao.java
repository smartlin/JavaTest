package com.starlin.dbc.dao;

import com.starlin.dbc.vo.Emp;

import java.util.List;

/**
 * Created by starlin
 * on 2015/09/19 21:46.
 */
public interface IEmpDao {
    public boolean doCreate(Emp vo) throws Exception;
    public boolean doUpdate(Emp vo) throws Exception;
    public boolean doRemove(Integer id) throws Exception;
    public Emp findById(Integer id) throws Exception;
    public List<Emp> findAll() throws Exception;
    public Integer GetCount() throws Exception;
}
