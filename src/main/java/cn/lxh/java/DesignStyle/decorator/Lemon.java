package cn.lxh.java.DesignStyle.decorator;

/**
 * Created by starlin
 * on 2018/3/18 21:12.
 * 装饰者 柠檬
 */
public class Lemon extends Condiment {

    private Beverage beverage;
    // 这里很关键，需要传入具体的饮料，如需要传入没有被装饰的红茶或绿茶，
    // 当然也可以传入已经装饰好的芒果绿茶，这样可以做芒果柠檬绿茶

    public Lemon(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        //装饰
        return beverage.getDescription() + "加柠檬";
    }

    @Override
    public double cost() {
        //装饰 加柠檬需加2元
        return beverage.cost() + 2;
    }
}
