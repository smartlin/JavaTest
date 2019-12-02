package cn.lxh.java.ManyThread;

/**
 * 生产者与消费者模型
 * Created by starlin
 * on 2015/10/09 22:36.
 */
class Info{
    private String title;
    private String content;
    private boolean flag = true;//设置一个标识，为true表示可以生产，不能取；false表示不能生产，能取

    public synchronized void set(String title,String content){
        while (flag == false){//flag等于false 执行等待 而且此处一定要使用while循环
            try {
                super.wait();//wait方法为Object中的方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            this.title = title;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.content = content;
            System.out.println(Thread.currentThread().getName() + "--生产者---" + this.title + "--" + this.content);
            flag = false;//修改生产标志
            super.notifyAll();//唤醒其他等待 此处也一定是notifyAll方法


    }
    public synchronized void get(){
        while(flag==true) {//还没生产 需要等待 而且此处一定要使用while循环
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "消费者" + this.title + "--" + this.content);
            this.flag = true;
            super.notifyAll();//此处也一定是notifyAll方法
    }


}

class Product implements Runnable{//生产者
    private Info info;
    public Product(Info info){
        this.info = info;
    }

    @Override
    public void run() {
        for(int i = 0 ;i<10;i++){
//            if(i%2==0){
                this.info.set("starlin-----------", "帅哥");
//            }else{
//                this.info.set("smart", "美女");
//            }
        }

    }
}

class Customer implements Runnable{//消费者
    private Info info;
    public Customer(Info info){
        this.info = info;
    }
    @Override
    public void run() {
        for(int i = 0;i<100;i++){
           this.info.get();
        }

    }
}
public class CustumerAndProductDemo {
    public static void main(String[] args) throws Exception{
        Info in = new Info();
        Product pro = new Product(in);
        Customer cus = new Customer(in);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(pro);
        Thread t3 = new Thread(cus);
        Thread t4 = new Thread(cus);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println(t1.isAlive());
//        new ManyThread(new Product(in)).start();
//        new ManyThread(new Customer(in)).start();
    }
}
