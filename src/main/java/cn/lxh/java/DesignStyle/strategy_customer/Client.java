package cn.lxh.java.DesignStyle.strategy_customer;

/**
 * Created by starlin
 * on 2016/09/09 15:26.
 */
public class Client {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(500D);
        System.out.println("�ͻ���Ҫ��Ǯ: " + customer.calLastAmout());
        customer.buy(1200D);
        System.out.println("�ͻ���Ҫ��Ǯ: " + customer.calLastAmout());
        customer.buy(1200D);
        System.out.println("�ͻ���Ҫ��Ǯ: " + customer.calLastAmout());
        customer.buy(1200D);
        System.out.println("�ͻ���Ҫ��Ǯ: " + customer.calLastAmout());
    }
}
