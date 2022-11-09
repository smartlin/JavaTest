package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/8/25 10:55.
 * 对象在被GC时自我拯救
 * 这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
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

        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所有暂停以等待
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead");
        }

        // 下面的代码与上面完全相同，但是这次却拯救失败了
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
