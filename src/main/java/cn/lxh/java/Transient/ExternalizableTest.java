package cn.lxh.java.Transient;

import java.io.*;

/**
 * 另外一种序列化方式Externalizable
 * 若实现的是Externalizable接口，则没有任何东西可以自动序列化，
 * 需要在writeExternal方法中进行手工指定所要序列化的变量，这与是否被transient修饰无关
 * Created by starlin
 * on 2018/4/28 9:49.
 */
public class ExternalizableTest implements Externalizable {

    private transient String content = "xxxx";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {
        ExternalizableTest test = new ExternalizableTest();
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(new File("test")));
        objectOutput.writeObject(test);

        ObjectInput objectInput = new ObjectInputStream(new FileInputStream(new File("test")));
        test = (ExternalizableTest) objectInput.readObject();

        System.out.println(test.content);

        objectOutput.close();
        objectInput.close();
    }
}
