package cn.lxh.java.DesignStyle.Adapter.Adapter1;

/**
 * Created by starlin
 * on 2018/3/18 19:06.
 */
public class Test {
    public static void main(String[] args) {
        // 有一只野鸡
        Cock cock = new WildCock();
        // 将野鸡适配成鸭
        Duck duck = new CockAdapter(cock);
        cock.gobble();
    }
}
