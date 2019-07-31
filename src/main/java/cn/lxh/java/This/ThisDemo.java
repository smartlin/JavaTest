package cn.lxh.java.This;

/**
 * this调用构造方法
 * Created by starlin
 * on 2015/10/05 17:12.
 */
class Book{
    private String title;
    private Double price;
    public Book(){
        System.out.println("*********");
    }
    public Book(String title){
        this();//this调用构造方法必须放在构造方法内的首行，而且必须要有出口
        this.title = title;

    }
    public Book(String title,Double price){
        this(title);
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + "价格：" + this.price;
    }
}
public class ThisDemo {
    public static void main(String[] args) {
        Book b = new Book("java",20.0);
        System.out.println(b.toString());
    }

}
