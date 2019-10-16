package cn.lxh.java.ManyThread;

/**
 * ��������������ģ��
 * Created by starlin
 * on 2015/10/09 22:36.
 */
class Info{
    private String title;
    private String content;
    private boolean flag = true;//����һ����ʶ��Ϊtrue��ʾ��������������ȡ��false��ʾ������������ȡ

    public synchronized void set(String title,String content){
        while (flag == false){//flag����false ִ�еȴ� ���Ҵ˴�һ��Ҫʹ��whileѭ��
            try {
                super.wait();//wait����ΪObject�еķ���
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
            System.out.println(Thread.currentThread().getName() + "--������---" + this.title + "--" + this.content);
            flag = false;//�޸�������־
            super.notifyAll();//���������ȴ� �˴�Ҳһ����notifyAll����


    }
    public synchronized void get(){
        while(flag==true) {//��û���� ��Ҫ�ȴ� ���Ҵ˴�һ��Ҫʹ��whileѭ��
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

            System.out.println(Thread.currentThread().getName() + "������" + this.title + "--" + this.content);
            this.flag = true;
            super.notifyAll();//�˴�Ҳһ����notifyAll����
    }


}

class Product implements Runnable{//������
    private Info info;
    public Product(Info info){
        this.info = info;
    }

    @Override
    public void run() {
        for(int i = 0 ;i<10;i++){
//            if(i%2==0){
                this.info.set("starlin-----------", "˧��");
//            }else{
//                this.info.set("smart", "��Ů");
//            }
        }

    }
}

class Customer implements Runnable{//������
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
