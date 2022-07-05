package cn.lxh.java.ManyThread.CompletableFuture;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by starlin
 * on 2022/7/4 11:17.
 * 6��6�̺߳�6��12�߳�����
 * ������6��6�߳��൱�� 6������̨��6����ʦ
 *      6��12�߳��൱�� 6��˫��̨��6����ʦ
 */
public class GetCpuPoolSize {
    public static void main(String[] args) {
        // Returns the number of processors available to the Java virtual machine.
        System.out.println(Runtime.getRuntime().availableProcessors());

        // �鿴��ǰ�߳���
        System.out.println(ForkJoinPool.commonPool().getPoolSize());

        //�鿴����߳���
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }
}
