package cn.lxh.java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 利用反射完善工厂类
 * 只要有“包.类”就用反射处理
 * Created by starlin
 * on 2015/09/28 22:31.
 */
interface Messages{
    public void print(String str);
}
class News implements Messages{

    @Override
    public void print(String str) {
        System.out.println("新闻的内容：" + str);
    }
}
class Email implements Messages{
    @Override
    public void print(String str) {
        System.out.println("邮件的内容：" + str);
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
// 上面的代码隐藏，直接用反射来完成
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
//        Messages msg = Factory.getInstance("cn.lxh.java.Email");
//        msg.print("我是帅哥");
        //通过更改属性文件来取得相应的输出
        Properties pro = new Properties();
        pro.load(new FileInputStream(new File("d:" + File.separator + "reflect.properties")));
        Messages msg = Factory.getInstance("cn.starlin.reflect." + pro.getProperty("cn.starlin.reflect"));
        msg.print("我是帅哥");
    }
}
