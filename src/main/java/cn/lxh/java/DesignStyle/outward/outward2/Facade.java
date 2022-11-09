package cn.lxh.java.DesignStyle.outward.outward2;

/**
 * Created by starlin
 * on 2018/3/17 22:08.
 * Õ‚π€¿‡
 */
public class Facade {
    private SubSystemA subSystemA = new SubSystemA();
    private SubSystemB subSystemB = new SubSystemB();
    private SubSystemC subSystemC = new SubSystemC();

    public void Method() {
        subSystemA.MethodA();
        subSystemB.MethodB();
        subSystemC.MethodC();
    }
}
