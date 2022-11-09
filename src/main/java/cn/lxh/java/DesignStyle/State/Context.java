package cn.lxh.java.DesignStyle.State;

/**
 * Created by starlin
 * on 2018/3/18 22:26.
 */
public class Context {
    private State state;
    private String name;

    public Context(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
