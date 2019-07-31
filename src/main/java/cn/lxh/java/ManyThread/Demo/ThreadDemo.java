package cn.lxh.java.ManyThread.Demo;

/**
 * �ȴ����ѻ���
 * Created by starlin
 * on 2015/10/26 11:51.
 */
class Res{
    private String name;
    private String age;
    private boolean flag = false;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class Input implements Runnable{
    private Res res;
    public Input(Res res){
        this.res = res;
    }

    @Override
    public void run() {
        int x = 0 ;
        while (true) {
            synchronized(res) {//this�ڴ˴����У���Ϊthisָ���Ǳ������,��res��Ψһ����
                if(res.isFlag()){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x == 0) {
                    res.setName("mike");
                    res.setAge("20");
                } else {
                    res.setName("�Ա�");
                    res.setAge("ŮŮŮŮŮŮ");
                }
                x = (x + 1) % 2;
                res.setFlag(true);
                res.notify();
            }
        }
    }
}
class Output implements Runnable{
    private Res res;
    public Output(Res res){
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            synchronized (res){//this�ڴ˴����У���Ϊthisָ���Ǳ������,��res��Ψһ����
                if(!res.isFlag()){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(res.getName()+"......."+res.getAge());
                res.setFlag(false);
                res.notify();
            }
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) {
        Res res = new Res();
        new Thread(new Input(res)).start();
        new Thread(new Output(res)).start();
    }
}
