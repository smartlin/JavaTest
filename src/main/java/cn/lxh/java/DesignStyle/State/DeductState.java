package cn.lxh.java.DesignStyle.State;

/**
 * Created by starlin
 * on 2018/3/18 22:29.
 * ���������״̬
 */
public class DeductState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("�����");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "����� state";
    }
}
