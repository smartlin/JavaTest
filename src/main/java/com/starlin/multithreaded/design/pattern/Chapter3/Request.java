package com.starlin.multithreaded.design.pattern.Chapter3;

/**
 * Created by starlin
 * on 2022/9/25 23:01.
 */
public class Request {
    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
