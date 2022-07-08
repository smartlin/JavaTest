package cn.lxh.java.ManyThread.Interrupted;

import cn.lxh.java.ManyThread.CompletableFuture.SmallTool;

/**
 * Created by starlin
 * on 2022/7/5 23:08.
 *
 */
public class InterruptDemo {
    /**
     * 运行结果：在睡眠之前发生中断，正常打印发生中断，开始睡眠后立即结束了睡眠，省略掉了中间的睡眠过程
     * 1657033829943	|	1	|	main	|	开始睡眠
     * 1657033829943	|	1	|	main	|	发生中断
     * 1657033829943	|	1	|	main	|	结束睡眠
     */
    public static void main(String[] args) {
        Thread.currentThread().interrupt();

        SmallTool.printTimeAndThread("开始睡眠");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            SmallTool.printTimeAndThread("发生中断");
        }
        SmallTool.printTimeAndThread("结束睡眠");
    }
}
