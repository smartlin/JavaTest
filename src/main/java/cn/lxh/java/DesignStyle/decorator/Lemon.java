package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:12.
 * װ���� ����
 */
public class Lemon extends Condiment {

    private Beverage beverage;
    // ����ܹؼ�����Ҫ�����������ϣ�����Ҫ����û�б�װ�εĺ����̲裬
    // ��ȻҲ���Դ����Ѿ�װ�κõ�â���̲裬����������â�������̲�

    public Lemon(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        //װ��
        return beverage.getDescription() + "������";
    }

    @Override
    public double cost() {
        //װ�� ���������2Ԫ
        return beverage.cost() + 2;
    }
}
