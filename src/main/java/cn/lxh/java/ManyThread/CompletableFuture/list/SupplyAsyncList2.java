package cn.lxh.java.ManyThread.CompletableFuture.list;

import cn.lxh.java.redis.springRedis.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Created by starlin
 * on 2022/12/30 11:08.
 */
public class SupplyAsyncList2 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("starlin11", "123"));
        userList.add(new User("starlin22", "456"));
        userList.add(new User("starlin33", "789"));

        List<CompletableFuture<User>> completableFutures = userList.stream().map(s -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s.setPassWord("SZ-" + s.getPassWord());
            return s;
        })).collect(Collectors.toList());

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));
        List<User> collect1 = completableFutures.stream().map(s -> s.join()).collect(Collectors.toList());
        System.out.println(collect1);
    }
}
