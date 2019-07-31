package cn.lxh.java.DesignStyle.duty;

/**
 * Created by starlin
 * on 2016/09/14 16:05.
 * 分店接口（相当于Hanlder）
 */
public interface Subbranch {

    void setSuccessor(Subbranch subbranch);

    boolean handleOrder(Order order);
}
