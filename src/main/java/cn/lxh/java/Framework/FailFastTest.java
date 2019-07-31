package cn.lxh.java.Framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by starlin
 * on 2018/5/17 16:20.
 */
public class FailFastTest {
    private static List<Integer> list = new ArrayList<>();

    /**
     * ThreadOne遍历集合
     */
    private static class ThreadOne extends Thread {
        @Override
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                int i = iterator.next();
                System.out.println("ThreadOne遍历： " + i);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ThreadTwo集合修改
     */
    private static class ThreadTwo extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < 6) {
                System.out.println("ThreadTwo run: " + i);
                if (i == 3) {
                    list.remove(i);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        new ThreadOne().start();
        new ThreadTwo().start();

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

}
