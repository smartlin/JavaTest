package cn.lxh.java.DesignStyle.visitor;

public class Client {

    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        //添加两条收入
        accountBook.addBill(new IncomeBill(10000, "卖商品"));
        accountBook.addBill(new IncomeBill(12000, "卖广告位"));
        //添加两条支出
        accountBook.addBill(new ConsumeBill(1000, "工资"));
        accountBook.addBill(new ConsumeBill(2000, "材料费"));
        
        AccountBookViewer boss = new Boss();
        AccountBookViewer cpa = new CPA();
        
        //两个访问者分别访问账本
        accountBook.show(cpa);
        accountBook.show(boss);
        
        ((Boss) boss).getTotalConsume();
        ((Boss) boss).getTotalIncome();
    }
}