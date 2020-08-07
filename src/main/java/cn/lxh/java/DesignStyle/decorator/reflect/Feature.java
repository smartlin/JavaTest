package cn.lxh.java.DesignStyle.decorator.reflect;

/**
 * Created by starlin
 * on 2019/9/21 16:03.
 * ���÷���ʵ�ֵ�װ����ģʽ
 */
public interface Feature {
    //����ĳ������
    public void load();
}

class FlyFeature implements Feature {

    // �����ɵ�����
    @Override
    public void load() {
        System.out.println("����һ˫���");
    }
}

class DigFeature implements Feature {

    //�����������
    @Override
    public void load() {
        System.out.println("�����������");
    }
}
