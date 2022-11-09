package com.starlin.dbc.service;

import com.starlin.dbc.vo.Emp;

import java.util.List;

/**
 * Created by starlin
 * on 2015/09/19 22:08.
 */
public interface IEmpService {
    public boolean inset(Emp vo) throws Exception;
    public boolean udpate(Emp vo) throws Exception;
    public boolean delete(int id) throws Exception;
    public Emp getById(int id) throws Exception;
    public List<Emp> getAll() throws Exception;
    public int getCount(int empno) throws Exception;
}
