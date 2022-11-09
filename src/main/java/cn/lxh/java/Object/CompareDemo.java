package cn.lxh.java.Object;

/**
 * ����Ƚ�
 * this��ʾ��ǰ����
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
        if(book==null){//�Ƚ϶���Ϊnull
            return false;
        }
        if(this==book){//�Լ����Լ��Ƚ� this��ʾ��ǰ����
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
        Book b1 = new Book("Java����",79.8);
        Book b2 = new Book("Java����",79.8);
        if(b1.compare(b2)){
            System.out.println("ͬһ������");
        }else {
            System.out.println("����ͬһ������");
        }
    }
}
