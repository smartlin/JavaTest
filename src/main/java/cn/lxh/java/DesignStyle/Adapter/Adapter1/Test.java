package cn.lxh.java.DesignStyle.Adapter.Adapter1;

/**
 * Created by starlin
 * on 2018/3/18 19:06.
 */
public class Test {
    public static void main(String[] args) {
        // ��һֻҰ��
        Cock cock = new WildCock();
        // ��Ұ�������Ѽ
        Duck duck = new CockAdapter(cock);
        cock.gobble();
    }
}
