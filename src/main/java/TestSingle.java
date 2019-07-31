/**
 * Created by starlin
 * on 2017/09/05 20:44.
 */
public class TestSingle {
    private TestSingle(){
    }
    private static class TestSingleInstance{
        private static final TestSingle instance = new TestSingle();
    }
    private static  TestSingle getInstance(){
        return TestSingleInstance.instance;
    }
}
