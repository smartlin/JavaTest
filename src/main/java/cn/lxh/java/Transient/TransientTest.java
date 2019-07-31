package cn.lxh.java.Transient;

import java.io.*;

/**
 * ²âÊÔTransient¹Ø¼ü×Ö
 * Created by starlin
 * on 2018/4/27 23:46.
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("starlin");
        user.setPassword("1111");

        System.out.println("read before Serializable");
        System.out.println("userName:" + user.getUserName());
        System.out.println("password:" + user.getPassword());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("D:/text.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/text.txt"));
            user = (User) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("read after Serializable");
            System.out.println("userName:" + user.getUserName());
            System.out.println("password:" + user.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}


class User implements Serializable {
    private String userName;
    private transient String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}