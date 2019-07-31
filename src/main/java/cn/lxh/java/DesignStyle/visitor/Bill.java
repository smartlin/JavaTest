package cn.lxh.java.DesignStyle.visitor;

/**
 * Created by starlin
 * on 2016/09/21 11:13.
 * 设计模式--访问者模式
 */

//单个单子的接口（相当于Element）
public interface Bill {
    public void accept(AccountBookViewer viewer);
}
