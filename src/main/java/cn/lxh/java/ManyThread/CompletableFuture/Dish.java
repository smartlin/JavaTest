package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.TimeUnit;

/**
 * Created by starlin
 * on 2022/7/4 11:47.
 */
public class Dish {
    /**
     * name
     */
    private String name;
    
    /**
     * time
     */
    private int time;

    public Dish(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void make() {
        SmallTool.sleepMillis(TimeUnit.SECONDS.toMillis(this.time));
        SmallTool.printTimeAndThread(this.name + "制作完毕，可以吃了");
    }
}
