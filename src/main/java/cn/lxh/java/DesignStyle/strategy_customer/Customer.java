package cn.lxh.java.DesignStyle.strategy_customer;

/**
 * Created by starlin
 * on 2016/09/09 15:11.
 * 客户类
 */
public class Customer {
    private Double totalAmount = 0D;//客户在店消费总额
    private Double amount = 0D;//客户单次消费金额
    private CalPrice calPrice = new Common();//每个客户都有一个计算价格的策略，初始都是普通计算，即原价

    public void buy(Double amount){
        this.amount = amount;
        totalAmount += amount;
       /* if(totalAmount > 3000){
            calPrice = new GoldVip();//3000则改为金牌会员计算方式
        }else if(totalAmount > 2000){
            calPrice = new SuperVip();
        }else if(totalAmount > 1000){
            calPrice = new Vip();
        }*/
      //使用简单工厂CalPriceFactory来改进上面的if else
        calPrice = CalPriceFactory.createCalPrice(this);
    }

    //计算客户最终要付的钱
    public Double calLastAmout(){
        return calPrice.calPrice(amount);
    }

    //使用简单工厂CalPriceFactory来改进上面的if else
    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getAmount() {
        return amount;
    }
}
