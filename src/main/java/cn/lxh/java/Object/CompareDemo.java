package cn.lxh.java.Object;

/**
 * 对象比较
 * this表示当前对象
 * Created by starlin
 * on 2015/10/04 21:48.
 */
class Book{
    private String name;
    private Double price;
    public Book(String name,Double price){
        this.name = name;
        this.price = price;
    }
    public boolean compare(Book book){
        if(book==null){//比较对象为null
            return false;
        }
        if(this==book){//自己和自己比较 this表示当前对象
            return true;
        }
        if(this.name.equals(book.name)&&(this.price.equals(book.price))){
            return true;
        }else{
            return false;
        }
    }
}
public class CompareDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java开发",79.8);
        Book b2 = new Book("Java开发",79.8);
        if(b1.compare(b2)){
            System.out.println("同一个对象");
        }else {
            System.out.println("不是同一个对象");
        }
    }
}
