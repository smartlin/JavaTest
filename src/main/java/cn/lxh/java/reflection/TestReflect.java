package cn.lxh.java.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * ���÷������ƹ�����
 * ֻҪ�С���.�ࡱ���÷��䴦��
 * Created by starlin
 * on 2015/09/28 22:31.
 */
interface Messages{
    public void print(String str);
}

class News implements Messages{

    @Override
    public void print(String str) {
        System.out.println("���ŵ����ݣ�" + str);
    }
}

class Email implements Messages{
    @Override
    public void print(String str) {
        System.out.println("�ʼ������ݣ�" + str);
    }
}

class Factory{
    public static Messages getInstance(String classname){
//        if(classname.equals("News")){
//            return new News();
//        }
//        if(classname.equals("Email")){
//            return new Email();
//        }
//        return null;
// ����Ĵ������أ�ֱ���÷��������
        try {
            return (Messages) Class.forName(classname).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class TestReflect {
    public static void main(String[] args) throws Exception{
//        Messages msg = Factory.getInstance("cn.starlin.reflect.Email");
//        msg.print("����˧��");
        //ͨ�����������ļ���ȡ����Ӧ�����
        Properties pro = new Properties();
        pro.load(new FileInputStream(new File("d:" + File.separator + "reflect.properties")));
        Messages msg = Factory.getInstance("cn.lxh.java.reflection." + pro.getProperty("cn.lxh.java.reflection"));
        msg.print("����˧��");
    }
}
