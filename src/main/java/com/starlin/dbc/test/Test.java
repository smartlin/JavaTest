package com.starlin.dbc.test;

import com.starlin.dbc.factory.ServiceFactory;
import com.starlin.dbc.vo.Emp;

import java.util.Date;

/**
 * Created by starlin
 * on 2015/09/19 22:32.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Emp vo = new Emp();
        vo.setEmpno(1482);
        vo.setEname("小王");
        vo.setJob("总裁");
        vo.setHiredate(new Date());
        vo.setSal(600.2);
        vo.setComm(800.3);
        System.out.println(ServiceFactory.getIEmpService().getCount(vo.getEmpno()));
    }


}
