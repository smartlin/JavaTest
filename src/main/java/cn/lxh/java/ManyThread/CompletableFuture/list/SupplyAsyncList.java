package cn.lxh.java.ManyThread.CompletableFuture.list;

import cn.lxh.java.redis.springRedis.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Created by starlin
 * on 2022/12/30 11:02.
 */
public class SupplyAsyncList {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("starlin11", "123"));
        userList.add(new User("starlin22", "456"));
        userList.add(new User("starlin33", "789"));

        List<CompletableFuture<User>> completableFutures = userList.stream().map(s -> CompletableFuture.supplyAsync(() ->{
            s.setPassWord("SZ-" + s.getPassWord());
            return s;
        })).collect(Collectors.toList());
        //这里的allOf是一个工具方法
        CompletableFuture<List<User>> completableFuture1 = allOf(completableFutures);
        List<User> users = completableFuture1.join();
        System.out.println("users="+users);
    }
    public static <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> futures) {
        CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        return allDoneFuture.thenApply(v ->
                futures.stream().map(future -> future.join()).collect(Collectors.<T>toList())
        );
    }
}
