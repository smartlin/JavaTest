package cn.lxh.java.DesignStyle.State;

/**
 * Created by starlin
 * on 2018/3/18 22:31.
 * ���岹����״̬
 */
public class RevertState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("�����");
        context.setState(this);
    }

    public String toString() {
        return "����� state";
    }
}
