package cn.lxh.java.JVM;

/**
 * Created by starlin
 * on 2018/8/24 22:00.
 * intern()�������Ȳ�ѯ���������Ƿ��Ѿ����ڣ���������򷵻س������е�����
 * ��JDK1.7֮��������������Ҳ�����Ӧ���ַ������򲻻��ڽ��ַ���������������
 * ��ֻ���ڳ�����������һ����ԭ�ַ���������
 */
public class InternDemo {
    public static void main(String[] args) {

        String str3 = new StringBuilder("sss").append("xxx").toString();
        String str2 = str3.intern();
        System.out.println(str2 == str3);
        //
        //String s1=new String("kvill");
        //String s2=s1.intern();
        //System.out.println(s2.intern() == s2);
        //
        //String s3=new String("kill");
        //String s4=s3.intern();
        //System.out.println(s3.intern() == s4);

        String str1 = new StringBuffer("ja").append("va").toString();
        String str4 = str1.intern();
        System.out.println(str4 == str1);


    }
}
