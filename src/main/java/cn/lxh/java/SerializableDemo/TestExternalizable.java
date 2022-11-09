package cn.lxh.java.SerializableDemo;

import java.io.*;

/**
 * Created by starlin
 * on 2019/8/18 11:23.
 */
public class TestExternalizable {
    public static void main(String[] args) {
        UserExternalizable user = new UserExternalizable("wang wu",18);
        //user.setAge(18);
        //user.setName("wang wu");

        // ͨ��ObjectOutputStream���ö���д�뵽�ļ��У�ʵ���Ͼ���һ�����л��Ĺ���
        // ��ͨ��ObjectInputStream���ö�����ļ��ж�������ʵ���Ͼ���һ�ַ����л��Ĺ���
        // �Ѷ���д���ļ�
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("testExternalizable"));
            outputStream.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ���ļ��ж�������
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("testExternalizable"));
            UserExternalizable user1 = (UserExternalizable) inputStream.readObject();
            System.out.println(user1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
