package cn.lxh.java.DesignStyle.State;

/**
 * Created by starlin
 * on 2018/3/18 22:31.
 * ¶¨Òå²¹¿â´æµÄ×´Ì¬
 */
public class RevertState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("²¹¿â´æ");
        context.setState(this);
    }

    public String toString() {
        return "²¹¿â´æ state";
    }
}
