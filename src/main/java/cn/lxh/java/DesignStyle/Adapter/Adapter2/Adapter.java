package cn.lxh.java.DesignStyle.Adapter.Adapter2;

/**
 * Created by starlin
 * on 2018/3/18 12:38.
 * ÊÊÅäÆ÷Àà
 *
 */
public class Adapter extends Target{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
