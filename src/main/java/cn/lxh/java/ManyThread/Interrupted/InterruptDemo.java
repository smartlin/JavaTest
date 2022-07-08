package cn.lxh.java.ManyThread.Interrupted;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

/**
 * Created by starlin
 * on 2022/7/5 23:08.
 *
 */
public class InterruptDemo {
    /**
     * ���н������˯��֮ǰ�����жϣ�������ӡ�����жϣ���ʼ˯�ߺ�����������˯�ߣ�ʡ�Ե����м��˯�߹���
     * 1657033829943	|	1	|	main	|	��ʼ˯��
     * 1657033829943	|	1	|	main	|	�����ж�
     * 1657033829943	|	1	|	main	|	����˯��
     */
    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        SmallTool.printTimeAndThread("��ʼ˯��");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("�����ж�");
        }
        SmallTool.printTimeAndThread("����˯��");
    }
}
