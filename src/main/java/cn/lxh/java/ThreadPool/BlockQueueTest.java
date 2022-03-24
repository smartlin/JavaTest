package cn.lxh.java.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * ����һ������Ϊ 5 �Ķ��У�Ȼ����ѭ��������� put ����������������֮�󣬳��������ס�ˡ�
 * ͨ�� dump ��ǰ�߳̿���֪�����߳�ȷʵ��������������ǰ������ĵط���
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>(5);
        for(int i = 0;i< 10;i++){
            System.out.println("��ʼִ��linkedBlockingQueue.put(" + i + ") ");
            blockingQueue.put(i);
            System.out.println("linkedBlockingQueue.put("+ i +") �ɹ�," + "ʣ�����ԣ�"+blockingQueue.remainingCapacity());
        }
    }
}