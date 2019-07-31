package cn.lxh.java.DesignStyle.State;

/**
 * Created by starlin
 * on 2018/3/18 22:29.
 * ¶¨Òå¼õ¿â´æµÄ×´Ì¬
 */
public class DeductState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("¼õ¿â´æ");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "¼õ¿â´æ state";
    }
}
