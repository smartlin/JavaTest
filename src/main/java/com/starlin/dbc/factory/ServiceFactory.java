package com.starlin.dbc.factory;

import com.starlin.dbc.service.IEmpService;
import com.starlin.dbc.service.impl.EmpServiceImpl;

/**
 * Created by starlin
 * on 2015/09/19 22:31.
 */
public class ServiceFactory {
    public static IEmpService getIEmpService(){
        return new EmpServiceImpl();
    }
}
