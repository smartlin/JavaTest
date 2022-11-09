package cn.lxh.java.DesignStyle.visitor;

/**
 * Created by starlin
 * on 2016/09/21 11:19.
 */
//老板类，查看账本的类之一
public class Boss implements AccountBookViewer{

    private double totalIncome;

    private double totalConsume;

    @Override
    public void view(ConsumeBill bill) {
        totalConsume += bill.getAmount();
    }

    @Override
    public void view(IncomeBill bill) {
        totalIncome += bill.getAmount();
    }

    public double getTotalIncome() {
        System.out.println("老板查看一共收入多少，数目是：" + totalIncome);
        return totalIncome;
    }

    public double getTotalConsume() {
        System.out.println("老板查看一共花费多少，数目是：" + totalConsume);
        return totalConsume;
    }
}
