package cn.lxh.java.DesignStyle.State;

/**
 * Created by starlin
 * on 2018/3/18 22:33.
 * 状态模式
 */
public class Test {
    public static void main(String[] args) {

        Context context = new Context("Iphone x");

        //补库存操作
        State state = new RevertState();
        state.doAction(context);

        //减库存操作
        State state1 = new DeductState();
        state1.doAction(context);

        //也嫩获取当前状态
        context.getState().toString();
    }
}
