package cn.lxh.java.SerializableDemo;

import java.io.*;

/**
 * Created by starlin
 * on 2019/8/18 11:20.
 */
public class UserExternalizable implements Externalizable {

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

    private String name;
    private int age;

    public UserExternalizable() {
    }

    // 指定了构造方法
    public UserExternalizable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (int) in.readObject();
    }
}

