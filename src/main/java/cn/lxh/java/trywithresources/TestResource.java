package cn.lxh.java.trywithresources;

//����ʵ���� AutoCloseable �ӿڵ���Դ������ʹ�� try-with-resources ���ͷ���Դ
public class TestResource implements AutoCloseable {
    public void read() throws Exception {
        throw new Exception("read error");
    }

    @Override
    public void close() throws Exception {
        throw new Exception("close error");
    }

    public static void main(String[] args) throws Exception{
        try (TestResource testResource = new TestResource()) {
            testResource.read();
        }
    }
}