package cn.lxh.java.trywithresources;

//对于实现了 AutoCloseable 接口的资源，建议使用 try-with-resources 来释放资源
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