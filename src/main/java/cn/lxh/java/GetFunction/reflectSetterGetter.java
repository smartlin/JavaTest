package cn.lxh.java.GetFunction;

import cn.lxh.java.StringUntils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射实现属性调用 类似于简单java类中的setter getter
 * Created by starlin
 * on 2015/09/29 23:01.
 */
class Dept{
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
public class reflectSetterGetter {
    public static void main(String[] args) throws Exception{
        String classname = "cn.lxh.java.GetFunction.Dept";
        String value = "信息部";
        String propertity = "dname";
        Class<?> cls = Class.forName(classname);
        Field dnameField = cls.getDeclaredField("dname");//取得成员
        //Method setMet = cls.getDeclaredMethod("set" + StringUntils.initcap(propertity),String.class);
        Method setMet = cls.getDeclaredMethod("set" + StringUntils.initcap(propertity),dnameField.getType());//取得成员的属性dnameField.getType()
        Method getMet = cls.getDeclaredMethod("get" + StringUntils.initcap(propertity));
        Object obj = cls.newInstance();
        setMet.invoke(obj,value);
        System.out.println(getMet.invoke(obj));
    }
}
