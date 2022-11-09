package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/8/25 10:55.
 * �����ڱ�GCʱ��������
 * �����ԾȵĻ���ֻ��һ�Σ���Ϊһ�������finalize()�������ֻ�ᱻϵͳ�Զ�����һ��
 */
public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize menthod executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // �����һ�������Լ�
        SAVE_HOOK = null;
        System.gc();
        // ��Ϊfinalize�������ȼ��ܵͣ�������ͣ�Եȴ�
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead");
        }

        // ����Ĵ�����������ȫ��ͬ���������ȴ����ʧ����
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead");
        }
    }
}
