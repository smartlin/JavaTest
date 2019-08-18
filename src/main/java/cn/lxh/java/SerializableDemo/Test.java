package cn.lxh.java.SerializableDemo;

import java.io.*;

/**
 * Created by starlin
 * on 2019/8/18 11:23.
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(18);
        user.setName("wang wu");
        user.setStudentName("学生姓名-序列化后");
        User.className = "测试-序列化后";

        // 通过ObjectOutputStream将该对象写入到文件中，实际上就是一种序列化的过程
        // 在通过ObjectInputStream将该对象从文件中读出来，实际上就是一种反序列化的过程
        // 把对象写入文件
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("test"));
            outputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 从文件中读出对象
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("test"));
            User user1 = (User) inputStream.readObject();
            System.out.println(user1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
