package cn.lxh.java.DesignStyle.command;

/**
 * Created by starlin
 * on 2016/09/10 13:22.
 */
public class Demand implements Task {

    private Programmer programmer;

    public Demand(Programmer programmer) {
        this.programmer = programmer;
    }

    @Override
    public void handle() {
        programmer.handleDemand();
    }

    @Override
    public String toString() {
        return "Demand{" +
                "programmer=" + programmer.getName() +
                '}';
    }
}
