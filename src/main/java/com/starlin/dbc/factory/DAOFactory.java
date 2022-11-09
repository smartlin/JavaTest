package com.starlin.dbc.factory;

import com.starlin.dbc.dao.IEmpDao;
import com.starlin.dbc.dao.impl.EmpDAOImpl;

import java.sql.Connection;

/**
 * Created by starlin
 * on 2015/09/19 22:06.
 */
public class DAOFactory {
    public static IEmpDao getIEmpDaoInstance(Connection conn){
        return new EmpDAOImpl(conn);
    }
}
