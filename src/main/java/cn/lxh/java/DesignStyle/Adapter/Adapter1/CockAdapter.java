package cn.lxh.java.DesignStyle.Adapter.Adapter1;

/**
 * Created by starlin
 * on 2018/3/18 19:04.
 * Ѽ�ӿ��� fly() �� quare() ������������ Cock ���Ҫð��Ѽ��fly() �������ֳɵģ�
 * ���Ǽ�����Ѽ�����ɽУ�û�� quack() ���������ʱ�����Ҫ�����ˣ�
 */
public class CockAdapter implements Duck {

    Cock cock;

    // ���췽������Ҫһ������ʵ����������ǽ���ֻ�������Ѽ����
    public CockAdapter(Cock cock) {
        this.cock = cock;
    }

    // ʵ��Ѽ�����ɽз���
    @Override
    public void quack() {
        cock.gobble();
    }

    @Override
    public void fly() {
        cock.fly();
    }
}
