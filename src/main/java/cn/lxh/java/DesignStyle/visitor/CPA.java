package cn.lxh.java.DesignStyle.visitor;

/**
 * Created by starlin
 * on 2016/09/21 11:22.
 */

//注册会计师类，查看账本的类之一
public class CPA implements AccountBookViewer {


    @Override
    public void view(ConsumeBill bill) {
        if (bill.getItem().equals("工资")) {
            System.out.println("注会查看账本时，如果单子的消费目的是发工资，则注会会查看有没有交个人所得税。");
        }
    }

    @Override
    public void view(IncomeBill bill) {
        System.out.println("注会查看账本时，只要是收入，注会都要查看公司交税了没。");
    }
}
