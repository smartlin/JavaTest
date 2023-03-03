package cn.lxh.java.ManyThread.CompletableFuture.list;


import cn.lxh.java.redis.springRedis.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by starlin
 * on 2022/12/30 10:54.
 * ʹ��runAsync�첽����list
 */
public class RunAsyncList {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("starlin11", "123"));
        userList.add(new User("starlin22", "456"));
        userList.add(new User("starlin33", "789"));

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() ->{
            System.out.println("�߳�����=" + Thread.currentThread().getName());
            System.out.println("=======runAsync��ʼִ��========");
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            userList.forEach(s -> {
                s.setPassWord("SZ-" + s.getPassWord());
            });
            System.out.println("=======runAsyncִ��end========");
        });

        System.out.println("���߳�����="+Thread.currentThread().getName());
        completableFuture.join();
        System.out.println("list="+userList.toString());
    }
}
