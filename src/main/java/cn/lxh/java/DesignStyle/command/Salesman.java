package cn.lxh.java.DesignStyle.command;

//业务员
public class Salesman {

    private String name;

    private ProductManager productManager;

    public Salesman(String name) {
        super();
        this.name = name;
    }

    public Salesman(String name, ProductManager productManager) {
        this.name = name;
        this.productManager = productManager;
    }

    public String getName() {
        return name;
    }

    public void putDemand(){
        System.out.println( "业务员" + name + "提出新需求");
        productManager.receive(new Demand(productManager.chooseProgrammer()));
    }

    public void putBug(){
        System.out.println( "业务员" + name + "提出bug");
        productManager.receive(new Bug(productManager.chooseProgrammer()));
    }

    public void putProblem(){
        System.out.println( "业务员" + name + "提出线上问题");
        productManager.receive(new Problem(productManager.chooseProgrammer()));
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}