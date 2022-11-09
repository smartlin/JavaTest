package cn.lxh.java.ManyThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Execution框架
 * Created by starlin
 * on 2016/06/15 20:06.
 */
public class ExecutionTest {
    //基于线程池的Web服务器
    private static final int NTHREAND = 100;
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(NTHREAND);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while(true){
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
       //             handleRequest(connection);
                }
            };
            EXECUTOR.execute(task);
        }
    }
}
