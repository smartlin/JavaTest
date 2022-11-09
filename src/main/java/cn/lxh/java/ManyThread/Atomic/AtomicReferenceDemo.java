package cn.lxh.java.ManyThread.Atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by starlin
 * on 2018/3/27 23:29.
 * 原子更新引用
 */
public class AtomicReferenceDemo {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();

    static class User {
        public String userName;
        public int age;

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        User user = new User("starlin", 18);
        atomicReference.set(user);
        User updateUser = new User("starlin1", 20);
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().toString());
    }
}
