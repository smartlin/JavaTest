package cn.lxh.java.SerializableDemo;

import java.io.Serializable;

/**
 * Created by starlin
 * on 2019/8/18 11:20.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8329386886941302966L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        User.className = className;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    private String name;
    private int age;
    public static String className = "测试-序列化前";
    private transient String studentName = "学生姓名-序列化前";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className=" + className +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}

