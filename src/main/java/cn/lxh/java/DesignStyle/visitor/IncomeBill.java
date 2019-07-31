package cn.lxh.java.DesignStyle.visitor;

/**
 * Created by starlin
 * on 2016/09/21 11:16.
 */
public class IncomeBill implements Bill {

    private double amount;

    private String item;

    public IncomeBill(double amount, String item) {
        this.amount = amount;
        this.item = item;
    }

    @Override
    public void accept(AccountBookViewer viewer) {
        viewer.view(this);
    }

    public double getAmount() {
        return amount;
    }

    public String getItem() {
        return item;
    }
}
