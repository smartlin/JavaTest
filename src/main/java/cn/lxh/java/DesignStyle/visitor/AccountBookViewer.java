package cn.lxh.java.DesignStyle.visitor;

/**
 * Created by starlin
 * on 2016/09/21 11:18.
 */

//账单查看者接口（相当于Visitor）
public interface AccountBookViewer {

    //查看消费的单子
    public void view(ConsumeBill bill);

    //查看收入单子
    public void view(IncomeBill bill);

}
