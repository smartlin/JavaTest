package cn.lxh.java.DesignStyle.Template;

/**
 * Created by starlin
 * on 2018/3/18 22:13.
 */
public class ConcreteTemplate extends AbstractTemplate {

    @Override
    protected void apply() {
        System.out.println("����ʵ�ֳ��󷽷�");
    }

    public void end() {
        System.out.println("���ǿ��԰� method3 �������ӷ�����ʹ�ã���Ҫ��ʱ��д�Ϳ�����");
    }
}
