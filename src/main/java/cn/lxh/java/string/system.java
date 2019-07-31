package cn.lxh.java.string;

/**
 * Created by 1762 on 2015/09/05.
 */
public class system {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());//取得当前时间 毫秒
        long start = System.currentTimeMillis();
        String str = "";
        for(int i=0 ; i < 3000; i++){
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("操作时间：" + (end - start));//取得所用时间
    }
}
